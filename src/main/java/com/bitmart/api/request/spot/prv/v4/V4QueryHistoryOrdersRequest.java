package com.bitmart.api.request.spot.prv.v4;

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
public class V4QueryHistoryOrdersRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Order Mode , (e.g. `spot` or `iso_margin`)
     */
    @ParamKey("orderMode")
    private String orderMode;


    /**
     * The request time initiated by the user Time in milliseconds
     */
    @ParamKey("startTime")
    private Long startTime;


    /**
     * The request time initiated by the user Time in milliseconds
     */
    @ParamKey("endTime")
    private Long endTime;


    /**
     * Number of queries, no more than 100, if not set, 100 by default
     */
    @ParamKey("limit")
    private Integer limit;

    /**
     * Transaction aging time (unit milliseconds), default: 5000
     */
    @ParamKey("recvWindow")
    private Long recvWindow;

    /**
     * Query the historical order list (cancellation + cancellation after partial transaction + complete transaction)
     */
    public V4QueryHistoryOrdersRequest() {
        super("/spot/v4/query/history-orders", Method.POST, Auth.SIGNED);
    }

}
