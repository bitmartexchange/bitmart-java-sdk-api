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
public final class TickersRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;  //Trading pair (e.g. BTC_USDT)

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/ticker
     * Ticker is an overview of the market status of a trading pair,
     * including the latest trade price, top bid and ask prices and 24-hour trading volume
     */
    public TickersRequest() {
        super("/spot/v1/ticker", Method.GET, Auth.NONE);
    }
}
