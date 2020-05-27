package com.bitmart.api.contract.prv;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.TestGetRequest;
import com.bitmart.api.request.spot.prv.TestPostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestSpot {

    private static String CLOUD_URL =  "http://localhost:8080";;
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



}
