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
 * Get Current Position V2 (KEYED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class GetPositionV2Request extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Trading account
     * -futures(default)
     * -copy_trading
     */
    @ParamKey("account")
    private String account;

    /**
     * Applicable for getting current position V2
     */
    public GetPositionV2Request() {
        super("/contract/private/position-v2", Method.GET, Auth.KEYED);
    }
}
