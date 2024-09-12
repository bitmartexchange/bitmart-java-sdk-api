package com.bitmart.websocket;

import com.bitmart.api.key.CloudKey;
import com.bitmart.data.TestData;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public final class TestFuturesWebSocket extends TestData {

    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }

    @Test
    void testLogin() throws Exception {
        ContractWebSocket webSocketPrivateClient = new ContractWebSocket(CLOUD_CONTRACT_WS_PRIVATE_URL,
                new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());
        webSocketPrivateClient.login();

        webSocketPrivateClient.subscribe(ImmutableList.of(
                // private channel
                // Assets Channel
                "futures/asset:USDT",

                // Position Channel
                "futures/position",

                // Order Channel
                "futures/order"
        ));

        Thread.sleep(120 * 1000L);

    }


    @Test
    void testSubscribe() throws Exception {
        ContractWebSocket webSocketClient = new ContractWebSocket(CLOUD_CONTRACT_WS_URL, new CloudKey(), new ReceiveMessage());

        webSocketClient.setIsPrint(true);
        webSocketClient.subscribe(ImmutableList.of(
                // Ticker Channel
                "futures/ticker",

                // Depth Channel
                "futures/depth20:BTCUSDT",

                // Trade Channel
                "futures/trade:BTCUSDT",

                // klineBin Channel
                "futures/klineBin1m:BTCUSDT"

        ));

        Thread.sleep(120 * 1000L);

    }


}