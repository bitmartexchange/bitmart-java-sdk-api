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
public class AccountDepositWithdrawHistoryV2Request extends CloudRequest {

    @ParamKey("currency")
    private String currency;

    @ParamKey("operation_type")
    private String operationType;


    @ParamKey("N")
    private int N;

    public AccountDepositWithdrawHistoryV2Request() {
        super("/account/v2/deposit-withdraw/history", Method.GET, Auth.KEYED);
    }

}
