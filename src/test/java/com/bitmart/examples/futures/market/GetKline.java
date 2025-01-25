package com.bitmart.examples.futures.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.contract.pub.KlineRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_V2_URL;


@Slf4j
public class GetKline {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_V2_URL));

        try {

            long endSeconds = System.currentTimeMillis() / 1000;
            long startSeconds = endSeconds - 60 * 60 * 24 * 7; // 7 days

            // /contract/public/kline
            final CloudResponse cloudResponse = call.callCloud(new KlineRequest()
                    .setSymbol("ETHUSDT")
                    .setStep(1440)
                    .setStartTime(startSeconds)
                    .setEndTime(endSeconds)
            );
            System.out.println(cloudResponse.getResponseContent());
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
