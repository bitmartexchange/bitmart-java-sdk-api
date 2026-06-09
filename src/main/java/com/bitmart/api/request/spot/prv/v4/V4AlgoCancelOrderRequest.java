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
 * Algo order (V4) — cancel an unfilled strategy order
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V4AlgoCancelOrderRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BMX_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order id
     */
    @ParamKey(value = "order_id", required = true)
    private String orderId;

    /**
     * Order type
     * -tp/sl = one-way take-profit/stop-loss
     * -trigger = plan order
     */
    @ParamKey(value = "type", required = true)
    private String type;

    public V4AlgoCancelOrderRequest() {
        super("/spot/v4/algo/cancel_order", Method.POST, Auth.SIGNED);
    }
}
