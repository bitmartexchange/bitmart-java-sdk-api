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
    @DisplayName("Test. GET /spot/v1/ticker")
    void testTickers() throws CloudException {
        System.out.println(
                call.callCloud(new TickersRequest().setSymbol("BTC_USDT")
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
    @DisplayName("Test. POST /spot/v1/submit_order")
    void submitOrderRequest() throws CloudException {
        System.out.println(
                call.callCloud(new SubmitOrderRequest()
                        .setSide("buy").setType("limit")
                        .setSymbol("BTC_USDT").setPrice("8800").setSize("0.1"))
        );
    }

    @Test
    @DisplayName("Test. POST /spot/v1/batch_orders")
    void batchOrdersRequest() throws CloudException {
        List<OrderParams> orderParams = new ArrayList<>();
        orderParams.add(new OrderParams().setSymbol("BTC_USDT").setType("limit").setSide("buy")
                .setPrice("8800").setSize("0.1"));
        System.out.println(
                call.callCloud(new BatchOrdersRequest().setOrderParams(orderParams))
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v2/cancel_order")
    void cancel_order() throws CloudException {
        System.out.println(
                call.callCloud(new CancelOrderRequest().setSymbol("BTC_USDT").setOrder_id(2147602398L))
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v1/cancel_orders")
    void cancel_orders() throws CloudException {
        System.out.println(
                call.callCloud(new CancelOrdersRequest().setSymbol("BTC_USDT").setSide("buy"))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/order_detail")
    void order_detail() throws CloudException {
        System.out.println(
                call.callCloud(new OrderDetailRequest().setSymbol("BTC_USDT").setOrder_id(2147484422L))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v2/orders")
    void ordersV2() throws CloudException {
        System.out.println(
                call.callCloud(new OrdersV2Request().setSymbol("BTC_USDT").setN(10).setStatus("6"))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/trades")
    void trades_history() throws CloudException {
        System.out.println(
                call.callCloud(new TradesHistoryRequest().setSymbol("BTC_USDT").setOffset(1).setLimit(10))
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v1/trades")
    void trades_detail() throws CloudException {
        System.out.println(
                call.callCloud(new TradesDetailRequest().setSymbol("BTC_USDT").setOrder_id(2147484422L))
        );
    }


}
