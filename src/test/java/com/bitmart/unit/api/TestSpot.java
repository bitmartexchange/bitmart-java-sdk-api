package com.bitmart.unit.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.prv.*;
import com.bitmart.api.request.spot.prv.v4.*;
import com.bitmart.api.request.spot.pub.*;
import com.bitmart.api.request.spot.pub.market.*;
import com.bitmart.unit.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


final class TestSpot extends TestData {


    // -------------- pub

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
    @DisplayName("Test. GET /spot/quotation/v3/tickers")
    void testV3Tickers() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3TickersRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /spot/quotation/v3/ticker")
    void testV3Ticker() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3TickerRequest().setSymbol("BTC_USDT"));

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
    @DisplayName("Test. GET /spot/quotation/v3/books")
    void testV3Books() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new V3DepthRequest()
                .setSymbol("BTC_USDT")
                .setLimit(2)
        );
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
                .setSize("0.1")
                .setStpMode("cancel_taker")); // cancel_taker


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
    @DisplayName("Test. POST /spot/v4/batch_orders")
    void testBatchOrdersRequest() throws CloudException {
        List<OrderParams> orderParams = new ArrayList<>();
        orderParams.add(new OrderParams()
                .setClientOrderId("12312312")
                .setType("limit")
                .setSide("buy")
                .setPrice("8800")
                .setSize("0.1")
                .setStpMode("cancel_taker")); // cancel_taker

        orderParams.add(new OrderParams()
                .setClientOrderId("12312312333")
                .setType("limit")
                .setSide("buy")
                .setPrice("8800")
                .setSize("0.2")
                .setStpMode("cancel_maker")); // cancel_maker

        final CloudResponse cloudResponse = call.callCloud(new BatchOrdersRequest()
                        .setSymbol("BTC_USDT")
                        .setOrderParams(orderParams));

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
    @DisplayName("Test. POST /spot/v4/cancel_orders")
    void testCancelOrders() throws CloudException {

        List<String> orderIds = new ArrayList<>();
        orderIds.add("2147602398");
        orderIds.add("2147602399");

        final CloudResponse cloudResponse = call.callCloud(new CancelOrdersRequest()
                .setSymbol("BTC_USDT").setOrderIds(orderIds));

        assertEquals(200, cloudResponse.getResponseHttpStatus());



        List<String> clientOrderIds = new ArrayList<>();
        clientOrderIds.add("2147602398");
        clientOrderIds.add("2147602399");

        final CloudResponse cloudResponse2 = call.callCloud(new CancelOrdersRequest()
                .setSymbol("BTC_USDT").setClientOrderIds(clientOrderIds));

        assertEquals(200, cloudResponse2.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v4/cancel_all")
    void testCancelAllOrder() throws CloudException {

        final CloudResponse cloudResponse = call.callCloud(new CancelAllOrderRequest()
                .setSymbol("BTC_USDT").setSide("buy"));

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
