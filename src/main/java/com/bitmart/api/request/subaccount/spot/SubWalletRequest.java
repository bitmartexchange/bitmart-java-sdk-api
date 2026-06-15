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
 * Sub-Account (spot) — query a sub-account's spot balance (for main account)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubWalletRequest extends CloudRequest {

    /**
     * Sub-account username
     */
    @ParamKey(value = "subAccount", required = true)
    private String subAccount;

    /**
     * Currency
     */
    @ParamKey("currency")
    private String currency;

    public SubWalletRequest() {
        super("/account/sub-account/main/v1/wallet", Method.GET, Auth.KEYED);
    }
}
