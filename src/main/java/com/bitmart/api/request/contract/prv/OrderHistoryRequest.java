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
public class OrderHistoryRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Start time, default is the last 7 days
     */
    @ParamKey("start_time")
    private Long startTime;


    /**
     * End time, default is the last 7 days
     */
    @ParamKey("end_time")
    private Long endTime;

    /**
     * url: GET https://api-cloud.bitmart.com/contract/private/order-history
     * Applicable for querying contract order history
     */
    public OrderHistoryRequest() {
        super("/contract/private/order-history", Method.GET, Auth.SIGNED);
    }
}
