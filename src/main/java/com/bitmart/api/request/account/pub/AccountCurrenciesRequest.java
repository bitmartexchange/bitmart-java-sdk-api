package com.bitmart.api.request.account.pub;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Get Currencies
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountCurrenciesRequest extends CloudRequest {

    /**
     *  currency, e.g., 'BTC'
     */
    @ParamKey("currency")
    private String currency;

    public AccountCurrenciesRequest() {
        super("/account/v1/currencies", Method.GET, Auth.NONE);
    }
}

