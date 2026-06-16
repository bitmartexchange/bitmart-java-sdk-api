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
 * Finance — early-redeem a fixed savings product
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingFixedRedeemRequest extends CloudRequest {

    /**
     * Savings order ID
     */
    @ParamKey(value = "earnId", required = true)
    private String earnId;

    /**
     * Unique request number, length 20, numeric (0-9), used for idempotency
     */
    @ParamKey(value = "requestNo", required = true)
    private String requestNo;

    public SavingFixedRedeemRequest() {
        super("/newearn/cloud/v1/saving/fixed/redeem", Method.POST, Auth.SIGNED);
    }
}
