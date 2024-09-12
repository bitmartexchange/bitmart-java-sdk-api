package com.bitmart.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.JsonUtils;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.key.CloudSignature;
import com.bitmart.websocket.contract.ActionParam;
import com.google.common.collect.ImmutableList;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
public class ContractWebSocket extends WebSocketClient{
    private static final Logger log = LoggerFactory.getLogger(ContractWebSocket.class);
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

        // Waiting for login result
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) { }
    }

    @Override
    public void subscribe(List<String> channels)  {
        for(String channel: channels) {
            if (!this.reconnectionChannel.contains(channel)) {
                this.reconnectionChannel.add(channel);
            }
        }

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
                    channel.writeAndFlush(new PingWebSocketFrame());
                }
            }
        }, 2000, 10000);
    }
}

