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
 * Sub-Account (spot) — main account spot wallet transfer to sub-account (for main account)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class MainToSubRequest extends CloudRequest {

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
     * Sub-account username
     */
    @ParamKey(value = "subAccount", required = true)
    private String subAccount;

    public MainToSubRequest() {
        super("/account/sub-account/main/v1/main-to-sub", Method.POST, Auth.SIGNED);
    }
}
