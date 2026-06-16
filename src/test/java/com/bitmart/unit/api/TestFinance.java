package com.bitmart.unit.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.finance.prv.*;
import com.bitmart.unit.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TestFinance extends TestData {

    // -------------- account

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/earn")
    void testEarnHoldings() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new EarnHoldingsRequest());
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // -------------- flexible savings

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/product")
    void testSavingProduct() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingProductRequest()
                .setCoinName("USDT")
                .setCurrentPage(1)
                .setSizePage(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /newearn/cloud/v1/saving/subscribe")
    void testSavingSubscribe() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingSubscribeRequest()
                .setProductId("1001")
                .setAmount("100")
                .setRequestNo("20000009000000300000")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /newearn/cloud/v1/saving/redeem")
    void testSavingRedeem() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingRedeemRequest()
                .setEarnId("200001")
                .setAmount("50")
                .setRequestNo("20000009000000300001")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/earn")
    void testSavingEarn() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingEarnRequest()
                .setCoinName("USDT")
                .setCurrentPage(1)
                .setSizePage(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/record")
    void testSavingRecord() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingRecordRequest()
                .setType("subscribe")
                .setCurrentPage(1)
                .setSizePage(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // -------------- fixed savings

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/fixed/product")
    void testSavingFixedProduct() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingFixedProductRequest()
                .setCoinName("USDT")
                .setCurrentPage(1)
                .setSizePage(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /newearn/cloud/v1/saving/fixed/subscribe")
    void testSavingFixedSubscribe() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingFixedSubscribeRequest()
                .setProductId("2001")
                .setAmount("100")
                .setRequestNo("20000009000000300002")
                .setAutoSubscribe("OFF")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/fixed/earn")
    void testSavingFixedEarn() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingFixedEarnRequest()
                .setCoinName("USDT")
                .setCurrentPage(1)
                .setSizePage(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/fixed/record")
    void testSavingFixedRecord() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingFixedRecordRequest()
                .setType("subscribe")
                .setCurrentPage(1)
                .setSizePage(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /newearn/cloud/v1/saving/fixed/redeem")
    void testSavingFixedRedeem() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingFixedRedeemRequest()
                .setEarnId("300001")
                .setRequestNo("20000009000000300003")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /newearn/cloud/v1/saving/fixed/subscribe/operate")
    void testSavingFixedSubscribeOperate() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingFixedSubscribeOperateRequest()
                .setEarnId("300001")
                .setAutoSubscribe("REINVEST_FIXED")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // -------------- auto-earn

    @Test
    @DisplayName("Test. POST /newearn/cloud/v1/saving/subscribe/batch/operate")
    void testSavingSubscribeBatchOperate() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingSubscribeBatchOperateRequest()
                .setAutoSubscribe("open")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/subscribe/batch")
    void testSavingSubscribeBatch() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingSubscribeBatchRequest());
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /newearn/cloud/v1/saving/subscribe/operate")
    void testSavingSubscribeOperate() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingSubscribeOperateRequest()
                .setProductId("1001")
                .setAutoSubscribe("open")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /newearn/cloud/v1/saving/subscribe/status")
    void testSavingSubscribeStatus() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SavingSubscribeStatusRequest()
                .setProductId("1001")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

}
