package com.bitmart.websocket;

import com.bitmart.data.TestData;
import com.bitmart.api.key.CloudKey;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.bitmart.websocket.contract.ContractWebSocketConstant.*;

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
                WS_USER_CONTRACT_POSITION,
                createChannel(WS_USER_CONTRACT_ASSET, "USDT")
        ));

        Thread.sleep(120 * 1000L);

    }


    @Test
    void testSubscribe() throws Exception {
        ContractWebSocket webSocketClient = new ContractWebSocket(CLOUD_CONTRACT_WS_URL, new CloudKey(), new ReceiveMessage());

        webSocketClient.setIsPrint(true);
        webSocketClient.subscribe(ImmutableList.of(
                // public channel
                // "futures/ticker"
                //createChannel(WS_PUBLIC_CONTRACT_DEPTH5, "BTCUSDT"),
                //createChannel(WS_PUBLIC_CONTRACT_KLINE_1M,"BTCUSDT")
        ));

        Thread.sleep(120 * 1000L);

    }


}