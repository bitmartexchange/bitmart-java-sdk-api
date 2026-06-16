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
 * Finance — modify the auto-renewal (auto-subscribe) setting of a fixed savings order
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingFixedSubscribeOperateRequest extends CloudRequest {

    /**
     * Savings order ID
     */
    @ParamKey(value = "earnId", required = true)
    private String earnId;

    /**
     * Auto-subscribe type
     * -OFF
     * -REINVEST_FLEXIBLE
     * -REINVEST_FIXED
     */
    @ParamKey(value = "autoSubscribe", required = true)
    private String autoSubscribe;

    public SavingFixedSubscribeOperateRequest() {
        super("/newearn/cloud/v1/saving/fixed/subscribe/operate", Method.POST, Auth.SIGNED);
    }
}
