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
 * Contract — close all positions with one click
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class CloseAllPositionRequest extends CloudRequest {

    /**
     * Symbol of the contract. If set, only close positions of this symbol;
     * if omitted, close positions of all symbols.
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Contract type (required)
     * -1 = USDT-FUTURES
     * -2 = COIN-FUTURES
     */
    @ParamKey(value = "contractType", required = true)
    private Integer contractType;

    /**
     * Position side. If omitted, close positions of all sides.
     * -long
     * -short
     */
    @ParamKey("position_side")
    private String positionSide;

    public CloseAllPositionRequest() {
        super("/contract/private/close-all-position", Method.POST, Auth.SIGNED);
    }
}
