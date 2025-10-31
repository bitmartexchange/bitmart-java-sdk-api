package com.bitmart.examples.futures.trade;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.contract.prv.TradesRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetTrades {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = "";
    private static final String API_MEMO = "";

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.FUTURES_HOST, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new TradesRequest()
                    .setSymbol("BTCUSDT") // now optional
                    .setStartTime(System.currentTimeMillis()/1000 - 86400L) // 1 day ago
                    .setEndTime(System.currentTimeMillis()/1000) // now
                    .setAccount("futures") // futures account
            );
            System.out.println(cloudResponse);
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
