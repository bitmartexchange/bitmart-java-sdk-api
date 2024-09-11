package com.bitmart.websocket;

import com.bitmart.api.key.CloudKey;
import com.bitmart.data.TestData;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public final class TestSpotWebSocket extends TestData {


    public static class ReceiveMessage extends WebSocketCallBack {

        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }

    @Test
    void testLogin() throws Exception {
        WebSocketClient webSocketClient = new WebSocketClient(CLOUD_WS_PRIVATE_URL,
                new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());

        // need login
        webSocketClient.login();

        webSocketClient.setIsPrint(true);
        webSocketClient.subscribe(ImmutableList.of(

                // Order Progress
                "spot/user/order:BTC_USDT",

                // Balance Change
                "spot/user/balance:BALANCE_UPDATE"
        ));

        Thread.sleep(120 * 1000L);

    }


    @Test
    void testSubscribe() throws Exception {
        WebSocketClient webSocketClient = new WebSocketClient(CLOUD_WS_URL,
                new CloudKey(), new ReceiveMessage());

        webSocketClient.setIsPrint(true);
        webSocketClient.subscribe(ImmutableList.of(

                // Ticker Channel
                "spot/ticker:BTC_USDT",

                // KLine Channel
                "spot/kline1m:BTC_USDT",

                // Depth-All Channel
                "spot/depth5:BTC_USDT",

                // Depth-Increase Channel
                "spot/depth/increase100:BTC_USDT",

                // Trade Channel
                "spot/trade:BTC_USDT"
        ));

        Thread.sleep(120 * 1000L);

    }


}