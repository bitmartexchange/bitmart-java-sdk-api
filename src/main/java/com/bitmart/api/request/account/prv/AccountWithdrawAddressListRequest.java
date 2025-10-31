package com.bitmart.api.request.account.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Query Withdraw Address List (KEYED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountWithdrawAddressListRequest extends CloudRequest {


    /**
     * Query withdraw address list
     */
    public AccountWithdrawAddressListRequest() {
        super("/account/v1/withdraw/address/list", Method.GET, Auth.KEYED);
    }
}
