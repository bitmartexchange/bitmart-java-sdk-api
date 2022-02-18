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
public final class SymbolsTradesRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;  //Trading pair (e.g. BTC_USDT)

    @ParamKey("N")
    private String N;       //Recent N records (value range 1-100)

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/symbols/trades
     * Get the latest trade records of the specified trading pair
     */
    public SymbolsTradesRequest() {
        super("/spot/v1/symbols/trades", Method.GET, Auth.NONE);
    }
}
