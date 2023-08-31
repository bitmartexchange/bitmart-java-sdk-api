package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.prv.*;
import com.bitmart.api.request.spot.prv.v4.*;
import com.bitmart.api.request.spot.pub.*;
import com.bitmart.api.request.spot.pub.market.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


final class TestSpot extends TestData {


    // -------------- pub

    @Test
    @DisplayName("Test. GET /spot/v1/test-get")
    void testGET() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TestGetRequest()
                .setSymbol("BTC_USDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());

    }

    @Test
    @DisplayName("Test. POST /spot/v1/test-post")
    void testPOST() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TestPostRequest()
                .setSymbol("BTC_USDT")
                .setPrice("8600")
                .setCount("100")
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/currencies")
    void testCurrencies() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new CurrenciesRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/symbols")
    void testSymbols() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SymbolsRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/v1/symbols/details")
    void testSymbolsDetails() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SymbolsDetailsRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/v2/ticker")
    @Deprecated
    void testTickers() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TickersRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/quotation/v3/tickers")
    void testV3Tickers() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3TickersRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/v1/ticker_detail")
    @Deprecated
    void testTickerDetail() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TickerDetailRequest().setSymbol("BTC_USDT"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/quotation/v3/ticker")
    void testV3Ticker() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3TickerRequest().setSymbol("BTC_USDT"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/v1/steps")
    @Deprecated
    void testSteps() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new StepsRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/v1/symbols/kline")
    @Deprecated
    void testSymbolsKline() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SymbolsKlineRequest()
                .setSymbol("BTC_USDT")
                .setFrom(1654041595L)
                .setTo(1683417595L)
                .setStep(1440)
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/quotation/v3/lite-klines")
    void testV3LatestKline() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3LatestKlineRequest()
                .setSymbol("BTC_USDT")
                .setAfter((System.currentTimeMillis() / 1000) - 3600)
                .setBefore(System.currentTimeMillis() / 1000)
                .setStep(15)
                .setLimit(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/quotation/v3/klines")
    void testV3HistoryKline() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3HistoryKlineRequest()
                .setSymbol("BTC_USDT")
                .setBefore((System.currentTimeMillis() / 1000) - 3600)
                .setAfter(System.currentTimeMillis() / 1000)
                .setStep(15)
                .setLimit(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/v1/symbols/book")
    @Deprecated
    void testSymbolsBook() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(
                new SymbolsBookRequest().setSymbol("BTC_USDT").setSize(10));


        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/quotation/v3/books")
    void testV3Books() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3DepthRequest()
                .setSymbol("BTC_USDT")
                .setLimit(2)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/symbols/trades")
    @Deprecated
    void testSymbolsTrades() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SymbolsTradesRequest().setSymbol("XLM_ETH").setN("20"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/quotation/v3/trades")
    void testV3Trades() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3TradeRequest()
                .setSymbol("BTC_USDT")
                .setLimit(2)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. GET /spot/v1/wallet")
    void testWallet() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new WalletRequest().setCurrency("USDT"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v2/submit_order")
    void testSubmitOrderRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                .setSide("buy")
                .setType("limit")
                .setSymbol("BTC_USDT")
                .setClient_order_id("def123123123")
                .setPrice("800")
                .setSize("0.1"));


        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v1/margin/submit_order")
    void testMarginOrderRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginSubmitOrderRequest()
                .setSide("buy")
                .setType("limit")
                .setSymbol("BTC_USDT")
                .setPrice("8800")
                .setSize("0.1"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v2/batch_orders")
    void testBatchOrdersRequest() throws CloudException {
        List<OrderParams> orderParams = new ArrayList<>();
        orderParams.add(new OrderParams()
                .setSymbol("BTC_USDT")
                .setType("limit")
                .setSide("buy")
                .setPrice("8800")
                .setSize("0.1"));

        orderParams.add(new OrderParams()
                .setSymbol("BTC_USDT")
                .setType("limit")
                .setSide("buy")
                .setPrice("8800")
                .setSize("0.2"));

        final CloudResponse cloudResponse = call.callCloud(new BatchOrdersRequest().setOrder_params(orderParams));


        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. POST /spot/v3/cancel_order")
    void testCancelOrder() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new CancelOrderRequest().setSymbol("BTC_USDT").setOrder_id("2147602398"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());

        final CloudResponse cloudResponse1 = call.callCloud(new CancelOrderRequest().setSymbol("BTC_USDT").setClient_order_id("ID125783"));
        System.out.println(cloudResponse1);
        assertEquals(200, cloudResponse1.getResponseHttpStatus());

    }

    @Test
    @DisplayName("Test. POST /spot/v1/cancel_orders")
    void testCancelOrders() throws CloudException {

        final CloudResponse cloudResponse = call.callCloud(new CancelOrdersRequest().setSymbol("BTC_USDT").setSide("buy"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v2/order_detail")
    void testOrderDetail() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new OrderDetailRequest().setOrder_id("2147484422"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v3/orders")
    void testOrdersV3() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new OrdersRequest().setSymbol("BTC_USDT").setStatus("10")
                .setStart_time(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7)
                .setEnd_time(System.currentTimeMillis()));//Query the records of the last 7 days

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v2/trades")
    void testTradesHistory() throws CloudException {
        System.out.println(
                call.callCloud(new TradesHistoryRequest().setSymbol("BTC_USDT"))   //Default last 90 days
        );

        final CloudResponse cloudResponse = call.callCloud(new TradesHistoryRequest().setSymbol("BTC_USDT")
                .setStart_time(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7)
                .setEnd_time(System.currentTimeMillis()));//Query the records of the last 7 days

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v2/trades")
    void testTradesDetail() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new TradesDetailRequest().setSymbol("BTC_USDT").setOrder_id("2147484422"));

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    // ------------------------------  v4 spot query -----------------------------

    @Test
    @DisplayName("Test. POST /spot/v4/query/order")
    void testV4QueryOrderByOrderIdRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V4QueryOrderByOrderIdRequest()
                .setOrderId("118100034543076010")
                .setQueryState("open")
                .setRecvWindow(5000L)
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v4/query/client-order")
    void testV4QueryOrderByClientOrderIdRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V4QueryOrderByClientOrderIdRequest()
                .setClientOrderId("def123123123")
                .setQueryState("open")
                .setRecvWindow(5000L)
        );


        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v4/query/open-orders")
    void testV4QueryOpenOrdersRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V4QueryOpenOrdersRequest()
                .setSymbol("BTC_USDT")
                .setOrderMode("spot")
                .setLimit(101)
                .setRecvWindow(1000L)
                .setStartTime(System.currentTimeMillis() - 10000L)
                .setEndTime(System.currentTimeMillis() - 5000L)
        );


        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v4/query/order-trades")
    void testV4QueryOrderTradesRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V4QueryOrderTradesRequest()
                .setOrderId("118100034543076010")
                .setRecvWindow(5000L)
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v4/query/trades")
    void testV4QueryTradesRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V4QueryTradesRequest()
                .setSymbol("BTC_USDT")
                .setOrderMode("spot")
                .setLimit(10)
                .setStartTime(System.currentTimeMillis() - 10000L)
                .setEndTime(System.currentTimeMillis() - 5000L)
                .setRecvWindow(5000L)
        );


        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. POST /spot/v4/query/history-orders")
    void testV4QueryHistoryOrdersRequest() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V4QueryHistoryOrdersRequest()
                .setSymbol("BTC_USDT")
                .setOrderMode("spot")
                .setStartTime(System.currentTimeMillis() - 10000L)
                .setEndTime(System.currentTimeMillis() - 5000L)
                .setLimit(10)
                .setRecvWindow(5000L)
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


}
