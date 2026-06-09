package com.bitmart.api.request.contract.pub;

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
public class FundingRateV2Request extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Applicable for checking the current funding rate (V2) of all contract trading pairs
     */
    public FundingRateV2Request() {
        super("/contract/public/funding-rate-v2", Method.GET, Auth.NONE);
    }
}
