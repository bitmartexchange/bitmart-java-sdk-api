package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Contract — fund account transfer between the fund and contract accounts.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class ContractAccountTransferRequest extends CloudRequest {

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
     * -fund_to_contract
     * -contract_to_fund
     */
    @ParamKey("type")
    private String type;

    public ContractAccountTransferRequest() {
        super("/contract/private/account/v1/transfer", Method.POST, Auth.SIGNED);
    }
}
