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

    /**
     * 必填
     * 交易对 symbol
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * 必填
     * 开始时间 (毫秒表示)
     */
    @ParamKey("from")
    private Long from;

    /**
     * 必填
     * 结束时间 (毫秒表示)
     */
    @ParamKey("to")
    private  Long to;

    /**
     * 可选(默认 1 分钟)
     * k 线步长Steps (用分钟表示, 默认 1 分钟)
     */
    @ParamKey("step")
    private  Long step;

    public SymbolsKlineRequest() {
        super("/spot/v1/symbols/kline", Method.GET, Auth.NONE);
    }
}
