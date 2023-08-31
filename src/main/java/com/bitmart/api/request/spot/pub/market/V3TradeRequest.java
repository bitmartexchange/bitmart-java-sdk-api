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
 * Get Recent Trades (V3)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V3TradeRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Number of returned items, maximum is 50, default 50
     */
    @ParamKey("limit")
    private Integer limit;


    /**
     * url: GET https://api-cloud.bitmart.com/spot/quotation/v3/trades
     *
     * Get the latest trade records of the specified trading pair.
     *
     * Note that the interface is not real-time data,
     * if you need real-time data, please use websocket to subscribe Trade channel
     *
     */
    public V3TradeRequest() {
        super("/spot/quotation/v3/trades", Method.GET, Auth.NONE);
    }

}
