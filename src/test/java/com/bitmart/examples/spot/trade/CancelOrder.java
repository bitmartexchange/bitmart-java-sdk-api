package com.bitmart.examples.spot.trade;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.CancelOrderRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class CancelOrder {

    private static final String API_KEY = "your_api_key";
    private static final String API_SECRET = "your_secret_key";
    private static final String API_MEMO = "your_memo";

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new CancelOrderRequest()
                    .setSymbol("BTC_USDT").setOrder_id("2147602398")
            );
            System.out.println(cloudResponse);
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }

    }
}
