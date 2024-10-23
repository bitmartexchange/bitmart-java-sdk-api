package com.bitmart.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.JsonUtils;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.key.CloudSignature;
import com.bitmart.websocket.contract.ActionParam;
import com.google.common.collect.ImmutableList;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
public class ContractWebSocket extends WebSocketClient{
    private static final Logger log = LoggerFactory.getLogger(ContractWebSocket.class);
    public ContractWebSocket(String url, WebSocketCallBack callBack) throws CloudException {
        super(url, null, callBack);
        this.isSpot = false;
    }

    public ContractWebSocket(String url, CloudKey cloudKey, WebSocketCallBack callBack) throws CloudException {
        super(url, cloudKey, callBack);
        this.isSpot = false;
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
        if (log.isDebugEnabled()) {
            log.debug("WebSocket Client Send:{}", param);
        }

        this.clientChannel.writeAndFlush(new TextWebSocketFrame(param));

        // Waiting for login result
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) { }
    }

    public void send(ActionParam actionParam) {
        String param = JsonUtils.toJson(actionParam);
        if (log.isDebugEnabled()) {
            log.debug("WebSocket Client Send:{}", param);
        }
        send(param);
    }

    @Override
    void keepalive() {
        Channel channel = this.clientChannel;
        new Timer("WebSocket-Keepalive").schedule(new TimerTask() {
            @Override
            public void run() {
                if (channel.isActive()) {
                    channel.writeAndFlush(new TextWebSocketFrame("{\"action\":\"ping\"}"));
                }
            }
        }, 2000, 10000);
    }
}

