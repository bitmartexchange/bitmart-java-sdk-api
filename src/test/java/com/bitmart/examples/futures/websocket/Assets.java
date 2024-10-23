package com.bitmart.examples.futures.websocket;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.ContractWebSocket;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.contract.ActionParam;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_CONTRACT_WS_PRIVATE_URL;

@Slf4j
public class Assets {

    private static final String API_KEY = "your_api_key";
    private static final String API_SECRET = "your_secret_key";
    private static final String API_MEMO = "your_memo";

    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }
    public static void main(String[] args) {
        try {
            ContractWebSocket webSocketPrivateClient = new ContractWebSocket(CLOUD_CONTRACT_WS_PRIVATE_URL,
                    new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());

            // login
            webSocketPrivateClient.login();

            // subscribe private channel
            webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/asset:USDT")));
            webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/position")));
            webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/order")));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }

    }
}
