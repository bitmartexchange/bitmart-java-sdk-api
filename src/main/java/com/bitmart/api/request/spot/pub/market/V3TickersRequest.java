package com.bitmart.api.request.spot.pub.market;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Get Ticker of All Pairs (V3)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V3TickersRequest extends CloudRequest {

    /**
     * url: GET https://api-cloud.bitmart.com/spot/quotation/v3/tickers
     *
     * Get the quotations of all trading pairs,
     *  including: snapshot information of the latest transaction price,
     *  first bid price, first ask price and 24-hour trading volume.
     *
     * Note that the interface is not real-time data,
     * if you need real-time data, please use websocket to subscribe Ticker channel
     */
    public V3TickersRequest() {
        super("/spot/quotation/v3/tickers", Method.GET, Auth.NONE);
    }

}
