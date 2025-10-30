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
 * Set Position Mode (SIGNED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SetPositionModeRequest extends CloudRequest {

    /**
     * Position mode
     *  - hedge_mode
     *  - one_way_mode
     */
    @ParamKey(value = "position_mode", required = true)
    private String positionMode;

    /**
     * Applicable for setting position mode
     */
    public SetPositionModeRequest() {
        super("/contract/private/set-position-mode", Method.POST, Auth.SIGNED);
    }
}
