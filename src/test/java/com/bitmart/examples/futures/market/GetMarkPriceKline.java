package com.bitmart.examples.futures.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.contract.pub.MarkPriceKlineRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_V2_URL;

@Slf4j
public class GetMarkPriceKline {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_V2_URL));

        try {
            // Get MarkPrice K-line data
            final CloudResponse cloudResponse = call.callCloud(new MarkPriceKlineRequest()
                    .setSymbol("BTCUSDT")
                    .setStep(60)
                    .setStartTime(System.currentTimeMillis() / 1000 - 3600) // 1 hour ago
                    .setEndTime(System.currentTimeMillis() / 1000) // now
            );
            System.out.println(cloudResponse.getResponseContent());
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
