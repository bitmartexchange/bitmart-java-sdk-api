package com.bitmart.examples.spot.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.OpParam;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.WebSocketClient;
import com.bitmart.examples.Example;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BalanceChange {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;


    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }

    public static void main(String[] args) {
        try {
            WebSocketClient webSocketClient = new WebSocketClient(GlobalConst.CLOUD_SPOT_WS_PRIVATE_URL,
                    new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());

            // need login
            webSocketClient.login();

            // subscribe private channel
            webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/user/balance:BALANCE_UPDATE")));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }

    }
}

