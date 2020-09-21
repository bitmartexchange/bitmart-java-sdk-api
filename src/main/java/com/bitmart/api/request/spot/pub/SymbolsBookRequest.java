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
public final class SymbolsBookRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;


    @ParamKey("precision")
    private  String precision;


    @ParamKey("size")
    private  Integer size;

    public SymbolsBookRequest() {
        super("/spot/v1/symbols/book", Method.GET, Auth.NONE);
    }
}
