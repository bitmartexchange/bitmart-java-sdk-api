package com.bitmart.examples.spot.trade;


import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.SubmitOrderRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class NewOrder {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                    .setSide("buy")
                    .setType("limit")
                    .setSymbol("BTC_USDT")
                    .setClient_order_id("def123123123")
                    .setPrice("800")
                    .setSize("0.1")
                    .setStpMode("cancel_taker")); // cancel_taker
            System.out.println(cloudResponse);

            // Special Parameters for Market Buy Orders (type=market, side=buy)
            final CloudResponse cloudResponse1 = call.callCloud(new SubmitOrderRequest()
                    .setSide("buy")
                    .setType("market")
                    .setSymbol("BTC_USDT")
                    .setNotional("800"));
            System.out.println(cloudResponse1);

            // Special Parameters for Market Sell Orders (type=market, side=sell)
            final CloudResponse cloudResponse2 = call.callCloud(new SubmitOrderRequest()
                    .setSide("sell")
                    .setType("market")
                    .setSymbol("BTC_USDT")
                    .setSize("1"));
            System.out.println(cloudResponse2);

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }

    }
}

