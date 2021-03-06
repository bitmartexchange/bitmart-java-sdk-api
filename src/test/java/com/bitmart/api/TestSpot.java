package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.request.spot.prv.*;
import com.bitmart.api.request.spot.pub.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public final class TestSpot extends TestData {


    // -------------- prv

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

    // 1.获取币种列表
    @Test
    @DisplayName("Test. GET /spot/v1/currencies")
    void testCurrencies() throws CloudException {
        System.out.println(
                call.callCloud(new CurrenciesRequest()
                )
        );
    }

    // 2.获取交易对列表
    @Test
    @DisplayName("Test. GET /spot/v1/symbols")
    void testSymbols() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsRequest()
                )
        );
    }


    // 3.获取交易对详情列表
    @Test
    @DisplayName("Test. GET /spot/v1/symbols/details")
    void testSymbolsDetails() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsDetailsRequest()
                )
        );
    }


    // 4.获取交易对详情列表
    @Test
    @DisplayName("Test. GET /spot/v1/ticker")
    void testTickers() throws CloudException {
        System.out.println(
                call.callCloud(new TickersRequest().setSymbol("BTC_USDT")
                )
        );
    }


    // 5.获取支持的 K 线周期
    @Test
    @DisplayName("Test. GET /spot/v1/steps")
    void testSteps() throws CloudException {
        System.out.println(
                call.callCloud(new StepsRequest()
                )
        );
    }


    // 6.获取 K 线
    @Test
    @DisplayName("Test. GET /spot/v1/symbols/kline")
    void testSymbolsKline() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsKlineRequest().setSymbol("BTC_USDT")
                        .setFrom(1590493760L).setTo(1590515317L).setStep(60)
                )
        );
    }

    // 7.获取盘口深度
    @Test
    @DisplayName("Test. GET /spot/v1/symbols/book")
    void testSymbolsBook() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsBookRequest().setSymbol("BTC_USDT").setSize(10)
                )
        );
    }

    // 8.获取最近成交记录
    @Test
    @DisplayName("Test. GET /spot/v1/symbols/trades")
    void testSymbolsTrades() throws CloudException {
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


    // ---- limit order
    @Test
    @DisplayName("Test. GET /spot/v1/submit_order")
    void submitBuyLimitOrderRequest() throws CloudException {
        System.out.println(
                call.callCloud(new SubmitBuyLimitOrderRequest().setSymbol("BTC_USDT").setPrice("8800").setSize("0.1"))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/submit_order")
    void submitSellLimitOrderRequest() throws CloudException {
        System.out.println(
                call.callCloud(new SubmitSellLimitOrderRequest().setSymbol("BTC_USDT").setPrice("9100").setSize("10"))
        );
    }

    @Test
    @DisplayName("Test. GET /spot/v1/submit_order")
    void submitBuyMarketOrderRequest() throws CloudException {
        System.out.println(
                call.callCloud(new SubmitBuyMarketOrderRequest().setSymbol("ETH_USDT").setNotional("1000"))
        );
    }


    @Test
    @DisplayName("Test. GET /spot/v1/submit_order")
    void submitSellMarketOrderRequest() throws CloudException {
        System.out.println(
                call.callCloud(new SubmitSellMarketOrderRequest().setSymbol("BTC_USDT").setSize("0.02"))
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
    @DisplayName("Test. GET /spot/v1/orders")
    void orders() throws CloudException {
        System.out.println(
                call.callCloud(new OrdersRequest().setSymbol("BTC_USDT").setOffset(1).setLimit(10).setStatus("6"))
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
