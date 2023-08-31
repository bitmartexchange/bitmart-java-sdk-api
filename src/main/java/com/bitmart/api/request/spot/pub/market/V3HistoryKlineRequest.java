package com.bitmart.api.request.spot.pub.market;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Get History K-Line (V3)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V3HistoryKlineRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;


    /**
     * Query timestamp (unit: second), query the data before this time
     */
    @ParamKey("before")
    private Long before;

    /**
     * Query timestamp (unit: second), query the data after this time
     */
    @ParamKey("after")
    private Long after;

    /**
     * k-line step, value [1, 3, 5, 15, 30, 45, 60,
     * 120, 180, 240, 1440, 10080, 43200] unit: minute, default 1
     */
    @ParamKey("step")
    private Integer step;

    /**
     * Return number, the maximum value is 200, default is 100
     */
    @ParamKey("limit")
    private Integer limit;


    /**
     * url: GET https://api-cloud.bitmart.com/spot/quotation/v3/klines
     *
     * Get k-line data within a specified time range of a specified trading pair.
     *
     * Note that the interface is not real-time data,
     * if you need real-time data, please use websocket to subscribe KLine channel
     */
    public V3HistoryKlineRequest() {
        super("/spot/quotation/v3/klines", Method.GET, Auth.NONE);
    }

}
