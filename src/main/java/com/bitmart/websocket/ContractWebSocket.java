package com.bitmart.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.common.JsonUtils;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.key.CloudSignature;
import com.bitmart.websocket.contract.ActionParam;
import com.bitmart.websocket.contract.PingParam;
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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import javax.net.ssl.SSLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class ContractWebSocket extends WebSocketClient{

    public ContractWebSocket(String url, WebSocketCallBack callBack) throws CloudException, URISyntaxException, SSLException {
        super(url, null, callBack);
    }

    public ContractWebSocket(String url, CloudKey cloudKey, WebSocketCallBack callBack) throws CloudException, URISyntaxException, SSLException {
        super(url, cloudKey, callBack);
    }

    @Override
    public void login() throws CloudException {
        this.reconnectionUseLogin = true;
        CloudSignature.Signature signature = CloudSignature.create(
                "bitmart.WebSocket",
                this.cloudKey.getApiSecret(),
                this.cloudKey.getMemo());

        ActionParam actionParam = new ActionParam().setAction("access").setArgs(ImmutableList.of(
                this.cloudKey.getApiKey(),
                signature.getTimestamp(),
                signature.getSign(),
                "web"
        ));

        String param = JsonUtils.toJson(actionParam);
        if (isPrint) {
            log.info("WebSocket Client Send:{}", param);
        }

        this.clientChannel.writeAndFlush(new TextWebSocketFrame(param));
    }

    @Override
    public void subscribe(List<String> channels)  {
        this.reconnectionChannel.addAll(channels);
        ActionParam actionParam = new ActionParam().setAction("subscribe").setArgs(channels);

        String param = JsonUtils.toJson(actionParam);
        if (isPrint) {
            log.info("WebSocket Client Send:{}", param);
        }

        this.clientChannel.writeAndFlush(new TextWebSocketFrame(param));
    }

    @Override
    void keepalive() {
        Channel channel = this.clientChannel;
        new Timer("WebSocket-Keepalive").schedule(new TimerTask() {
            @Override
            public void run() {
                if (channel.isActive()) {
                    PingParam pingParam = new PingParam().setSubscribe("ping");

                    String param = JsonUtils.toJson(pingParam);
                    if (isPrint) {
                        log.info("WebSocket Client Send:{}", param);
                    }
                    channel.writeAndFlush(new TextWebSocketFrame(param));
                }
            }
        }, 2000, 10000);
    }
}

