package com.bitmart.api.request.contract.prv;

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
public class SubmitTpSlOrderRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order type
     *  -take_profit
     *  -stop_loss
     */
    @ParamKey(value = "type", required = true)
    private String type;

    /**
     * Order side
     *  -2=buy_close_short
     *  -3=sell_close_long
     */
    @ParamKey(value = "side", required = true)
    private Integer side;

    /**
     * Order size (Number of contracts) Default the size of position
     */
    @ParamKey(value = "size")
    private Integer size;

    /**
     * Trigger price
     */
    @ParamKey(value = "trigger_price", required = true)
    private String triggerPrice;

    /**
     * Execution price
     */
    @ParamKey(value = "executive_price", required = true)
    private String executivePrice;

    /**
     * Trigger price type
     *  -1=last_price
     *  -2=fair_price
     */
    @ParamKey(value = "price_type", required = true)
    private Integer priceType;

    /**
     * TP/SL type
     * -1=TP/SL(default)
     * -2=Position TP/SL
     */
    @ParamKey(value = "plan_category")
    private Integer planCategory;

    /**
     * Client order ID
     */
    @ParamKey(value = "client_order_id")
    private String clientOrderId;


    /**
     * Trigger order type, position TP/SL default market
     *  -limit
     *  -market
     */
    @ParamKey(value = "category")
    private String category;

    public SubmitTpSlOrderRequest() {
        super("/contract/private/submit-tp-sl-order", Method.POST, Auth.SIGNED);
    }
}
