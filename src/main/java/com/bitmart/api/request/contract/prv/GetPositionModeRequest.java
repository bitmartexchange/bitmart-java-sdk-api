package com.bitmart.api.request.contract.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Get Position Mode (KEYED)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class GetPositionModeRequest extends CloudRequest {

    /**
     * Applicable for getting position mode
     */
    public GetPositionModeRequest() {
        super("/contract/private/get-position-mode", Method.GET, Auth.KEYED);
    }
}
