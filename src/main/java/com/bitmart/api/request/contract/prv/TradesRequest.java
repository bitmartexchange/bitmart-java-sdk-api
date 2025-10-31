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
public class TradesRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Start time(Timestamp in Seconds)
     */
    @ParamKey("start_time")
    private Long startTime;


    /**
     * End time(Timestamp in Seconds)
     */
    @ParamKey("end_time")
    private Long endTime;

    /**
     * Trading account
     * -futures
     * -copy_trading
     */
    @ParamKey("account")
    private String account;

    /**
     * Applicable for querying contract order trade detail
     */
    public TradesRequest() {
        super("/contract/private/trades", Method.GET, Auth.KEYED);
    }
}
