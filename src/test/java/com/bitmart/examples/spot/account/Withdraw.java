package com.bitmart.examples.spot.account;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.account.prv.AccountWithdrawApplyRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class Withdraw {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new AccountWithdrawApplyRequest()
                    .setCurrency("USDT-ETH")
                    .setAmount("50000.000")
                    .setDestination("2:BitMart")
                    .setAddress("0xe57b69a8776b37860407965B73cdFFBDFe668Bb5")
                    .setAddress_memo("")
            );
            System.out.println(cloudResponse);
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }

        try {
            final CloudResponse cloudResponse2 = call.callCloud(new AccountWithdrawApplyRequest()
                    .setCurrency("USDT-ETH")
                    .setAmount("50.000")
                    .setType(1)
                    .setValue("876940329")
                    .setAreaCode("")
            );
            System.out.println(cloudResponse2);
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
