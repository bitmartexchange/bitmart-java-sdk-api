package com.bitmart.examples.spot.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.WebSocketClient;
import com.bitmart.websocket.OpParam;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.spot.WebSocketConstant;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_SPOT_WS_PUBLIC_URL;

@Slf4j
public class BookTicker {
    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }
    }

    public static void main(String[] args) {
        try {
            WebSocketClient webSocketClient = new WebSocketClient(CLOUD_SPOT_WS_PUBLIC_URL,
                    new CloudKey(), new ReceiveMessage());

            // Public - Best order book (bookTicker) channel
            webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of(
                    WebSocketConstant.createChannel(WebSocketConstant.WS_PUBLIC_SPOT_BOOK_TICKER, "BTC_USDT"))));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }
    }
}
