package com.bitmart.examples.spot.account;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.account.prv.AccountDepositWithdrawHistoryV2Request;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class GetDepositWithdrawHistory {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = "";
    private static final String API_MEMO = "";

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Get withdraw history
            final CloudResponse cloudResponse = call.callCloud(new AccountDepositWithdrawHistoryV2Request()
                    .setOperationType("withdraw")
                    .setN(10));
            System.out.println("Withdraw history: " + cloudResponse.getResponseContent());

            // Get deposit history
            final CloudResponse cloudResponse2 = call.callCloud(new AccountDepositWithdrawHistoryV2Request()
                    .setOperationType("deposit")
                    .setN(10));
            System.out.println("Deposit history: " + cloudResponse2.getResponseContent());

            // Get all history
            final CloudResponse cloudResponse3 = call.callCloud(new AccountDepositWithdrawHistoryV2Request()
                    .setN(20)
                    .setOperationType("deposit")
                    .setStartTime(System.currentTimeMillis()-3600*1000)
                    .setEndTime(System.currentTimeMillis())
            );
            System.out.println("All history: " + cloudResponse3.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
