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
public class GetPositionRiskRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Trading account
     * -futures
     * -copy_trading
     */
    @ParamKey("account")
    private String account;

    /**
     * Applicable for checking the position risk details a specified contract
     */
    public GetPositionRiskRequest() {
        super("/contract/private/position-risk", Method.GET, Auth.KEYED);
    }
}
