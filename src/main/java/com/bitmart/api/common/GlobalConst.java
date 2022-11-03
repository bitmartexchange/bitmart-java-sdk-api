package com.bitmart.api.common;

public final class GlobalConst {
    public static final String USER_AGENT = "User-Agent";
    public static final String X_BM_KEY = "X-BM-KEY";
    public static final String X_BM_TIMESTAMP = "X-BM-TIMESTAMP";
    public static final String X_BM_SIGN = "X-BM-SIGN";
    public static final String CLOUD_URL = "https://api-cloud.bitmart.com";
    public static final String CLOUD_WS_URL = "wss://ws-manager-compress.bitmart.com/api?protocol=1.1"; // public channel
    public static final String CLOUD_WS_PRIVATE_URL = "wss://ws-manager-compress.bitmart.com/user?protocol=1.1"; // private channel
    public static final String CLOUD_CONTRACT_WS_URL = "wss://openapi-ws.bitmart.com/api?protocol=1.1";
    public static final String CLOUD_CONTRACT_WS_PRIVATE_URL = "wss://openapi-ws.bitmart.com/user?protocol=1.1";

    private GlobalConst() {
        throw new IllegalStateException("Utility class");
    }
}
