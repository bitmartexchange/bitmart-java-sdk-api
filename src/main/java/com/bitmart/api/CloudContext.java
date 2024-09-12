package com.bitmart.api;

import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public final class CloudContext {
    private boolean isDebug = false;
    private String cloudUrl;
    private long connectTimeoutMilliSeconds = 2000;
    private long readTimeoutMilliSeconds = 10000;
    private long writeTimeoutMilliSeconds = 2000;
    private Map<String, String> customHeaders;
    private CloudKey cloudKey;

    // Not Need Login
    public CloudContext() {
        init(GlobalConst.CLOUD_URL, new CloudKey());
    }

    // Not Need Login
    public CloudContext(String cloudUrl) {
        init(cloudUrl, new CloudKey());
    }


    // Need Login
    public CloudContext(CloudKey cloudKey) {
        init(GlobalConst.CLOUD_URL, cloudKey);
    }


    // Need Login
    public CloudContext(String cloudUrl, CloudKey cloudKey) {
        init(cloudUrl, cloudKey);
    }

    private void init(String cloudCenterUrl, CloudKey cloudKey) {
        this.cloudKey = cloudKey;
        this.cloudUrl = cloudCenterUrl;
    }


}
