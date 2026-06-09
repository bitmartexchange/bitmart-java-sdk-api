package com.bitmart.examples.spot.market;

import com.bitmart.examples.Example;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.market.V3TickerRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GetV3Ticker {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.SPOT_HOST));

        try {
            // Get ticker of BTC_USDT (V3)
            final CloudResponse cloudResponse = call.callCloud(new V3TickerRequest()
                    .setSymbol("BTC_USDT"));
            System.out.println("BTC_USDT ticker (V3): " + cloudResponse.getResponseContent());

            // Get ticker of ETH_USDT (V3)
            final CloudResponse cloudResponse2 = call.callCloud(new V3TickerRequest()
                    .setSymbol("ETH_USDT"));
            System.out.println("ETH_USDT ticker (V3): " + cloudResponse2.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
