package com.bitmart.api;

import com.bitmart.api.key.CloudKey;

public class TestData {

    private static String CLOUD_URL =  "http://api-cloud.bitmartdev.com";
    private static String API_KEY = "80618e45710812162b04892c7ee5ead4a3cc3e56";
    private static String API_SECRET = "6c6c98544461bbe71db2bca4c6d7fd0021e0ba9efc215f9c6ad41852df9d9df9";
    private static String API_MEMO = "test001";
    static Call call;

    TestData() {
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);
    }

}
