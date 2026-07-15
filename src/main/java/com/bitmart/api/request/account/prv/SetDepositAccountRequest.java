package com.bitmart.api.request.account.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Set the deposit-crediting account type. (Not supported for sub-accounts.)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SetDepositAccountRequest extends CloudRequest {

    /**
     * Deposit account type
     * -SPOT
     * -CONTRACT
     * -FUND
     */
    @ParamKey("account_type")
    private String accountType;

    public SetDepositAccountRequest() {
        super("/account/v1/set-deposit-account", Method.POST, Auth.SIGNED);
    }
}
