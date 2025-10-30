package com.bitmart.examples.futures.account;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.contract.prv.GetPositionV2Request;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetPositionV2 {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.FUTURES_HOST, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new GetPositionV2Request()
                    .setSymbol("BTCUSDT")
            );
            System.out.println(cloudResponse);
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }


        try {
            final CloudResponse cloudResponse = call.callCloud(new GetPositionV2Request()
                    .setSymbol("BTCUSDT")
                    .setAccount("copy_trading")
            );
            System.out.println(cloudResponse);
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
