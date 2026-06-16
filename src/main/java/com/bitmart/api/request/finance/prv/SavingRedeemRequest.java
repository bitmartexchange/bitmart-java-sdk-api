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
 * Finance — redeem a flexible savings product
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingRedeemRequest extends CloudRequest {

    /**
     * Savings order ID
     */
    @ParamKey(value = "earnId", required = true)
    private String earnId;

    /**
     * Redemption amount
     */
    @ParamKey(value = "amount", required = true)
    private String amount;

    /**
     * Unique request number, 20-digit numeric string, used for idempotency
     */
    @ParamKey(value = "requestNo", required = true)
    private String requestNo;

    public SavingRedeemRequest() {
        super("/newearn/cloud/v1/saving/redeem", Method.POST, Auth.SIGNED);
    }
}
