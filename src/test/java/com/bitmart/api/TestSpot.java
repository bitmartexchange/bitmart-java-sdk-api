package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.request.spot.prv.*;
import com.bitmart.api.request.spot.pub.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public final class TestSpot extends TestData {


    // -------------- pub

    @Test
    @DisplayName("Test. GET /spot/v1/test-get")
    void testGET() throws CloudException {
        System.out.println(
                call.callCloud(new TestGetRequest()
                        .setSymbol("BTC_USDT")
                )
        );
    }

    @Test
    @DisplayName("Test. POST /spot/v1/test-post")
    void testPOST() throws CloudException {
        System.out.println(
                call.callCloud(new TestPostRequest()
                        .setSymbol("BTC_USDT")
                        .setPrice("8600")
                        .setCount("100")
                )
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/currencies")
    void testCurrencies() throws CloudException {
        System.out.println(
                call.callCloud(new CurrenciesRequest()
                )
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/symbols")
    void testSymbols() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsRequest()
                )
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v1/symbols/details")
    void testSymbolsDetails() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsDetailsRequest()
                )
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v2/ticker")
    void testTickers() throws CloudException {
        System.out.println(
                call.callCloud(new TickersRequest()
                )
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v1/ticker_detail")
    void testTickerDetail() throws CloudException {
        System.out.println(
                call.callCloud(new TickerDetailRequest().setSymbol("BTC_USDT")
                )
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v1/steps")
    void testSteps() throws CloudException {
        System.out.println(
                call.callCloud(new StepsRequest()
                )
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v1/symbols/kline")
    void testSymbolsKline() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsKlineRequest().setSymbol("BTC_USDT")
                        .setFrom(1590493760L).setTo(1590515317L).setStep(60)
                )
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/symbols/book")
    void testSymbolsBook() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsBookRequest().setSymbol("BTC_USDT").setSize(10)
                )
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/symbols/trades")
    void testSymbolsTrades() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsTradesRequest().setSymbol("XLM_ETH").setN("20")
                )
        );
        System.out.println(
                call.callCloud(new SymbolsTradesRequest().setSymbol("XLM_ETH")
                )
        );
    }

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. GET /spot/v1/wallet")
    void wallet() throws CloudException {
        System.out.println(
                call.callCloud(new WalletRequest())
        );
    }

    @Test
    @DisplayName("Test. POST /spot/v2/submit_order")
    void submitOrderRequest() throws CloudException {
        System.out.println(
                call.callCloud(new SubmitOrderRequest()
                        .setSide("buy").setType("limit")
                        .setSymbol("BTC_USDT").setPrice("8800").setSize("0.1"))
        );
    }

    @Test
    @DisplayName("Test. POST /spot/v1/margin/submit_order")
    void marginOrderRequest() throws CloudException {
        System.out.println(
                call.callCloud(new MarginSubmitOrderRequest()
                        .setSide("buy").setType("limit")
                        .setSymbol("BTC_USDT").setPrice("8800").setSize("0.1"))
        );
    }

    @Test
    @DisplayName("Test. POST /spot/v2/batch_orders")
    void batchOrdersRequest() throws CloudException {
        List<OrderParams> orderParams = new ArrayList<>();
        orderParams.add(new OrderParams().setSymbol("BTC_USDT").setType("limit").setSide("buy")
                .setPrice("8800").setSize("0.1"));
        System.out.println(
                call.callCloud(new BatchOrdersRequest().setOrder_params(orderParams))
        );
    }


    @Test
    @DisplayName("Test. POST /spot/v3/cancel_order")
    void cancelOrder() throws CloudException {
        System.out.println(
                call.callCloud(new CancelOrderRequest().setSymbol("BTC_USDT").setOrder_id("2147602398"))
        );
        System.out.println(
                call.callCloud(new CancelOrderRequest().setSymbol("BTC_USDT").setClient_order_id("ID125783"))
        );
    }

    @Test
    @DisplayName("Test. POST /spot/v1/cancel_orders")
    void cancelOrders() throws CloudException {
        System.out.println(
                call.callCloud(new CancelOrdersRequest().setSymbol("BTC_USDT").setSide("buy"))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v2/order_detail")
    void orderDetail() throws CloudException {
        System.out.println(
                call.callCloud(new OrderDetailRequest().setOrder_id("2147484422"))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v3/orders")
    void ordersV3() throws CloudException {
        System.out.println(
                call.callCloud(new OrdersRequest().setSymbol("BTC_USDT").setStatus("10"))   //Default last 90 days
        );
        System.out.println(
                call.callCloud(new OrdersRequest().setSymbol("BTC_USDT").setStatus("10")
                        .setStart_time(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7)
                        .setEnd_time(System.currentTimeMillis()))   //Query the records of the last 7 days
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v2/trades")
    void tradesHistory() throws CloudException {
        System.out.println(
                call.callCloud(new TradesHistoryRequest().setSymbol("BTC_USDT"))   //Default last 90 days
        );
        System.out.println(
                call.callCloud(new TradesHistoryRequest().setSymbol("BTC_USDT")
                        .setStart_time(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7)
                        .setEnd_time(System.currentTimeMillis()))   //Query the records of the last 7 days
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v2/trades")
    void tradesDetail() throws CloudException {
        System.out.println(
                call.callCloud(new TradesDetailRequest().setSymbol("BTC_USDT").setOrder_id("2147484422"))
        );
    }


}
