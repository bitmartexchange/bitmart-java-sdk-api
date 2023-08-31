package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Submit Plan Order (SIGNED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubmitPlanOrderRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order type
     * -limit(default)
     * -market
     */
    @ParamKey("type")
    private String type;

    /**
     * Order side
     * -1=buy_open_long
     * -2=buy_close_short
     * -3=sell_close_long
     * -4=sell_open_short
     */
    @ParamKey(value = "side", required = true)
    private Integer side;

    /**
     * Order leverage
     */
    @ParamKey(value = "leverage", required = true)
    private String leverage;

    /**
     * Open type, required at close position
     * -cross
     * -isolated
     */
    @ParamKey(value = "open_type", required = true)
    private String openType;

    /**
     * Order mode
     * -1=GTC(default)
     * -2=FOK
     * -3=IOC
     * -4=Maker Only
     */
    @ParamKey("mode")
    private Integer mode;

    /**
     * Order size (Number of contracts)
     */
    @ParamKey(value = "size", required = true)
    private Integer size;


    /**
     * Trigger price
     */
    @ParamKey(value = "trigger_price", required = true)
    private String triggerPrice;

    /**
     * Order price, required at limit order
     */
    @ParamKey("executive_price")
    private String executivePrice;

    /**
     * Price way
     * -1=price_way_long
     * -2=price_way_short
     */
    @ParamKey(value = "price_way", required = true)
    private Integer priceWay;

    /**
     * Trigger price type
     * -1=last_price
     * -2=fair_price
     */
    @ParamKey(value = "price_type", required = true)
    private Integer priceType;

    /**
     * url: POST https://api-cloud.bitmart.com/contract/private/submit-plan-order
     * Applicable for placing contract plan orders
     */
    public SubmitPlanOrderRequest() {
        super("/contract/private/submit-plan-order", Method.POST, Auth.SIGNED);
    }

}
