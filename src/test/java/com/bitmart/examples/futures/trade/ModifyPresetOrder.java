package com.bitmart.examples.futures.trade;


import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.contract.prv.ModifyPresetPlanOrderRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModifyPresetOrder {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET =  Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;
    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.FUTURES_HOST, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new ModifyPresetPlanOrderRequest()
                    .setSymbol("BTCUSDT")
                    .setOrderId("56739000054")
                    .setPresetTakeProfitPrice("50000")
                    .setPresetTakeProfitPriceType(1)
                    .setPresetStopLossPrice("40000")
                    .setPresetStopLossPriceType(1)
            );
            System.out.println(cloudResponse);

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }

    }
}

