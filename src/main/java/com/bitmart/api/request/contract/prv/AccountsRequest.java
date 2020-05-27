package com.bitmart.api.request.contract.prv;

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
public class AccountsRequest extends CloudRequest {
    @ParamKey("coinCode")
    private String coinCode;

    public AccountsRequest() {
        super("/contract/v1/ifcontract/accounts", Method.GET, Auth.KEYED);
    }
}
