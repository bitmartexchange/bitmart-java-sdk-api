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
 * Submit Leverage (SIGNED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubmitLeverageRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

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
    @ParamKey(value = "open_type", required = true)
    private String openType;


    /**
     * <a href="https://developer-pro.bitmart.com/en/futures/#submit-leverage-signed">Doc</a>
     * Applicable for adjust contract leverage
     */
    public SubmitLeverageRequest() {
        super("/contract/private/submit-leverage", Method.POST, Auth.SIGNED);
    }

}
