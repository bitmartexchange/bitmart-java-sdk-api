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
 * Get Depth (V3)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V3DepthRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order book depth per side. Maximum 50, e.g. 50 bids + 50 asks.
     * Default returns to 35 depth data, e.g. 35 bids + 35 asks.
     */
    @ParamKey("limit")
    private Integer limit;


    /**
     * url: GET https://api-cloud.bitmart.com/spot/quotation/v3/books
     *
     * Get full depth of trading pairs.
     *
     * Note that the interface is not real-time data,
     * if you need real-time data, please use websocket to subscribe Depth channel
     */
    public V3DepthRequest() {
        super("/spot/quotation/v3/books", Method.GET, Auth.NONE);
    }

}
