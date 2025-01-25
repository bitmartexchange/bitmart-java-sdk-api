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
 * Submit Order (SIGNED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubmitOrderRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Client-defined OrderId(A combination of numbers and letters, less than 32 bits)
     */
    @ParamKey("client_order_id")
    private String clientOrderId;

    /**
     * Order type
     * -limit(default)
     * -market
     * -trailing
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
    @ParamKey("side")
    private Integer side;

    /**
     * Order leverage
     */
    @ParamKey("leverage")
    private String leverage;

    /**
     * Open type, required at close position
     * -cross
     * -isolated
     */
    @ParamKey("open_type")
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
     * Order price, required at limit order
     */
    @ParamKey(value = "price", required = true)
    private String price;

    /**
     * Order size (Number of contracts)
     */
    @ParamKey(value = "size", required = true)
    private Integer size;

    /**
     * Pre-set TP price type
     * -1=last_price(default)
     * -2=fair_price
     */
    @ParamKey("preset_take_profit_price_type")
    private Integer presetTakeProfitPriceType;

    /**
     * Pre-set SL price type
     * -1=last_price(default)
     * -2=fair_price
     */
    @ParamKey("preset_stop_loss_price_type")
    private Integer presetStopLossPriceType;

    /**
     * Pre-set TP price
     */
    @ParamKey("preset_take_profit_price")
    private String presetTakeProfitPrice;

    /**
     * Pre-set SL price
     */
    @ParamKey("preset_stop_loss_price")
    private String presetStopLossPrice;

    /**
     * Applicable for placing contract order
     */
    public SubmitOrderRequest() {
        super("/contract/private/submit-order", Method.POST, Auth.SIGNED);
    }

}
