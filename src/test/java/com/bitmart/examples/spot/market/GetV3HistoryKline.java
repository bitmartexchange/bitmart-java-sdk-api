package com.bitmart.examples.spot.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.market.V3HistoryKlineRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class GetV3HistoryKline {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL));

        try {
            // Get history K-line for BTC_USDT
            final CloudResponse cloudResponse = call.callCloud(new V3HistoryKlineRequest()
                    .setSymbol("BTC_USDT")
                    .setBefore((System.currentTimeMillis() / 1000)) // now
                    .setAfter(System.currentTimeMillis() / 1000  - 3600) // 1 hour ago
                    .setStep(15) // 15 minutes
                    .setLimit(10));
            System.out.println("BTC_USDT history K-line: " + cloudResponse.getResponseContent());

            // Get history K-line for ETH_USDT
            final CloudResponse cloudResponse2 = call.callCloud(new V3HistoryKlineRequest()
                    .setSymbol("ETH_USDT")
                    .setBefore((System.currentTimeMillis() / 1000)) // now
                    .setAfter(System.currentTimeMillis() / 1000- 1800) // 30 minutes ago
                    .setStep(5) // 5 minutes
                    .setLimit(5));
            System.out.println("ETH_USDT history K-line: " + cloudResponse2.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
