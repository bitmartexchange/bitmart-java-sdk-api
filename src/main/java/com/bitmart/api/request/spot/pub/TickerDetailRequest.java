package com.bitmart.api.request.spot.pub;

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
@Deprecated
public class TickerDetailRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;  //Trading pair (e.g. BTC_USDT)

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/ticker_detail
     * Applicable for querying aggregated tickers of a particular trading pair
     */
    public TickerDetailRequest() {
        super("/spot/v1/ticker_detail", Method.GET, Auth.NONE);
    }
}
