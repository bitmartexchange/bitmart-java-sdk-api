package com.bitmart.api;

import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.WebSocketClient;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static com.bitmart.websocket.spot.WebSocketConstant.*;

public final class TestWebSocket extends TestData {


    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println("onMessage---------------->");
            System.out.println(text);
        }

    }

    @Test
    void testLogin() throws Exception {
        WebSocketClient webSocketPrivateClient = new WebSocketClient(CLOUD_WS_PRIVATE_URL,
                new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());

        // need login
        webSocketPrivateClient.login();

        Thread.sleep(2000L);

        webSocketPrivateClient.subscribe(ImmutableList.of(

                // private channel
                "spot/user/order:BTC_USDT",
                createChannel(WS_USER_SPOT_ORDER, "ETH_USDT")

        ));

        Thread.sleep(120 * 1000L);

    }


    @Test
    void testSubscribe() throws Exception {
        WebSocketClient webSocketClient = new WebSocketClient(CLOUD_WS_URL,
                new CloudKey(), new ReceiveMessage());

        webSocketClient.setIsPrint(true);
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                "spot/ticker:BTC_USDT",
                createChannel(WS_PUBLIC_SPOT_TICKER, "ETH_USDT")
        ));

        Thread.sleep(120 * 1000L);

    }


}