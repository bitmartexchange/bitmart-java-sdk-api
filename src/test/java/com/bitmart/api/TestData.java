package com.bitmart.api;

import com.bitmart.api.key.CloudKey;

public class TestData {

    public static String CLOUD_URL = "https://api-cloud.bitmart.com";
    public static String CLOUD_WS_URL = "wss://ws-manager-compress.bitmart.com/api?protocol=1.1";
    public static String CLOUD_WS_PRIVATE_URL = "wss://ws-manager-compress.bitmart.com/user?protocol=1.1";
    public static String API_KEY = "YOUR ACCESS KEY";
    public static String API_SECRET = "YOUR SECRET KEY";
    public static String API_MEMO = "YOUR MEMO";
    static Call call;

    TestData() {
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);

    }

}
