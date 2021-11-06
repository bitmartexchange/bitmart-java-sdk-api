package com.bitmart.api;

import com.bitmart.api.key.CloudKey;

public class TestData {

    /**
     * http://api-cloud.bitmartdev.com
     * https://api-cloud.bitmarttest.com/
     * https://api-cloud.bitmart.com
     */
    public static String CLOUD_URL =  "http://api-cloud.bitmartdev.com";
    public static String CLOUD_WS_URL =  "wss://ws-manager-compress.bitmart.com/?protocol=1.1";
    public static String API_KEY = "a4f3340a98665714f6090f3eeb11b948f0540101";
    public static String API_SECRET = "3602520a8d1fc0995bdab4df16ee58032328c97c34627feb80f2fba42985c57f";
    public static String API_MEMO = "songlei";
    static Call call;

    TestData() {
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);

    }

}
