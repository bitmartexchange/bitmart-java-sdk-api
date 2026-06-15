package com.bitmart.examples.spot.subaccount;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.subaccount.spot.MainToSubRequest;
import com.bitmart.api.request.subaccount.spot.SubAccountListRequest;
import com.bitmart.api.request.subaccount.spot.SubToMainRequest;
import com.bitmart.api.request.subaccount.spot.SubToMainSubRequest;
import com.bitmart.api.request.subaccount.spot.SubToSubRequest;
import com.bitmart.api.request.subaccount.spot.SubTransferHistoryRequest;
import com.bitmart.api.request.subaccount.spot.SubTransferListRequest;
import com.bitmart.api.request.subaccount.spot.SubWalletRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

/**
 * Spot sub-account transfer / wallet / list endpoints.
 */
@Slf4j
public class SubAccount {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.SPOT_HOST, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Sub-account -> main account (for main account)
            CloudResponse cloudResponse = call.callCloud(new SubToMainRequest()
                    .setRequestNo("3989672177547886592")
                    .setAmount("1")
                    .setCurrency("USDT")
                    .setSubAccount("subAccountName"));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account -> main account (for sub-account)
            cloudResponse = call.callCloud(new SubToMainSubRequest()
                    .setRequestNo("3989672177547886592")
                    .setAmount("1")
                    .setCurrency("USDT"));
            System.out.println(cloudResponse.getResponseContent());

            // Main account -> sub-account (for main account)
            cloudResponse = call.callCloud(new MainToSubRequest()
                    .setRequestNo("3989672177547886592")
                    .setAmount("1")
                    .setCurrency("USDT")
                    .setSubAccount("subAccountName"));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account -> sub-account (for main account)
            cloudResponse = call.callCloud(new SubToSubRequest()
                    .setRequestNo("3989672177547886592")
                    .setAmount("1")
                    .setCurrency("USDT")
                    .setFromAccount("fromSubAccount")
                    .setToAccount("toSubAccount"));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account transfer history (for main account)
            cloudResponse = call.callCloud(new SubTransferListRequest()
                    .setMoveType("spot to spot")
                    .setAccountName("subAccountName")
                    .setN(10));
            System.out.println(cloudResponse.getResponseContent());

            // Account transfer history (for both main and sub accounts)
            cloudResponse = call.callCloud(new SubTransferHistoryRequest()
                    .setMoveType("spot to spot")
                    .setN(10));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account spot balance (for main account)
            cloudResponse = call.callCloud(new SubWalletRequest()
                    .setSubAccount("subAccountName")
                    .setCurrency("USDT"));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account list (for main account)
            cloudResponse = call.callCloud(new SubAccountListRequest());
            System.out.println(cloudResponse.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
