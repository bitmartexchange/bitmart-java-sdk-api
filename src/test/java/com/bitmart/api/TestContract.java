package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.contract.pub.*;
import com.bitmart.api.request.contract.prv.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TestContract extends TestData {

    // ------------------  public -------------------------

    @Test
    @DisplayName("Test. GET /contract/v1/tickers")
    void testTickers() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TickerRequest().setContract_symbol("ETHUSDT"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());

    }

    @Test
    @DisplayName("Test. GET /contract/public/details")
    void testDetails() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new DetailsRequest().setSymbol("ETHUSDT"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());

    }

    @Test
    @DisplayName("Test. GET /contract/public/depth")
    void testDepth() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new DepthRequest().setSymbol("ETHUSDT"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/public/open-interest")
    void testOpenInterest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new OpenInterestRequest().setSymbol("ETHUSDT"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/public/funding-rate")
    void testFundingRate() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new FundingRateRequest().setSymbol("ETHUSDT"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/public/kline")
    void testKline() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new KlineRequest()
                .setSymbol("BTCUSDT")
                .setStep(5L)
                .setStart_time(1662518172L)
                .setEnd_time(1662518172L));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. GET /contract/private/assets-detail")
    void testAssetsDetail() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AssetsDetailRequest());


        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/order")
    void testOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new OrderRequest()
                .setOrder_id("220609666322019"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/order-history")
    void testOrderHistory() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new OrderHistoryRequest()
                .setSymbol("BTCUSDT")
                .setStart_time(1662368173L)
                .setEnd_time(1662368179L));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/position")
    void testPosition() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new PositionRequest().setSymbol("BTCUSDT"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /contract/private/trades")
    void testTrades() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TradesRequest()
                .setSymbol("ETHUSDT")
                .setStart_time(1681700068L)
                .setEnd_time(1681721668L));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // 230418169339089
    // 230418169333784
    @Test
    @DisplayName("Test. POST /contract/private/submit-order")
    void testSubmitOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                .setSymbol("ETHUSDT")
                .setType("limit")
                .setSide(4)
                .setLeverage("1")
                .setOpen_type("isolated")
                .setSize(10)
                .setPrice("2000"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /contract/private/cancel-order")
    void testCancelOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new CancelOrderRequest()
                .setSymbol("BTCUSDT")
                .setOrder_id("230507203936356"));

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /contract/private/cancel-orders")
    void testCancelOrders() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new CancelOrdersRequest().setSymbol("BTCUSDT"));

        System.out.println(cloudResponse);
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

        System.out.println(cloudResponse);
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

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

}
