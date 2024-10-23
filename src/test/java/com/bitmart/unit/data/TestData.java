package com.bitmart.unit.data;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    public static String API_KEY = "your_api_key";
    public static String API_SECRET = "your_secret_key";
    public static String API_MEMO = "your_memo";
    public static Call call;

    public TestData() {
        CloudContext cloudContext = new CloudContext(GlobalConst.CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        cloudContext.setReadTimeoutMilliSeconds(10000); // Set read timeout
        // Set your custom headers
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("Your-Custom-Header", "xxxxx");
        cloudContext.setCustomHeaders(customHeaders);
        call = new Call(cloudContext);

    }

}
