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
 * Get Ticker of a Trading Pair (V3)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V3TickerRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Applicable to query the aggregated market price of a certain trading pair,
     *    and return the latest ticker information.
     *
     * Note that the interface is not real-time data,
     * if you need real-time data, please use websocket to subscribe Ticker channel
     */
    public V3TickerRequest() {
        super("/spot/quotation/v3/ticker", Method.GET, Auth.NONE);
    }

}
