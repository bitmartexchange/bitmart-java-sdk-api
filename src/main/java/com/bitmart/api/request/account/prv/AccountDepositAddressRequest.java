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
 * Gets Deposit Address
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/account/v1/deposit/address">
 *     https://api-cloud.bitmart.com/account/v1/deposit/address</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#deposit-address-keyed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountDepositAddressRequest extends CloudRequest {

    /**
     * Token symbol, e.g., 'BTC'
     */
    @ParamKey(value = "currency", required = true)
    private String currency;

    public AccountDepositAddressRequest() {
        super("/account/v1/deposit/address", Method.GET, Auth.KEYED);
    }
}

