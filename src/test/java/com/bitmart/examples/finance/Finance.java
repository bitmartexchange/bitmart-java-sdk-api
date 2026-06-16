package com.bitmart.examples.finance;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.finance.prv.EarnHoldingsRequest;
import com.bitmart.api.request.finance.prv.SavingEarnRequest;
import com.bitmart.api.request.finance.prv.SavingFixedEarnRequest;
import com.bitmart.api.request.finance.prv.SavingFixedProductRequest;
import com.bitmart.api.request.finance.prv.SavingFixedRecordRequest;
import com.bitmart.api.request.finance.prv.SavingFixedRedeemRequest;
import com.bitmart.api.request.finance.prv.SavingFixedSubscribeOperateRequest;
import com.bitmart.api.request.finance.prv.SavingFixedSubscribeRequest;
import com.bitmart.api.request.finance.prv.SavingProductRequest;
import com.bitmart.api.request.finance.prv.SavingRecordRequest;
import com.bitmart.api.request.finance.prv.SavingRedeemRequest;
import com.bitmart.api.request.finance.prv.SavingSubscribeBatchOperateRequest;
import com.bitmart.api.request.finance.prv.SavingSubscribeBatchRequest;
import com.bitmart.api.request.finance.prv.SavingSubscribeOperateRequest;
import com.bitmart.api.request.finance.prv.SavingSubscribeRequest;
import com.bitmart.api.request.finance.prv.SavingSubscribeStatusRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

/**
 * Finance (Earn / savings) endpoints: flexible savings, fixed savings, auto-earn.
 */
@Slf4j
public class Finance {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.SPOT_HOST, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // ---- account ----
            CloudResponse cloudResponse = call.callCloud(new EarnHoldingsRequest());
            System.out.println(cloudResponse.getResponseContent());

            // ---- flexible savings ----
            cloudResponse = call.callCloud(new SavingProductRequest()
                    .setCoinName("USDT").setCurrentPage(1).setSizePage(10));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingSubscribeRequest()
                    .setProductId("1001").setAmount("100").setRequestNo("20000009000000300000"));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingRedeemRequest()
                    .setEarnId("200001").setAmount("50").setRequestNo("20000009000000300001"));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingEarnRequest()
                    .setCoinName("USDT").setCurrentPage(1).setSizePage(10));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingRecordRequest()
                    .setType("subscribe").setCurrentPage(1).setSizePage(10));
            System.out.println(cloudResponse.getResponseContent());

            // ---- fixed savings ----
            cloudResponse = call.callCloud(new SavingFixedProductRequest()
                    .setCoinName("USDT").setCurrentPage(1).setSizePage(10));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingFixedSubscribeRequest()
                    .setProductId("2001").setAmount("100").setRequestNo("20000009000000300002")
                    .setAutoSubscribe("OFF"));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingFixedEarnRequest()
                    .setCoinName("USDT").setCurrentPage(1).setSizePage(10));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingFixedRecordRequest()
                    .setType("subscribe").setCurrentPage(1).setSizePage(10));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingFixedRedeemRequest()
                    .setEarnId("300001").setRequestNo("20000009000000300003"));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingFixedSubscribeOperateRequest()
                    .setEarnId("300001").setAutoSubscribe("REINVEST_FIXED"));
            System.out.println(cloudResponse.getResponseContent());

            // ---- auto-earn ----
            cloudResponse = call.callCloud(new SavingSubscribeBatchOperateRequest()
                    .setAutoSubscribe("open"));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingSubscribeBatchRequest());
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingSubscribeOperateRequest()
                    .setProductId("1001").setAutoSubscribe("open"));
            System.out.println(cloudResponse.getResponseContent());

            cloudResponse = call.callCloud(new SavingSubscribeStatusRequest()
                    .setProductId("1001"));
            System.out.println(cloudResponse.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
