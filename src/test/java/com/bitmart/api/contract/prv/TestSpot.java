package com.bitmart.api.contract.prv;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.TestGetRequest;
import com.bitmart.api.request.spot.prv.TestPostRequest;
import com.bitmart.api.request.spot.pub.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestSpot {

    private static String CLOUD_URL =  "http://api-cloud.bitmartdev.com";;
    private static String API_KEY = "80618e45710812162b04892c7ee5ead4a3cc3e56";
    private static String API_SECRET = "6c6c98544461bbe71db2bca4c6d7fd0021e0ba9efc215f9c6ad41852df9d9df9";
    private static String API_MEMO = "test001";
    private static Call call;

    TestSpot(){
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);

    }


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
                call.callCloud(new TickersRequest().setSymbol("BMX_ETH")
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
                call.callCloud(new SymbolsKlineRequest().setSymbol("BMX_ETH")
                        .setFrom(1590493760573L).setTo(1590515317373L).setStep(43200L)
                )
        );
    }

    // 7.获取盘口深度
    @Test
    @DisplayName("Test. GET /spot/v1/symbols/book")
    void testSymbolsBook() throws CloudException {
        System.out.println(
                call.callCloud(new SymbolsBookRequest().setSymbol("XLM_ETH")
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

}
