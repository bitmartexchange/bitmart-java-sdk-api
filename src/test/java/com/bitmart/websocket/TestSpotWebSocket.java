package com.bitmart.websocket;

import com.bitmart.api.key.CloudKey;
import com.bitmart.data.TestData;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.bitmart.websocket.spot.WebSocketConstant.WS_USER_SPOT_ORDER;
import static com.bitmart.websocket.spot.WebSocketConstant.createChannel;

@Slf4j
public final class TestSpotWebSocket extends TestData {


    public class ReceiveMessage extends WebSocketCallBack {

        @Override
        public void onMessage(String text) {
            // log.info("onMessage------>{}", text);
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
                "spot/ticker:BTC_USDT"
                // createChannel(WS_PUBLIC_SPOT_TICKER, "ETH_USDT")
        ));

        Thread.sleep(120 * 1000L);

    }


}