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
public class ModifyPlanOrderRequest extends CloudRequest {

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
     * Trigger price
     */
    @ParamKey(value = "trigger_price", required = true)
    private String triggerPrice;

    /**
     * Execution price for plan order, mandatory when type = limit
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
     * Order type
     *  -limit
     *  -market
     */
    @ParamKey(value = "type", required = true)
    private String type;

    public ModifyPlanOrderRequest() {
        super("/contract/private/modify-plan-order", Method.POST, Auth.SIGNED);
    }
}
