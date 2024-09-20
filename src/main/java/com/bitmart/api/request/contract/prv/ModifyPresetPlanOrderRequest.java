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
public class ModifyPresetPlanOrderRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order ID
     */
    @ParamKey(value = "order_id", required = true)
    private String orderId;

    /**
     * Pre-set TP price type
     * -1=last_price(default)
     * -2=fair_price
     */
    @ParamKey(value = "preset_take_profit_price_type")
    private Integer presetTakeProfitPriceType;

    /**
     * Pre-set SL price type
     * -1=last_price(default)
     * -2=fair_price
     */
    @ParamKey(value = "preset_stop_loss_price_type")
    private Integer presetStopLossPriceType;

    /**
     * Pre-set TP price
     */
    @ParamKey(value = "preset_take_profit_price")
    private String presetTakeProfitPrice;

    /**
     * Pre-set SL price
     */
    @ParamKey(value = "preset_stop_loss_price")
    private String presetStopLossPrice;

    public ModifyPresetPlanOrderRequest() {
        super("/contract/private/modify-preset-plan-order", Method.POST, Auth.SIGNED);
    }
}
