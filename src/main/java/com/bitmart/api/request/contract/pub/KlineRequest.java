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
public class KlineRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * K-Line step, default is 1 minute. step: 1, 3, 5, 15, 30, 60, 120, 240, 360, 720, 1440, 4320, 10080
     */
    @ParamKey("step")
    private Integer step;

    /**
     * Start time. Timestamps need to be in seconds
     */
    @ParamKey(value = "start_time", required = true)
    private Long startTime;

    /**
     * End time. Timestamps need to be in seconds
     */
    @ParamKey(value = "end_time", required = true)
    private Long endTime;

    /**
     * url: GET https://api-cloud.bitmart.com/contract/public/kline
     * Applicable for querying K-line data
     */
    public KlineRequest() {
        super("/contract/public/kline", Method.GET, Auth.NONE);
    }
}
