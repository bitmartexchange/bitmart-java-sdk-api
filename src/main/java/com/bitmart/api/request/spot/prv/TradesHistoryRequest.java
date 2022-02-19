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
    private String symbol;      //Trading pair (e.g. BTC_USDT)

    @ParamKey("offset")
    private Integer offset;     //Current page, starts from 1

    @ParamKey("limit")
    private Integer limit;      //Records returned per page (value range 1-100)

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/trades
     * Get user trade history
     */
    public TradesHistoryRequest() {
        super("/spot/v1/trades", Method.GET, Auth.KEYED);
    }
}
