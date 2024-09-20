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
public class ModifyTpSlOrderRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order ID(order_id or client_order_id must give one)
     */
    @ParamKey(value = "order_id")
    private String orderId;

    /**
     * Client order ID(order_id or client_order_id must give one)
     */
    @ParamKey(value = "client_order_id")
    private String clientOrderId;

    /**
     * Trigger price
     */
    @ParamKey(value = "trigger_price", required = true)
    private String triggerPrice;

    /**
     * Execution price for order, mandatory when plan_category = 1
     */
    @ParamKey(value = "executive_price")
    private String executivePrice;

    /**
     * Trigger price type
     * -1=last_price
     * -2=fair_price
     */
    @ParamKey(value = "price_type", required = true)
    private Integer priceType;

    /**
     * TP/SL type
     * -1=TP/SL
     * -2=Position TP/SL
     */
    @ParamKey(value = "plan_category")
    private Integer planCategory;


    /**
     * Order type, Position TP/SL default market
     * -limit
     * -market
     */
    @ParamKey(value = "category")
    private String category;



    public ModifyTpSlOrderRequest() {
        super("/contract/private/modify-tp-sl-order", Method.POST, Auth.SIGNED);
    }
}
