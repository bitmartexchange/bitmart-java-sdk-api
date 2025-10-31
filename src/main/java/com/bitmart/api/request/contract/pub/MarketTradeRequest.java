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
 * Query the latest trade data
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class MarketTradeRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Number of items to return, default is 50, max is 1000
     */
    @ParamKey("limit")
    private Integer limit;

    /**
     * Applicable for querying the latest trade data
     */
    public MarketTradeRequest() {
        super("/contract/public/market-trade", Method.GET, Auth.NONE);
    }
}
