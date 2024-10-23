package com.bitmart.examples.futures.trade;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.contract.prv.SubmitOrderRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_V2_URL;


@Slf4j
public class SubmitOrder {

    private static final String API_KEY = "your_api_key";
    private static final String API_SECRET = "your_secret_key";
    private static final String API_MEMO = "your_memo";

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_V2_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                    .setSymbol("ETHUSDT")
                    .setClientOrderId("def112xxx")
                    .setType("limit")
                    .setSide(4)
                    .setLeverage("1")
                    .setOpenType("isolated")
                    .setSize(10)
                    .setPrice("2000")
            );
            System.out.println(cloudResponse);
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }

    }
}