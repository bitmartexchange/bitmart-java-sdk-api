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
    private String symbol;

    @ParamKey("from")
    private Long from;

    @ParamKey("to")
    private  Long to;

    @ParamKey("step")
    private  Long step;

    public SymbolsKlineRequest() {
        super("/spot/v1/symbols/kline", Method.GET, Auth.NONE);
    }
}
