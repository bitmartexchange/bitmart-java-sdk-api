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
 * Gets Account Balance
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/account/v1/wallet">
 *     https://api-cloud.bitmart.com/account/v1/wallet</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#get-account-balance-keyed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountWalletRequest extends CloudRequest {

    /**
     *  currency, e.g., 'BTC'
     */
    @ParamKey("currency")
    private String currency;

    /**
     *  Whether to return the USD valuation, default is false
     */
    @ParamKey("needUsdValuation")
    private Boolean needUsdValuation;

    public AccountWalletRequest() {
        super("/account/v1/wallet", Method.GET, Auth.KEYED);
    }
}

