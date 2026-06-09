package com.bitmart.api.request.spot.prv.v4;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Algo order (V4) — query the history strategy orders
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V4QueryAlgoHistoryOrdersRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Order mode
     * -trigger = plan order
     * -tp/sl = take-profit/stop-loss
     */
    @ParamKey("orderMode")
    private String orderMode;

    /**
     * Start time in milliseconds, (e.g. 1681701557927)
     */
    @ParamKey("startTime")
    private Long startTime;

    /**
     * End time in milliseconds, (e.g. 1681701557927)
     */
    @ParamKey("endTime")
    private Long endTime;

    /**
     * Number of queries, range [1,200], default 200
     */
    @ParamKey("limit")
    private Integer limit;

    /**
     * Transaction aging time, range (0,60000], default: 5000 milliseconds
     */
    @ParamKey("recvWindow")
    private Long recvWindow;

    public V4QueryAlgoHistoryOrdersRequest() {
        super("/spot/v4/query/algo/history-orders", Method.POST, Auth.SIGNED);
    }
}
