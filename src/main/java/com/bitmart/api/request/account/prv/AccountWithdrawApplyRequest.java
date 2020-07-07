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
public class AccountWithdrawApplyRequest extends CloudRequest {
    @ParamKey("currency")
    private String currency;

    @ParamKey("amount")
    private String amount;

    @ParamKey("destination")
    private String destination;

    @ParamKey("address")
    private String address;

    @ParamKey("address_memo")
    private String address_memo;

    public AccountWithdrawApplyRequest() {
        super("/account/v1/withdraw/apply", Method.POST, Auth.SIGNED);
    }
}

