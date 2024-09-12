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
public class MarginSubmitOrderRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Side
     * -buy=Buy order
     * -sell=Sell order
     */
    @ParamKey(value = "side", required = true)
    private String side;

    /**
     * Order type
     * -limit=Limit order
     * -market=Market order
     * -limit_maker=PostOnly order
     * -ioc=IOC order
     */
    @ParamKey(value = "type", required = true)
    private String type;

    /**
     * Client-defined OrderId(A combination of numbers and letters, less than 32 bits)
     */
    @ParamKey("clientOrderId")
    private String clientOrderId;

    /**
     * Order size || Required for placing orders by quantity
     */
    @ParamKey("size")
    private String size;

    /**
     * Order price
     */
    @ParamKey("price")
    private String price;

    /**
     * Required for placing orders by amount
     */
    @ParamKey("notional")
    private String notional;

    /**
     * Applicable for margin order placement
     */
    public MarginSubmitOrderRequest() {
        super("/spot/v1/margin/submit_order", Method.POST, Auth.SIGNED);
    }
}
