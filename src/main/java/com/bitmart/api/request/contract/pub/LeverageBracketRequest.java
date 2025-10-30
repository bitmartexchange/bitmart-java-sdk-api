package com.bitmart.api.request.contract.pub;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Get Current Leverage Risk Limit
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class LeverageBracketRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Applicable for getting current leverage risk limit
     */
    public LeverageBracketRequest() {
        super("/contract/public/leverage-bracket", Method.GET, Auth.NONE);
    }
}
