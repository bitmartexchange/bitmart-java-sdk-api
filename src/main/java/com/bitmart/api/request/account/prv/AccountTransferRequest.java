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
 * Fund account transfer between the spot and fund accounts.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountTransferRequest extends CloudRequest {

    /**
     * Currency (e.g. USDT)
     */
    @ParamKey("currency")
    private String currency;

    /**
     * Transfer amount
     */
    @ParamKey("amount")
    private String amount;

    /**
     * Transfer direction
     * -spot_to_fund
     * -fund_to_spot
     */
    @ParamKey("type")
    private String type;

    public AccountTransferRequest() {
        super("/account/v1/transfer", Method.POST, Auth.SIGNED);
    }
}
