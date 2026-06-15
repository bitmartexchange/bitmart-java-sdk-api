package com.bitmart.examples.futures.subaccount;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.subaccount.contract.ContractMainToSubRequest;
import com.bitmart.api.request.subaccount.contract.ContractSubToMainRequest;
import com.bitmart.api.request.subaccount.contract.ContractSubToMainSubRequest;
import com.bitmart.api.request.subaccount.contract.ContractSubTransferHistoryRequest;
import com.bitmart.api.request.subaccount.contract.ContractSubTransferListRequest;
import com.bitmart.api.request.subaccount.contract.ContractSubWalletRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

/**
 * Contract (futures) sub-account transfer / wallet endpoints.
 */
@Slf4j
public class SubAccount {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.FUTURES_HOST, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Sub-account -> main account (for main account)
            CloudResponse cloudResponse = call.callCloud(new ContractSubToMainRequest()
                    .setRequestNo("3989672177547886592")
                    .setAmount("1")
                    .setCurrency("USDT")
                    .setSubAccount("subAccountName"));
            System.out.println(cloudResponse.getResponseContent());

            // Main account -> sub-account (for main account)
            cloudResponse = call.callCloud(new ContractMainToSubRequest()
                    .setRequestNo("3989672177547886592")
                    .setAmount("1")
                    .setCurrency("USDT")
                    .setSubAccount("subAccountName"));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account -> main account (for sub-account)
            cloudResponse = call.callCloud(new ContractSubToMainSubRequest()
                    .setRequestNo("3989672177547886592")
                    .setAmount("1")
                    .setCurrency("USDT"));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account contract balance (for main account)
            cloudResponse = call.callCloud(new ContractSubWalletRequest()
                    .setSubAccount("subAccountName")
                    .setCurrency("USDT"));
            System.out.println(cloudResponse.getResponseContent());

            // Sub-account transfer history (for main account)
            cloudResponse = call.callCloud(new ContractSubTransferListRequest()
                    .setSubAccount("subAccountName")
                    .setLimit(10));
            System.out.println(cloudResponse.getResponseContent());

            // Account transfer history (for both main and sub accounts)
            cloudResponse = call.callCloud(new ContractSubTransferHistoryRequest()
                    .setLimit(10));
            System.out.println(cloudResponse.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
