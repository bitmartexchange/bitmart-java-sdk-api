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
 * Creates a withdraw request from spot account to an external address
 * <br><br>
 * POST <a href="https://api-cloud.bitmart.com/account/v1/withdraw/apply">
 *     https://api-cloud.bitmart.com/account/v1/withdraw/apply</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#withdraw-signed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountWithdrawApplyRequest extends CloudRequest {

    /**
     * Token symbol, e.g., 'BTC'
     */
    @ParamKey(value = "currency", required = true)
    private String currency;

    /**
     * The amount of currency to withdraw
     */
    @ParamKey(value = "amount", required = true)
    private String amount;

    /**
     * withdrawal address
     * -`To Digital Address`=Withdraw to the digital currency address
     */
    @ParamKey(value = "destination", required = true)
    private String destination;

    /**
     * Address (only the address added on the official website is supported)
     */
    @ParamKey(value = "address", required = true)
    private String address;

    /**
     * Tag(tag Or payment_id Or memo)
     */
    @ParamKey("address_memo")
    private String address_memo;

    public AccountWithdrawApplyRequest() {
        super("/account/v1/withdraw/apply", Method.POST, Auth.SIGNED);
    }
}

