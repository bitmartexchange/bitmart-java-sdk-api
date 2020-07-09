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
public class AccountWalletRequest extends CloudRequest {
    @ParamKey("account_type")
    private String accountType;

    public AccountWalletRequest() {
        super("/account/v1/wallet", Method.GET, Auth.KEYED);
    }
}

