package com.bitmart.examples.futures.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.ContractWebSocket;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.contract.ActionParam;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_FUTURES_WS_PUBLIC_URL;

@Slf4j
public class Ticker {

    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }
    public static void main(String[] args) {
        try {
            ContractWebSocket webSocketClient = new ContractWebSocket(CLOUD_FUTURES_WS_PUBLIC_URL,
                    new CloudKey(), new ReceiveMessage());

            webSocketClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/ticker")));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }

    }
}
