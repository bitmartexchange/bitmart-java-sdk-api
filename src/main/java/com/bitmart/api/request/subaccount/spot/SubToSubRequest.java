package com.bitmart.api.request.subaccount.spot;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Sub-Account (spot) — sub-account spot wallet transfer to another sub-account (for main account)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubToSubRequest extends CloudRequest {

    /**
     * uuid or other universally unique identifier, up to length 64
     */
    @ParamKey(value = "requestNo", required = true)
    private String requestNo;

    /**
     * Transfer amount
     */
    @ParamKey(value = "amount", required = true)
    private String amount;

    /**
     * Currency
     */
    @ParamKey(value = "currency", required = true)
    private String currency;

    /**
     * The sub-account username to transfer out from
     */
    @ParamKey(value = "fromAccount", required = true)
    private String fromAccount;

    /**
     * The sub-account username to transfer in to
     */
    @ParamKey(value = "toAccount", required = true)
    private String toAccount;

    public SubToSubRequest() {
        super("/account/sub-account/main/v1/sub-to-sub", Method.POST, Auth.SIGNED);
    }
}
