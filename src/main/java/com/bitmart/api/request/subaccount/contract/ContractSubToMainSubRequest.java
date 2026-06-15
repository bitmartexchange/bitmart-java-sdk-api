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
 * Sub-Account (contract) — sub-account contract wallet transfer to main account (for sub-account)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class ContractSubToMainSubRequest extends CloudRequest {

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
     * Currency (currently only USDT is supported)
     */
    @ParamKey(value = "currency", required = true)
    private String currency;

    public ContractSubToMainSubRequest() {
        super("/account/contract/sub-account/sub/v1/sub-to-main", Method.POST, Auth.SIGNED);
    }
}
