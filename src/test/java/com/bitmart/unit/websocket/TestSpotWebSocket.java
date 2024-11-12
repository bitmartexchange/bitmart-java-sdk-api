package com.bitmart.unit.websocket;

import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import com.bitmart.unit.data.TestData;
import com.bitmart.websocket.OpParam;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.WebSocketClient;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public final class TestSpotWebSocket extends TestData {


    public static class ReceiveMessage extends WebSocketCallBack {

        @Override
        public void onMessage(String text) {
            log.info("ReceiveMessage------>{}", text);
        }

    }

    @Test
    void testSubscribePrivateChannel() throws Exception {
        WebSocketClient webSocketClient = new WebSocketClient(GlobalConst.CLOUD_SPOT_WS_PRIVATE_URL,
                new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());

        // need login
        webSocketClient.login();

        // subscribe private channel
        webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/user/order:BTC_USDT")));
        webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/user/balance:BALANCE_UPDATE")));



    }


    @Test
    void testSubscribePublicChannel() throws Exception {
        WebSocketClient webSocketClient = new WebSocketClient(GlobalConst.CLOUD_SPOT_WS_PUBLIC_URL,
                new CloudKey(), new ReceiveMessage());

        // subscribe public channel
        webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/ticker:BTC_USDT")));
        webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/kline1m:BTC_USDT")));
        webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/depth5:BTC_USDT")));
        webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/trade:BTC_USDT")));

        Thread.sleep(5 * 1000L);
        webSocketClient.send(new OpParam().setOp("unsubscribe").setArgs(ImmutableList.of("spot/ticker:BTC_USDT")));


    }


}