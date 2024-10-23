package com.bitmart.unit.websocket;

import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import com.bitmart.unit.data.TestData;
import com.bitmart.websocket.ContractWebSocket;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.contract.ActionParam;
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
    void testSubscribePrivateChannel() throws Exception {
        ContractWebSocket webSocketPrivateClient = new ContractWebSocket(GlobalConst.CLOUD_CONTRACT_WS_PRIVATE_URL,
                new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());
        webSocketPrivateClient.login();

        // subscribe private channel
        webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/asset:USDT")));
        webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/position")));
        webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/order")));



    }


    @Test
    void testSubscribe() throws Exception {
        ContractWebSocket webSocketClient = new ContractWebSocket(GlobalConst.CLOUD_CONTRACT_WS_URL,
                new CloudKey(), new ReceiveMessage());

        webSocketClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/ticker")));
        webSocketClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/depth20:BTCUSDT")));
        webSocketClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/trade:BTCUSDT")));
        webSocketClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/klineBin1m:BTCUSDT")));


    }


}