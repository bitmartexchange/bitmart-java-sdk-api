package com.bitmart.websocket;

import com.bitmart.api.common.JsonUtils;
import com.bitmart.api.common.StringCompress;
import io.netty.channel.*;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WebSocketClientHandler extends SimpleChannelInboundHandler<Object> {

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
        log.info("WebSocket Client Connecting to {}", handShaker.uri().toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("WebSocket Client disconnected! {}", handShaker.uri().toString());

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
                log.info("WebSocket Client connected!");
                handshakeFuture.setSuccess();
            } catch (WebSocketHandshakeException e) {
                log.info("WebSocket Client failed to connect");
                handshakeFuture.setFailure(e);
            }
            return;
        }

        if (msg instanceof WebSocketFrame) {
            WebSocketFrame frame = (WebSocketFrame) msg;

            if (frame instanceof TextWebSocketFrame) {
                TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
                String message = textFrame.text();
                if( this.webSocketClient.isPrint()) {
                    log.info("WebSocket Client received message:{}", message);
                }

                String event = JsonUtils.fromJson(message, "event");
                String errorCode = JsonUtils.fromJson(message, "errorCode");
                if ("login".equals(event) && StringUtils.isNotBlank(errorCode)) {
                    this.webSocketClient.stop();
                    return ;
                }

                this.webSocketClient.callBack.onMessage(textFrame.text());
            } else if (frame instanceof BinaryWebSocketFrame) {
                BinaryWebSocketFrame binaryWebSocketFrame = (BinaryWebSocketFrame) frame;

                this.webSocketClient.callBack.onMessage(StringCompress.decode(binaryWebSocketFrame.content()));

            } else if (frame instanceof PongWebSocketFrame) {
                // System.out.println("WebSocket Client received pong");

            } else if (frame instanceof CloseWebSocketFrame) {
                log.info("WebSocket Client received closing");
                ch.close();
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