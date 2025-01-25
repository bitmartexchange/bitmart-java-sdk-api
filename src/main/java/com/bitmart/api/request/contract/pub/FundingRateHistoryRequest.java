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
public class FundingRateHistoryRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Number of results per request. The maximum is 100; The default is 100
     */
    @ParamKey(value = "limit")
    private Integer limit;

    /**
     * Applicable for querying the open interest and open interest value data of the specified contract
     */
    public FundingRateHistoryRequest() {
        super("/contract/public/funding-rate-history", Method.GET, Auth.NONE);
    }
}
