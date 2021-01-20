package com.bitmart.api;

import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.WebSocketClient;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static com.bitmart.websocket.spot.WebSocketConstant.*;

public final class TestWebSocket extends TestData {

    // ------------------  public -------------------------
    WebSocketClient webSocketClient;
    TestWebSocket() {
        try {
            webSocketClient = new WebSocketClient(CLOUD_WS_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());
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

        webSocketClient.login();

        Thread.sleep(2000L);

        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                createChannel(WS_PUBLIC_SPOT_TICKER, "BTC_USDT"),
                createChannel(WS_PUBLIC_SPOT_DEPTH5, "BTC_USDT"),

                // private channel
                createChannel(WS_USER_SPOT_ORDER, "BTC_USDT")

        ));

        Thread.sleep(120 * 1000L);

    }


    @Test
    void testSubscribe() throws Exception {

        webSocketClient.setIsPrint(true);
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                createChannel(WS_PUBLIC_SPOT_TICKER, "BTC_USDT")
//                createChannel(WS_PUBLIC_SPOT_DEPTH5, "BTC_USDT")
        ));

        Thread.sleep(120 * 1000L);

    }


}