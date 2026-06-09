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
 * Affiliate — query the rebate information of invited users within a time range
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AffiliateRebateInviteUserRequest extends CloudRequest {

    /**
     * Query user CID
     */
    @ParamKey("cid")
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

    /**
     * Current page
     */
    @ParamKey(value = "page", required = true)
    private Integer page;

    /**
     * Page size
     */
    @ParamKey(value = "size", required = true)
    private Integer size;

    public AffiliateRebateInviteUserRequest() {
        super("/contract/private/affiliate/rebate-inviteUser", Method.GET, Auth.KEYED);
    }
}
