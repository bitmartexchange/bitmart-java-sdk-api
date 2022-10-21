package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.request.margin_loan.prv.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMarginLoan extends TestData {

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. POST /spot/v1/margin/isolated/borrow")
    void marginBorrowIsolated() throws CloudException {
        System.out.println(
                call.callCloud(new MarginIsolatedBorrowRequest().setSymbol("BTC_USDT").setCurrency("BTC").setAmount("1"))
        );
    }

    @Test
    @DisplayName("Test. POST /spot/v1/margin/isolated/repay")
    void marginRepayIsolated() throws CloudException {
        System.out.println(
                call.callCloud(new MarginIsolatedRepayRequest().setSymbol("BTC_USDT").setCurrency("BTC").setAmount("1"))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/margin/isolated/borrow_record")
    void getBorrowRecordIsolated() throws CloudException {
        System.out.println(
                call.callCloud(new MarginIsolatedBorrowRecordRequest().setSymbol("BTC_USDT"))
        );
        System.out.println(
                call.callCloud(new MarginIsolatedBorrowRecordRequest().setSymbol("BTC_USDT")
                        .setBorrow_id("ES16655123452160qnqR1ce"))
        );
        System.out.println(
                call.callCloud(new MarginIsolatedBorrowRecordRequest().setSymbol("BTC_USDT")
                        .setStart_time(1664607368000L).setEnd_time(1665989933000L))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/margin/isolated/repay_record")
    void getRepaymentRecordIsolated() throws CloudException {
        System.out.println(
                call.callCloud(new MarginIsolatedRepayRecordRequest().setSymbol("BTC_USDT")
                        .setCurrency("USDT"))
        );
        System.out.println(
                call.callCloud(new MarginIsolatedRepayRecordRequest().setSymbol("BTC_USDT")
                        .setRepay_id("be7e0887-5bc9-4775-8e45-567cfa567af7"))
        );
        System.out.println(
                call.callCloud(new MarginIsolatedRepayRecordRequest().setSymbol("BTC_USDT")
                        .setStart_time(1664607368000L).setEnd_time(1665989933000L))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/margin/isolated/pairs")
    void getTradingPairBorrowingRateAndAmount() throws CloudException {
        System.out.println(
                call.callCloud(new MarginIsolatedPairsRequest().setSymbol("BTC_USDT"))
        );
        System.out.println(
                call.callCloud(new MarginIsolatedPairsRequest())
        );
    }
}
