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
public class CancelAllOrderRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Order side
     * -buy
     * -sell
     */
    @ParamKey("side")
    private String side;


    /**
     * Cancel all orders
     */
    public CancelAllOrderRequest() {
        super("/spot/v4/cancel_all", Method.POST, Auth.SIGNED);
    }
}
