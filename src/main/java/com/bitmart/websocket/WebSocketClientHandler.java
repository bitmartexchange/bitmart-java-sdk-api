package com.bitmart.websocket;

import com.bitmart.api.common.JsonUtils;
import com.bitmart.api.common.StringCompress;
import io.netty.channel.*;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class WebSocketClientHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger log = LoggerFactory.getLogger(WebSocketClientHandler.class);
    private final WebSocketClientHandshaker handShaker;
    private final WebSocketClient webSocketClient;
    private ChannelPromise handshakeFuture;


    public WebSocketClientHandler(WebSocketClientHandshaker handShaker, WebSocketClient webSocketClient) {
        this.handShaker = handShaker;
        this.webSocketClient = webSocketClient;
    }

    public ChannelFuture handshakeFuture() {
        return handshakeFuture;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        handshakeFuture = ctx.newPromise();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        handShaker.handshake(ctx.channel());
        log.debug("WebSocket Client Connecting to {}", handShaker.uri().toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.debug("WebSocket Client disconnected! {}", handShaker.uri().toString());

        if (this.webSocketClient.isClose()) {
            return ;
        }

        final EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(() -> webSocketClient.reconnection(), 10L, TimeUnit.SECONDS);

    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel ch = ctx.channel();
        if (!handShaker.isHandshakeComplete()) {
            try {
                handShaker.finishHandshake(ch, (FullHttpResponse) msg);
                log.debug("WebSocket Client connected!");
                handshakeFuture.setSuccess();
            } catch (WebSocketHandshakeException e) {
                log.debug("WebSocket Client failed to connect");
                handshakeFuture.setFailure(e);
            }
            return;
        }

        if (msg instanceof WebSocketFrame) {
            WebSocketFrame frame = (WebSocketFrame) msg;

            if (frame instanceof TextWebSocketFrame) {
                TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
                String message = textFrame.text();

                if("pong".equals(message)) {
                    log.debug("WebSocket Client received pong");
                    return ;
                }
                onMessage(message);
            } else if (frame instanceof BinaryWebSocketFrame) {
                BinaryWebSocketFrame binaryWebSocketFrame = (BinaryWebSocketFrame) frame;
                onMessage(StringCompress.decode(binaryWebSocketFrame.content()));
            } else if (frame instanceof PongWebSocketFrame) {
                if(log.isDebugEnabled()) {
                    log.debug("WebSocket Client received pong");
                }
            } else if (frame instanceof CloseWebSocketFrame) {
                log.info("WebSocket Client received closing");
                ch.close();
            }
        }

    }

    private void onMessage(String message) {
        if(log.isDebugEnabled()) {
            log.debug("WebSocket Client received message:{}", message);
        }

        this.webSocketClient.callBack.onMessage(message);

        if (this.webSocketClient.reconnectionUseLogin) {
            if (this.webSocketClient.isSpot) {
                String event = JsonUtils.fromJson(message, "event");
                if ("login".equals(event)) {
                    String errorMessage = JsonUtils.fromJson(message, "errorMessage");
                    if (StringUtils.isNotBlank(errorMessage)) {
                        this.webSocketClient.stop("login failed, errorMessage=" + errorMessage);
                    }
                }
            } else {
                String event = JsonUtils.fromJson(message, "action");
                if ("access".equals(event)) {
                    String errorMessage = JsonUtils.fromJson(message, "error");
                    if (StringUtils.isNotBlank(errorMessage)) {
                        this.webSocketClient.stop("login failed, errorMessage=" + errorMessage);
                    }
                }
            }

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        if (!handshakeFuture.isDone()) {
            handshakeFuture.setFailure(cause);
        }
        ctx.close();
    }

}