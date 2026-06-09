package com.bitmart.examples;

import com.bitmart.api.common.GlobalConst;

public class Example {

    // Values are resolved from the project-local .env file first, then system
    // environment variables, then the hardcoded defaults below (see EnvConfig).
    public static final String YOUR_API_KEY = EnvConfig.get(
        "BITMART_API_KEY",
        "your_api_key"
    );
    public static final String YOUR_API_SECRET = EnvConfig.get(
        "BITMART_SECRET_KEY",
        "your_secret_key"
    );
    public static final String YOUR_API_MEMO = EnvConfig.get(
        "BITMART_MEMO",
        "your_memo"
    );
    public static final String SPOT_HOST = EnvConfig.get(
        "BITMART_API_URL",
        GlobalConst.CLOUD_URL
    );
    public static final String FUTURES_HOST = EnvConfig.get(
        "BITMART_API_URL",
        GlobalConst.CLOUD_V2_URL
    );
}
