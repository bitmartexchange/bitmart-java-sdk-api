package com.bitmart.examples.spot.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.market.V3DepthRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class GetV3Depth {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL));

        try {
            // Get depth for BTC_USDT with limit 2
            final CloudResponse cloudResponse = call.callCloud(new V3DepthRequest()
                    .setSymbol("BTC_USDT")
                    .setLimit(2));
            System.out.println("BTC_USDT depth (limit 2): " + cloudResponse.getResponseContent());

            // Get depth for ETH_USDT with limit 5
            final CloudResponse cloudResponse2 = call.callCloud(new V3DepthRequest()
                    .setSymbol("ETH_USDT")
                    .setLimit(5));
            System.out.println("ETH_USDT depth (limit 5): " + cloudResponse2.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
