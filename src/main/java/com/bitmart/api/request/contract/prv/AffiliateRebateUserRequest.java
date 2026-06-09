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
 * Affiliate — query the contract rebate data of a single user within a time range
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AffiliateRebateUserRequest extends CloudRequest {

    /**
     * Query user CID
     */
    @ParamKey(value = "cid", required = true)
    private Long cid;

    /**
     * Start time(Timestamp in Seconds)
     */
    @ParamKey(value = "start_time", required = true)
    private Long startTime;

    /**
     * End time(Timestamp in Seconds)
     */
    @ParamKey(value = "end_time", required = true)
    private Long endTime;

    public AffiliateRebateUserRequest() {
        super("/contract/private/affiliate/rebate-user", Method.GET, Auth.KEYED);
    }
}
