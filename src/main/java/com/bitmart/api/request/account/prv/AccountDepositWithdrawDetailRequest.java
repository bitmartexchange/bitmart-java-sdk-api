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
 * Query a single charge record
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/account/v1/deposit-withdraw/detail">
 *     https://api-cloud.bitmart.com/account/v1/deposit-withdraw/detail</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#get-a-deposit-or-withdraw-detail-keyed">BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountDepositWithdrawDetailRequest extends CloudRequest {

    /**
     * withdraw_id or deposit_id
     */
    @ParamKey("id")
    private Long id;


    public AccountDepositWithdrawDetailRequest() {
        super("/account/v1/deposit-withdraw/detail", Method.GET, Auth.KEYED);
    }
}

