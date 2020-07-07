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
public class AccountDepositWithdrawHistoryRequest extends CloudRequest {
    @ParamKey("currency")
    private String currency;

    @ParamKey("operationType")
    private String operationType;


    @ParamKey("offset")
    private int offset;

    @ParamKey("limit")
    private int limit;


    public AccountDepositWithdrawHistoryRequest() {
        super("/account/v1/deposit-withdraw/history", Method.GET, Auth.KEYED);
    }
}

