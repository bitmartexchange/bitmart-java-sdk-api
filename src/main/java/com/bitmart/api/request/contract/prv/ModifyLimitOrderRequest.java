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
 * Modify Limit Orders (SIGNED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class ModifyLimitOrderRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order ID
     */
    @ParamKey(value = "order_id", required = false)
    private Long orderId;

    /**
     * Client-defined OrderId(A combination of numbers and letters, less than 32 bits)
     */
    @ParamKey(value = "client_order_id", required = false)
    private String clientOrderId;

    /**
     * New order price
     */
    @ParamKey(value = "price", required = false)
    private String price;

    /**
     * New order size (Number of contracts)
     */
    @ParamKey(value = "size", required = false)
    private Integer size;

    /**
     * Applicable for modifying contract limit orders
     */
    public ModifyLimitOrderRequest() {
        super("/contract/private/modify-limit-order", Method.POST, Auth.SIGNED);
    }
}
