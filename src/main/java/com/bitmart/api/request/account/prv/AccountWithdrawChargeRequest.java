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
 * Query withdraw quota for currencies
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/account/v1/withdraw/charge">
 *     https://api-cloud.bitmart.com/account/v1/withdraw/charge</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#withdraw-quota-keyed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountWithdrawChargeRequest extends CloudRequest {

    /**
     * Token symbol, e.g., 'BTC'
     */
    @ParamKey("currency")
    private String currency;

    public AccountWithdrawChargeRequest() {
        super("/account/v1/withdraw/charge", Method.GET, Auth.KEYED);
    }
}

