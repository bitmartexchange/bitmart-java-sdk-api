package com.bitmart.examples.spot.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.market.V3TickerRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Currencies {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext());

        try {
            // Get Currency List (V1)
            CloudResponse cloudResponse  = call.callCloud(new V3TickerRequest().setSymbol("BTC_USDT"));
            System.out.println(cloudResponse.getResponseContent());
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
