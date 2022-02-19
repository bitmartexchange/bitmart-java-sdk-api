package com.bitmart.api.request.account.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountWithdrawChargeRequest extends CloudRequest {

    @ParamKey("currency")
    private String currency;    //Token symbol, e.g., 'BTC'

    /**
     * url: GET https://api-cloud.bitmart.com/account/v1/withdraw/charge
     * Query withdraw quota for currencies
     */
    public AccountWithdrawChargeRequest() {
        super("/account/v1/withdraw/charge", Method.GET, Auth.KEYED);
    }
}

