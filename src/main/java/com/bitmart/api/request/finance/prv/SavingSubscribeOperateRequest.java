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
 * Finance — turn the auto-subscribe of a specific flexible savings product on or off
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingSubscribeOperateRequest extends CloudRequest {

    /**
     * Product ID
     */
    @ParamKey(value = "productId", required = true)
    private String productId;

    /**
     * Auto-subscribe action
     * -open
     * -close
     */
    @ParamKey(value = "autoSubscribe", required = true)
    private String autoSubscribe;

    public SavingSubscribeOperateRequest() {
        super("/newearn/cloud/v1/saving/subscribe/operate", Method.POST, Auth.SIGNED);
    }
}
