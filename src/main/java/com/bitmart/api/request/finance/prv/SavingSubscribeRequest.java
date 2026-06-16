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
 * Finance — subscribe to a flexible savings product
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingSubscribeRequest extends CloudRequest {

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
     * Unique request number, 20-digit numeric string, used for idempotency
     */
    @ParamKey(value = "requestNo", required = true)
    private String requestNo;

    public SavingSubscribeRequest() {
        super("/newearn/cloud/v1/saving/subscribe", Method.POST, Auth.SIGNED);
    }
}
