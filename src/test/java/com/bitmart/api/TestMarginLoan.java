package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.margin_loan.prv.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMarginLoan extends TestData {

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. POST /spot/v1/margin/isolated/borrow")
    void testMarginBorrowIsolated() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedBorrowRequest()
                .setSymbol("BTC_USDT")
                .setCurrency("BTC")
                .setAmount("1"));
        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());

    }

    @Test
    @DisplayName("Test. POST /spot/v1/margin/isolated/repay")
    void testMarginRepayIsolated() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedRepayRequest()
                .setSymbol("BTC_USDT")
                .setCurrency("BTC")
                .setAmount("1"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/margin/isolated/borrow_record")
    void testBorrowRecordIsolated() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedBorrowRecordRequest()
                .setSymbol("BTC_USDT"));
        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());

        final CloudResponse cloudResponse1 = call.callCloud(new MarginIsolatedBorrowRecordRequest()
                .setSymbol("BTC_USDT")
                .setBorrow_id("ES16655123452160qnqR1ce"));
        System.out.println(cloudResponse1);
        assertEquals(200, cloudResponse1.getResponseHttpStatus());

        final CloudResponse cloudResponse2 = call.callCloud(new MarginIsolatedBorrowRecordRequest()
                .setSymbol("BTC_USDT")
                .setStart_time(1664607368000L)
                .setEnd_time(1665989933000L));
        System.out.println(cloudResponse2);
        assertEquals(200, cloudResponse2.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/margin/isolated/repay_record")
    void testRepaymentRecordIsolated() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedRepayRecordRequest()
                .setSymbol("BTC_USDT")
                .setCurrency("USDT"));
        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());

        final CloudResponse cloudResponse1 = call.callCloud(new MarginIsolatedRepayRecordRequest()
                .setSymbol("BTC_USDT")
                .setRepay_id("be7e0887-5bc9-4775-8e45-567cfa567af7"));
        System.out.println(cloudResponse1);
        assertEquals(200, cloudResponse1.getResponseHttpStatus());

        final CloudResponse cloudResponse2 = call.callCloud(new MarginIsolatedRepayRecordRequest()
                .setSymbol("BTC_USDT")
                .setStart_time(1664607368000L)
                .setEnd_time(1665989933000L));
        System.out.println(cloudResponse2);
        assertEquals(200, cloudResponse2.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/margin/isolated/pairs")
    void testTradingPairBorrowingRateAndAmount() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedPairsRequest()
                .setSymbol("BTC_USDT"));
        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());

        final CloudResponse cloudResponse1 = call.callCloud(new MarginIsolatedPairsRequest());
        System.out.println(cloudResponse1);
        assertEquals(200, cloudResponse1.getResponseHttpStatus());
    }
}
