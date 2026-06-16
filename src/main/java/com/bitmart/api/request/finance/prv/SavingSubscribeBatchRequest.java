package com.bitmart.api.request.finance.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Finance — query the global auto-earn (auto-subscribe) status. No request parameters.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingSubscribeBatchRequest extends CloudRequest {

    public SavingSubscribeBatchRequest() {
        super("/newearn/cloud/v1/saving/subscribe/batch", Method.GET, Auth.KEYED);
    }
}
