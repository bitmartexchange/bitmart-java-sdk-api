package com.bitmart.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.common.JsonUtils;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.key.CloudSignature;
import com.google.common.collect.ImmutableList;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WebSocketClient {
    private static final Logger log = LoggerFactory.getLogger(WebSocketClient.class);
    private EventLoopGroup group;
    Channel clientChannel;
    CloudKey cloudKey;
    private SslContext sslContext;
    private URI uri;
    private String host;
    private int port;
    final List<String> reconnectionChannel = new ArrayList<>();
    boolean reconnectionUseLogin = false;
    boolean isClose = false;
    boolean isSpot = true;

    public WebSocketCallBack callBack;

    public WebSocketClient(WebSocketCallBack callBack) throws CloudException {
        init(GlobalConst.CLOUD_WS_URL, null, callBack);
    }


    public WebSocketClient(CloudKey cloudKey, WebSocketCallBack callBack) throws CloudException {
        init(GlobalConst.CLOUD_WS_URL, cloudKey, callBack);
    }


    public WebSocketClient(String url, WebSocketCallBack callBack) throws CloudException {
        init(url, null, callBack);
    }


    public WebSocketClient(String url, CloudKey cloudKey, WebSocketCallBack callBack) throws CloudException {
        init(url, cloudKey, callBack);
    }


    private void init(String url, CloudKey cloudKey, WebSocketCallBack callBack) throws CloudException {
        this.cloudKey = cloudKey;
        this.callBack = callBack;
        try {
            this.uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new CloudException("URISyntaxException" + e.getMessage());
        }
        this.host = uri.getHost() == null ? "127.0.0.1" : uri.getHost();
        String scheme = uri.getScheme() == null ? "ws" : uri.getScheme();

        if (uri.getPort() == -1) {
            if ("ws".equalsIgnoreCase(scheme)) {
                this.port = 80;
            } else if ("wss".equalsIgnoreCase(scheme)) {
                this.port = 443;
            } else {
                this.port = -1;
            }
        } else {
            this.port = uri.getPort();
        }


        if (!"ws".equalsIgnoreCase(scheme) && !"wss".equalsIgnoreCase(scheme)) {
            throw new CloudException("Only WS(S) is supported." + url);
        }

        final boolean ssl = "wss".equalsIgnoreCase(scheme);
        if (ssl) {
            try {
                this.sslContext = SslContextBuilder.forClient()
                        .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
            } catch (SSLException e) {
                throw new CloudException("SSLException:" + e.getMessage());
            }
        }

        connection();
    }


    private void connection() throws CloudException {
        try {
            if (this.group == null) {
                this.group = new NioEventLoopGroup();
            }

            final WebSocketClientHandler handler =
                    new WebSocketClientHandler(
                            WebSocketClientHandshakerFactory.newHandshaker(
                                    uri, WebSocketVersion.V13, null, false, new DefaultHttpHeaders()),
                            this);
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            if (sslContext != null) {
                                p.addLast(sslContext.newHandler(ch.alloc(), host, port));
                            }
                            p.addLast(
                                    new HttpClientCodec(),
                                    new HttpObjectAggregator(8192),
                                    handler);
                        }
                    });

            this.clientChannel = bootstrap.connect(uri.getHost(), port).sync().channel();

            handler.handshakeFuture().sync();

            keepalive();
        } catch (Exception e) {
            throw new CloudException(e.getMessage());
        }
    }

    public void reconnection() {
        try {
            log.info("WebSocket Client Reconnection to {}", this.uri.toString());

            connection();

            if (this.reconnectionUseLogin) {
                this.login();
            }

            if (!CollectionUtils.isEmpty(this.reconnectionChannel)) {
                int count = 0;
                for (String channel : this.reconnectionChannel) {
                    this.clientChannel.writeAndFlush(new TextWebSocketFrame(channel));
                    count++;

                    if (count % 100 == 0) {
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException e) { }
                    }
                }
            }
        } catch (CloudException e) {
            e.printStackTrace();
        }
    }

    public void login() throws CloudException {
        this.reconnectionUseLogin = true;
        CloudSignature.Signature signature = CloudSignature.create(
                "bitmart.WebSocket",
                this.cloudKey.getApiSecret(),
                this.cloudKey.getMemo());

        OpParam opParam = new OpParam().setOp("login").setArgs(ImmutableList.of(
                this.cloudKey.getApiKey(),
                signature.getTimestamp(),
                signature.getSign()
        ));

        String param = JsonUtils.toJson(opParam);
        log.debug("WebSocket Client Send:{}", param);

        this.clientChannel.writeAndFlush(new TextWebSocketFrame(param));

        // Waiting for login result
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) { }
    }


    public void send(String message) {
        if (!this.reconnectionChannel.contains(message)) {
            this.reconnectionChannel.add(message);
        }
        this.clientChannel.writeAndFlush(new TextWebSocketFrame(message));
    }

    public void send(OpParam opParam) {
        String param = JsonUtils.toJson(opParam);
        if (log.isDebugEnabled()) {
            log.debug("WebSocket Client Send:{}", param);
        }
        send(param);
    }


    void keepalive() {
        Channel channel = this.clientChannel;
        new Timer("WebSocket-Keepalive").schedule(new TimerTask() {
            @Override
            public void run() {
                if (channel.isActive()) {
                    channel.writeAndFlush(new TextWebSocketFrame("ping"));
                }
            }
        }, 2000, 10000);
    }

    public void stop(String reason) {
        log.error("WebSocket Client Stop. reason={}", reason);
        this.isClose = true;
        this.clientChannel.close();
        this.group.shutdownGracefully();
    }


    public boolean isClose()  {
        return this.isClose;
    }
}

