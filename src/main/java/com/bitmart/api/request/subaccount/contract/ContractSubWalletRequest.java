package com.bitmart.api.request.subaccount.contract;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Sub-Account (contract) — query a sub-account's contract balance (for main account)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class ContractSubWalletRequest extends CloudRequest {

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

    public ContractSubWalletRequest() {
        super("/account/contract/sub-account/main/v1/wallet", Method.GET, Auth.KEYED);
    }
}
