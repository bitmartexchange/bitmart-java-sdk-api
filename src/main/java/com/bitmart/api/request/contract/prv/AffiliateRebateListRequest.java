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
 * Affiliate — query the contract rebate records within a time range
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AffiliateRebateListRequest extends CloudRequest {

    /**
     * Query user ID
     */
    @ParamKey("user_id")
    private Long userId;

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

    /**
     * Query currency
     */
    @ParamKey(value = "currency", required = true)
    private String currency;

    /**
     * Rebate start time(Timestamp in Seconds)
     */
    @ParamKey("rebate_start_time")
    private Long rebateStartTime;

    /**
     * Rebate end time(Timestamp in Seconds)
     */
    @ParamKey("rebate_end_time")
    private Long rebateEndTime;

    /**
     * Register start time(Timestamp in Seconds)
     */
    @ParamKey("register_start_time")
    private Long registerStartTime;

    /**
     * Register end time(Timestamp in Seconds)
     */
    @ParamKey("register_end_time")
    private Long registerEndTime;

    public AffiliateRebateListRequest() {
        super("/contract/private/affiliate/rebate-list", Method.GET, Auth.KEYED);
    }
}
