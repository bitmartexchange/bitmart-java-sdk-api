package com.bitmart.api.request.finance.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Finance — query the savings (Earn) account holdings. No request parameters.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class EarnHoldingsRequest extends CloudRequest {

    public EarnHoldingsRequest() {
        super("/newearn/cloud/v1/earn", Method.GET, Auth.KEYED);
    }
}
