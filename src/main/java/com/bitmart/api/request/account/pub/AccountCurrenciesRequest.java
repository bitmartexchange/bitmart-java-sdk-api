package com.bitmart.api.request.account.pub;

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
public class AccountCurrenciesRequest extends CloudRequest {

    /**
     * url: GET https://api-cloud.bitmart.com/account/v1/currencies
     * Gets the currency of the asset for withdrawal
     */
    public AccountCurrenciesRequest() {
        super("/account/v1/currencies", Method.GET, Auth.NONE);
    }
}

