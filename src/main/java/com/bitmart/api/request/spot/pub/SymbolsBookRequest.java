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

    /**
     * 必填
     * 交易对 symbol
     */
    @ParamKey("symbol")
    private String symbol;


    /**
     * 可选
     * 价格精度， 精度范围在交易对详情里定义
     */
    @ParamKey("precision")
    private  String precision;

    public SymbolsBookRequest() {
        super("/spot/v1/symbols/book", Method.GET, Auth.NONE);
    }
}
