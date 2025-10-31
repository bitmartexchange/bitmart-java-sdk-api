package com.bitmart.examples.spot.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.market.V3TickersRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class GetV3Tickers {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL));

        try {
            // Get ticker of all pairs (V3)
            final CloudResponse cloudResponse = call.callCloud(new V3TickersRequest());
            System.out.println("All pairs ticker (V3): " + cloudResponse.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
