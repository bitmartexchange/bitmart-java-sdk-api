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
public final class SymbolsKlineRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;      //Trading pair (e.g. BTC_USDT)

    @ParamKey("from")
    private Long from;          //Start timestamp (in seconds, UTC+0 TimeZome)

    @ParamKey("to")
    private Long to;           //End timestamp (in seconds, UTC+0 TimeZome)

    @ParamKey("step")
    private Integer step;       //k-line step Steps (in minutes, default 1 minute)

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/symbols/kline
     * Get k-line data within a specified time range of a specified trading pair
     */
    public SymbolsKlineRequest() {
        super("/spot/v1/symbols/kline", Method.GET, Auth.NONE);
    }
}
