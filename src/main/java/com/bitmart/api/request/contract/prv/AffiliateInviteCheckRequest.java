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
 * Affiliate — check whether a user is invited by the affiliate
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AffiliateInviteCheckRequest extends CloudRequest {

    /**
     * Query user CID
     */
    @ParamKey(value = "cid", required = true)
    private Long cid;

    public AffiliateInviteCheckRequest() {
        super("/contract/private/affiliate/invite-check", Method.GET, Auth.KEYED);
    }
}
