package com.bitmart.api.request.spot.prv.v4;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Algo order (V4) — cancel all unfilled strategy orders
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V4AlgoCancelAllRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Order type
     * -tp/sl = one-way take-profit/stop-loss
     * -trigger = plan order
     */
    @ParamKey(value = "type", required = true)
    private String type;

    public V4AlgoCancelAllRequest() {
        super("/spot/v4/algo/cancel_all", Method.POST, Auth.SIGNED);
    }
}
