package com.bitmart.examples.futures.affiliate;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.contract.prv.AffiliateAffCustomerInfoRequest;
import com.bitmart.api.request.contract.prv.AffiliateDepositWithdrawalListRequest;
import com.bitmart.api.request.contract.prv.AffiliateInviteCheckRequest;
import com.bitmart.api.request.contract.prv.AffiliateRebateApiRequest;
import com.bitmart.api.request.contract.prv.AffiliateRebateInviteUserRequest;
import com.bitmart.api.request.contract.prv.AffiliateRebateListRequest;
import com.bitmart.api.request.contract.prv.AffiliateRebateUserRequest;
import com.bitmart.api.request.contract.prv.AffiliateTradeListRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

/**
 * Futures affiliate (rebate / invitation) endpoints.
 */
@Slf4j
public class Affiliate {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.FUTURES_HOST, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Query the rebate of invited users
            CloudResponse cloudResponse = call.callCloud(new AffiliateRebateInviteUserRequest()
                    .setCid(123456L)
                    .setStartTime(1770739200L)
                    .setEndTime(1771257600L)
                    .setPage(1)
                    .setSize(50));
            System.out.println(cloudResponse.getResponseContent());

            // Check whether a user is invited
            cloudResponse = call.callCloud(new AffiliateInviteCheckRequest().setCid(123456L));
            System.out.println(cloudResponse.getResponseContent());

            // Query the contract rebate of a single user
            cloudResponse = call.callCloud(new AffiliateRebateUserRequest()
                    .setCid(123456L)
                    .setStartTime(1770739200L)
                    .setEndTime(1771257600L));
            System.out.println(cloudResponse.getResponseContent());

            // Query the contract API rebate of a single user
            cloudResponse = call.callCloud(new AffiliateRebateApiRequest()
                    .setCid(123456L)
                    .setStartTime(1770739200L)
                    .setEndTime(1771257600L));
            System.out.println(cloudResponse.getResponseContent());

            // Query the deposit/withdrawal records of an invited user
            cloudResponse = call.callCloud(new AffiliateDepositWithdrawalListRequest()
                    .setPage(1)
                    .setSize(50)
                    .setType(1)
                    .setCid(123456L)
                    .setStartTime(1770739200L)
                    .setEndTime(1771257600L));
            System.out.println(cloudResponse.getResponseContent());

            // Query the contract account info of an invited user
            cloudResponse = call.callCloud(new AffiliateAffCustomerInfoRequest().setUserId(123456L));
            System.out.println(cloudResponse.getResponseContent());

            // Query the contract rebate records
            cloudResponse = call.callCloud(new AffiliateRebateListRequest()
                    .setUserId(123456L)
                    .setPage(1)
                    .setSize(50)
                    .setCurrency("USDT")
                    .setRebateStartTime(1770739200L)
                    .setRebateEndTime(1771257600L));
            System.out.println(cloudResponse.getResponseContent());

            // Query the contract trade records of invited users
            cloudResponse = call.callCloud(new AffiliateTradeListRequest()
                    .setUserId(123456L)
                    .setType(1)
                    .setPage(1)
                    .setSize(50)
                    .setStartTime(1770739200L)
                    .setEndTime(1771257600L));
            System.out.println(cloudResponse.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
