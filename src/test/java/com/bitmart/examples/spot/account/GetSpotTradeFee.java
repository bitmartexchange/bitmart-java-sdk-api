package com.bitmart.examples.spot.account;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.account.prv.SpotTradeFeeRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class GetSpotTradeFee {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = "";
    private static final String API_MEMO = "";

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Get actual trade fee rate for BTC_USDT
            final CloudResponse cloudResponse = call.callCloud(new SpotTradeFeeRequest()
                    .setSymbol("BTC_USDT"));
            System.out.println("BTC_USDT trade fee rate: " + cloudResponse.getResponseContent());

            // Get actual trade fee rate for ETH_USDT
            final CloudResponse cloudResponse2 = call.callCloud(new SpotTradeFeeRequest()
                    .setSymbol("ETH_USDT"));
            System.out.println("ETH_USDT trade fee rate: " + cloudResponse2.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
