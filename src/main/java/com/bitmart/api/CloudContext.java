package com.bitmart.api;

import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public final class CloudContext {
    private String cloudUrl;
    private CloudKey cloudKey;

    public CloudContext(CloudKey cloudKey) {
        init(GlobalConst.CLOUD_URL, cloudKey);
    }

    public CloudContext(String cloudUrl, CloudKey cloudKey) {
        init(cloudUrl, cloudKey);
    }

    private void init(String cloudCenterUrl, CloudKey cloudKey) {
        this.cloudKey = cloudKey;
        this.cloudUrl = cloudCenterUrl;
    }

}
