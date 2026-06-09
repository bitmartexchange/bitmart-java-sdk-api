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
 * Algo order (V4) — place a strategy order, supporting trigger (plan) orders and tp/sl orders
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V4AlgoSubmitOrderRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order side
     * -buy
     * -sell
     */
    @ParamKey(value = "side", required = true)
    private String side;

    /**
     * Order type
     * -tp/sl = one-way take-profit/stop-loss
     * -trigger = plan order
     */
    @ParamKey(value = "type", required = true)
    private String type;

    /**
     * Client-defined OrderId(A combination of letters and numbers, 1-32 characters)
     */
    @ParamKey("client_order_id")
    private String clientOrderId;

    /**
     * Trigger price. When set, the take-profit order price must also be set.
     * (conditionally required)
     */
    @ParamKey("trigger_price")
    private String triggerPrice;

    /**
     * Trigger order type (conditionally required)
     * -Limit
     * -Market
     */
    @ParamKey("trigger_type")
    private String triggerType;

    /**
     * Order price. When set, the take-profit trigger price must also be set.
     * For a market order it will be executed at the market price. (conditionally required)
     */
    @ParamKey("price")
    private String price;

    /**
     * Special parameter for market buy orders (type=market, side=buy). (conditionally required)
     */
    @ParamKey("notional")
    private String notional;

    /**
     * Special parameter for market sell orders and limit orders.
     */
    @ParamKey("size")
    private String size;

    public V4AlgoSubmitOrderRequest() {
        super("/spot/v4/algo/submit_order", Method.POST, Auth.SIGNED);
    }
}
