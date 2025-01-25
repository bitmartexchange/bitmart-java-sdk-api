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
 * Submit Trail Order (SIGNED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubmitTrailOrderRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

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
     * Order size (Number of contracts)
     */
    @ParamKey(value = "size", required = true)
    private Integer size;

    /**
     * Activation price, required at trailing order
     */
    @ParamKey("activation_price")
    private String activationPrice;

    /**
     * Callback rate, required at trailing order, min 0.1, max 5 where 1 for 1%
     */
    @ParamKey(value = "callback_rate", required = true)
    private String callbackRate;

    /**
     * Activation price type, required at trailing order
     * -1=last_price
     * -2=fair_price
     */
    @ParamKey(value = "activation_price_type", required = true)
    private Integer activationPriceType;

    /**
     * Applicable for placing contract trail orders
     */
    public SubmitTrailOrderRequest() {
        super("/contract/private/submit-trail-order", Method.POST, Auth.SIGNED);
    }

}
