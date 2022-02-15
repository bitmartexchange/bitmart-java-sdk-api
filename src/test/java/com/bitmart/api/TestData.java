package com.bitmart.api;

import com.bitmart.api.key.CloudKey;

public class TestData {

    public static String CLOUD_URL = "https://api-cloud.bitmart.com";
    public static String CLOUD_WS_URL = "wss://ws-manager-compress.bitmart.com/api?protocol=1.1";
    public static String CLOUD_WS_PRIVATE_URL = "wss://ws-manager-compress.bitmart.com/user?protocol=1.1";
    public static String API_KEY = "80618e45710812162b04892c7ee5ead4a3cc3e56";
    public static String API_SECRET = "6c6c98544461bbe71db2bca4c6d7fd0021e0ba9efc215f9c6ad41852df9d9df9";
    public static String API_MEMO = "test001";
    static Call call;

    TestData() {
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);

    }

}
