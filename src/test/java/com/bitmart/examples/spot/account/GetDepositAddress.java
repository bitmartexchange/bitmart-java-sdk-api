package com.bitmart.examples.spot.account;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.account.prv.AccountDepositAddressRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class GetDepositAddress {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = "";
    private static final String API_MEMO = "";

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Get deposit address for USDT-ERC20
            final CloudResponse cloudResponse = call.callCloud(new AccountDepositAddressRequest()
                    .setCurrency("USDT-ETH"));
            System.out.println("USDT-ERC20 deposit address: " + cloudResponse.getResponseContent());

            // Get deposit address for BTC
            final CloudResponse cloudResponse2 = call.callCloud(new AccountDepositAddressRequest()
                    .setCurrency("BTC"));
            System.out.println("BTC deposit address: " + cloudResponse2.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
