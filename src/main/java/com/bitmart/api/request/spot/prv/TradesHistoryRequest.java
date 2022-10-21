package com.bitmart.api.request.spot.prv;

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
public class TradesHistoryRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;          //Trading pair (e.g. BTC_USDT)

    @ParamKey("order_mode")
    private String order_mode;      //Order mode, Default returns spot

    @ParamKey("N")
    private Integer N;              //Recent N records (value range 1-200)

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v2/trades
     * Get user trade history
     */
    public TradesHistoryRequest() {
        super("/spot/v2/trades", Method.GET, Auth.KEYED);
    }
}
