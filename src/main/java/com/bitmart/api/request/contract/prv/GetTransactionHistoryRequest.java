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
public class GetTransactionHistoryRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol")
    private String symbol;

    /**
     * Type
     *  - 0 = All (default)
     *  - 1 = Transfer
     *  - 2 = Realized PNL
     *  - 3 = Funding Fee
     *  - 4 = Commission Fee
     *  - 5 = Liquidation Clearance
     */
    @ParamKey(value = "flow_type")
    private Integer flowType;


    /**
     * Start time(Timestamp in Milliseconds)
     */
    @ParamKey(value = "start_time")
    private Long startTime;

    /**
     * End time(Timestamp in Milliseconds)
     */
    @ParamKey(value = "end_time")
    private Long endTime;

    /**
     * Default 100; max 1000
     */
    @ParamKey(value = "page_size")
    private Integer pageSize;

    /**
     * Trading account
     * -futures
     * -copy_trading
     */
    @ParamKey("account")
    private String account;

    /**
     * Applicable for querying futures transaction history
     */
    public GetTransactionHistoryRequest() {
        super("/contract/private/transaction-history", Method.GET, Auth.KEYED);
    }
}
