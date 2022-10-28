package com.bitmart.api;

import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.contract.WebSocketCallBack;
import com.bitmart.websocket.contract.WebSocketClient;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static com.bitmart.websocket.contract.WebSocketContractConstant.*;
import static com.bitmart.websocket.contract.WebSocketContractConstant.createChannel;

public final class TestContractWebSocket extends TestData {

    // ------------------  public -------------------------
    WebSocketClient webSocketClient;
    // ------------------  private ------------------------
    WebSocketClient webSocketPrivateClient;

    TestContractWebSocket() {
        try {
            webSocketClient = new WebSocketClient(CLOUD_CONTRACT_WS_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());
            webSocketPrivateClient = new WebSocketClient(CLOUD_CONTRACT_WS_PRIVATE_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println("onMessage---------------->");
            System.out.println(text);
        }
    }

    @Test
    void testLogin() throws Exception {

        webSocketPrivateClient.login();

        Thread.sleep(2000L);

        webSocketPrivateClient.subscribe(ImmutableList.of(
                // private channel
                WS_USER_CONTRACT_POSITION,
                createChannel(WS_USER_CONTRACT_ASSET, "USDT")
        ));

        Thread.sleep(120 * 1000L);

    }


    @Test
    void testSubscribe() throws Exception {

        webSocketClient.setIsPrint(true);
        webSocketClient.subscribe(ImmutableList.of(
                // public channel
                WS_PUBLIC_CONTRACT_TICKER,
                createChannel(WS_PUBLIC_CONTRACT_DEPTH5, "BTCUSDT"),
                createChannel(WS_PUBLIC_CONTRACT_KLINE_1M,"BTCUSDT")
        ));

        Thread.sleep(120 * 1000L);

    }


}