package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.contract.pub.*;
import com.bitmart.api.request.contract.prv.*;
import com.bitmart.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TestContract extends TestData {

    // ------------------  public -------------------------
    @Test
    @DisplayName("Test. GET /contract/public/details")
    void testDetails() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new DetailsRequest().setSymbol("ETHUSDT"));
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/public/depth")
    void testDepth() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new DepthRequest().setSymbol("ETHUSDT"));
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/public/open-interest")
    void testOpenInterest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new OpenInterestRequest().setSymbol("ETHUSDT"));
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/public/funding-rate")
    void testFundingRate() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new FundingRateRequest().setSymbol("ETHUSDT"));
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/public/kline")
    void testKline() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new KlineRequest()
                .setSymbol("BTCUSDT")
                .setStep(5)
                .setStartTime(1662518172L)
                .setEndTime(1662518172L));
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. GET /contract/private/assets-detail")
    void testAssetsDetail() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AssetsDetailRequest());
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/order")
    void testGetOrderDetail() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new GetOrderDetailRequest()
                        .setSymbol("BTCUSDT")
                        .setOrderId("220609666322019")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/order-history")
    void testGetOrderHistory() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new GetOrderHistoryRequest()
                .setSymbol("BTCUSDT")
                .setStartTime(1662368173L)
                .setEndTime(1662368179L)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/get-open-orders")
    void testGetOpenOrders() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new GetAllOpenOrdersRequest()
                .setSymbol("BTCUSDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/current-plan-order")
    void testGetAllCurrentPlanOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new GetAllCurrentPlanOrdersRequest()
                .setSymbol("BTCUSDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/position")
    void testPosition() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new GetPositionRequest()
                .setSymbol("BTCUSDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/position-risk")
    void testPositionRisk() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new GetPositionRiskRequest()
                .setSymbol("BTCUSDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/trades")
    void testTrades() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TradesRequest()
                .setSymbol("ETHUSDT")
                .setStartTime(1681700068L)
                .setEndTime(1681721668L)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // -----------------  Trading -------------------------

    @Test
    @DisplayName("Test. POST /contract/private/submit-order")
    void testSubmitOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                .setSymbol("ETHUSDT")
                .setClientOrderId("def112xxx")
                .setType("limit")
                .setSide(4)
                .setLeverage("1")
                .setOpenType("isolated")
                .setSize(10)
                .setPrice("2000")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /contract/private/cancel-order")
     void testCancelOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new CancelOrderRequest()
                .setSymbol("ETHUSDT")
                .setOrderId("230831544021682")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /contract/private/cancel-orders")
    void testCancelOrders() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new CancelOrdersRequest()
                .setSymbol("BTCUSDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. POST /contract/private/submit-leverage")
    void testSubmitLeverage() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubmitLeverageRequest()
                .setSymbol("BTCUSDT")
                .setLeverage("1")
                .setOpenType("isolated")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. POST /contract/private/submit-plan-order")
    void testSubmitPlanOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubmitPlanOrderRequest()
                .setSymbol("BTCUSDT")
                .setType("limit")
                .setSide(4)
                .setLeverage("1")
                .setOpenType("isolated")
                .setMode(1)
                .setSize(10)
                .setTriggerPrice("25300")
                .setExecutivePrice("27300")
                .setPriceWay(1)
                .setPriceType(1)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /contract/private/cancel-plan-order")
    void testCancelPlanOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new CancelPlanOrderRequest()
                .setSymbol("BTCUSDT")
                .setOrderId("230831544071055")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }



    @Test
    @DisplayName("Test. POST /account/v1/transfer-contract")
    void testTransfer() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TransferRequest()
                .setCurrency("BTC")
                .setAmount("10")
                .setType("spot_to_contract")
                .setRecvWindow(5000L)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /account/v1/transfer-contract-list")
    void testTransferList() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TransferListRequest()
                .setCurrency("USDT")
                .setTimeStart(System.currentTimeMillis()-24*60*1000)
                .setTimeEnd(System.currentTimeMillis())
                .setPage(1)
                .setLimit(10)
                .setRecvWindow(5000L)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

}
