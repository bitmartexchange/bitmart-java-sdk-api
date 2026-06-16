package com.bitmart.api.request.finance.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Finance — query the auto-subscribe status of a specific flexible savings product
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingSubscribeStatusRequest extends CloudRequest {

    /**
     * Product ID
     */
    @ParamKey(value = "productId", required = true)
    private String productId;

    public SavingSubscribeStatusRequest() {
        super("/newearn/cloud/v1/saving/subscribe/status", Method.GET, Auth.KEYED);
    }
}
