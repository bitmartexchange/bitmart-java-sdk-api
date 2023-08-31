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
public final class SymbolsBookRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;          //Trading pair (e.g. BTC_USDT)


    @ParamKey("precision")
    private String precision;      //Price precision, the range is defined in trading pair details


    @ParamKey("size")
    private Integer size;          //Number of results per request. The value can be transmitted [1-200], there are altogether [2-400] buying and selling depths

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/symbols/book
     * Get full depth of trading pairs.
     */
    public SymbolsBookRequest() {
        super("/spot/v1/symbols/book", Method.GET, Auth.NONE);
    }
}
