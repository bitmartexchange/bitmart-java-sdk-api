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
     * url: POST https://api-cloud.bitmart.com/contract/private/submit-order
     * Applicable for placing contract order
     */
    public SubmitOrderRequest() {
        super("/contract/private/submit-order", Method.POST, Auth.SIGNED);
    }

}
