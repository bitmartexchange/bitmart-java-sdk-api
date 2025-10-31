package com.bitmart.examples.spot.account;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.account.prv.MarginIsolatedTransferRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class MarginIsolatedTransfer {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Transfer USDT into margin account
            final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedTransferRequest()
                    .setSymbol("BTC_USDT")
                    .setCurrency("USDT")
                    .setAmount("100")
                    .setSide("in"));
            System.out.println("Transfer in response: " + cloudResponse.getResponseContent());

            // Transfer USDT out of margin account
            final CloudResponse cloudResponse2 = call.callCloud(new MarginIsolatedTransferRequest()
                    .setSymbol("BTC_USDT")
                    .setCurrency("USDT")
                    .setAmount("50")
                    .setSide("out"));
            System.out.println("Transfer out response: " + cloudResponse2.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
