package com.bitmart.api.request.account.pub;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Get Currencies
 * <p>
 * GET <a href="https://api-cloud.bitmart.com/account/v1/currencies">
 *     https://api-cloud.bitmart.com/account/v1/currencies</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#get-currencies">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountCurrenciesRequest extends CloudRequest {

    public AccountCurrenciesRequest() {
        super("/account/v1/currencies", Method.GET, Auth.NONE);
    }
}

