package com.bitmart.unit.data;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import com.bitmart.examples.EnvConfig;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    // Resolved from the project-local .env file first, then system env vars, then defaults.
    public static String API_KEY = EnvConfig.get("BITMART_API_KEY", "your_api_key");
    public static String API_SECRET = EnvConfig.get("BITMART_SECRET_KEY", "your_secret_key");
    public static String API_MEMO = EnvConfig.get("BITMART_MEMO", "your_memo");
    public static String SPOT_URL = EnvConfig.get("BITMART_API_URL", GlobalConst.CLOUD_URL);
    public static String FUTURES_URL = EnvConfig.get("BITMART_API_URL", GlobalConst.CLOUD_V2_URL);
    public static Call call;

    public TestData() {
        CloudContext cloudContext = new CloudContext(SPOT_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        cloudContext.setReadTimeoutMilliSeconds(10000); // Set read timeout
        // Set your custom headers
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("Your-Custom-Header", "xxxxx");
        cloudContext.setCustomHeaders(customHeaders);
        call = new Call(cloudContext);

    }

}
