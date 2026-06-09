package com.bitmart.api.request.contract.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Claim demo assets — recharge available funds to the contract account
 * (only supported on the demo trading environment). No request parameters.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class ClaimRequest extends CloudRequest {

    public ClaimRequest() {
        super("/contract/private/claim", Method.POST, Auth.SIGNED);
    }
}
