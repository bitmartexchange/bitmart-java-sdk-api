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
 * Finance — subscribe to a fixed savings product
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingFixedSubscribeRequest extends CloudRequest {

    /**
     * Product ID
     */
    @ParamKey(value = "productId", required = true)
    private String productId;

    /**
     * Subscription amount
     */
    @ParamKey(value = "amount", required = true)
    private String amount;

    /**
     * Unique request number, length 20, numeric (0-9), used for idempotency
     */
    @ParamKey(value = "requestNo", required = true)
    private String requestNo;

    /**
     * Auto-subscribe type
     * -OFF
     * -REINVEST_FLEXIBLE
     * -REINVEST_FIXED
     */
    @ParamKey(value = "autoSubscribe", required = true)
    private String autoSubscribe;

    public SavingFixedSubscribeRequest() {
        super("/newearn/cloud/v1/saving/fixed/subscribe", Method.POST, Auth.SIGNED);
    }
}
