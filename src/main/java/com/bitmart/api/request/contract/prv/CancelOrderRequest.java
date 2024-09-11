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
public class CancelOrderRequest extends CloudRequest {

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
     * Applicable for canceling a specific contract order
     */
    public CancelOrderRequest() {
        super("/contract/private/cancel-order", Method.POST, Auth.SIGNED);
    }
}
