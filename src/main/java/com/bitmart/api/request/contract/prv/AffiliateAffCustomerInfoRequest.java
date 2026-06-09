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
 * Affiliate — query the total contract assets and equity (in USDT) of an invited user by userId
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AffiliateAffCustomerInfoRequest extends CloudRequest {

    /**
     * The invited user ID to query
     */
    @ParamKey(value = "userId", required = true)
    private Long userId;

    public AffiliateAffCustomerInfoRequest() {
        super("/contract/private/affiliate/aff-customer-info", Method.GET, Auth.KEYED);
    }
}
