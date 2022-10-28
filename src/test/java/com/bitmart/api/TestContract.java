package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.request.contract.pub.*;
import com.bitmart.api.request.contract.prv.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class TestContract extends TestData {

    // ------------------  public -------------------------

    @Test
    @DisplayName("Test. GET /contract/v1/tickers")
    void contracts() throws CloudException {
        System.out.println(
                call.callCloud(new TickerRequest().setContract_symbol("ETHUSDT"))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/public/details")
    void details() throws CloudException {
        System.out.println(
                call.callCloud(new DetailsRequest().setSymbol("ETHUSDT"))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/public/depth")
    void depth() throws CloudException {
        System.out.println(
                call.callCloud(new DepthRequest().setSymbol("ETHUSDT"))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/public/open-interest")
    void openInterest() throws CloudException {
        System.out.println(
                call.callCloud(new OpenInterestRequest().setSymbol("ETHUSDT"))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/public/funding-rate")
    void fundingRate() throws CloudException {
        System.out.println(
                call.callCloud(new FundingRateRequest().setSymbol("ETHUSDT"))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/public/kline")
    void kline() throws CloudException {
        System.out.println(
                call.callCloud(new KlineRequest().setSymbol("BTCUSDT").setStep(5L)
                        .setStart_time(1662518172L).setEnd_time(1662518172L))
        );
    }

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. GET /contract/private/assets-detail")
    void assetsDetail() throws CloudException {
        System.out.println(
                call.callCloud(new AssetsDetailRequest())
        );
    }

    @Test
    @DisplayName("Test. GET /contract/private/order")
    void order() throws CloudException {
        System.out.println(
                call.callCloud(new OrderRequest().setOrder_id("220609666322019"))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/private/order-history")
    void orderHistory() throws CloudException {
        System.out.println(
                call.callCloud(new OrderHistoryRequest().setSymbol("BTCUSDT").setStart_time(1662368173L).setEnd_time(1662368179L))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/private/position")
    void position() throws CloudException {
        System.out.println(
                call.callCloud(new PositionRequest().setSymbol("BTCUSDT"))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/private/trades")
    void trades() throws CloudException {
        System.out.println(
                call.callCloud(new TradesRequest().setSymbol("BTCUSDT").setStart_time(1662368173L).setEnd_time(1662368179L))
        );
    }


    @Test
    @DisplayName("Test. POST /contract/private/submit-order")
    void submitOrder() throws CloudException {
        System.out.println(
                call.callCloud(new SubmitOrderRequest().setSymbol("ETHUSDT").setType("limit")
                        .setSide(4).setLeverage("1").setOpen_type("isolated").setSize(10).setPrice("2000"))
        );
    }

    @Test
    @DisplayName("Test. POST /contract/private/cancel-order")
    void cancelOrder() throws CloudException {
        System.out.println(
                call.callCloud(new CancelOrderRequest().setSymbol("BTCUSDT").setOrder_id("220906179559421"))
        );
    }

    @Test
    @DisplayName("Test. POST /contract/private/cancel-orders")
    void cancelOrders() throws CloudException {
        System.out.println(
                call.callCloud(new CancelOrdersRequest().setSymbol("BTCUSDT"))
        );
    }
}
