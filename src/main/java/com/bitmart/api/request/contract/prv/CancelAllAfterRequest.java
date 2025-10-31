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
 * Timed Cancel All Orders (SIGNED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class CancelAllAfterRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;


    /**
     * The duration of canceling orders(second,minimum value: 5 seconds) 0:Canceling the setting
     */
    @ParamKey(value = "timeout", required = true)
    private Integer timeout;

    /**
     * Applicable for timed cancel all orders
     */
    public CancelAllAfterRequest() {
        super("/contract/private/cancel-all-after", Method.POST, Auth.SIGNED);
    }
}
