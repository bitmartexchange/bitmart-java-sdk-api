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
 * Affiliate — query the deposit and withdrawal records of a specified invited user within a time range
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AffiliateDepositWithdrawalListRequest extends CloudRequest {

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
     * Optional, 1 deposit, 2 withdraw
     */
    @ParamKey("type")
    private Integer type;

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

    public AffiliateDepositWithdrawalListRequest() {
        super("/contract/private/affiliate/deposit-withdrawal-list", Method.GET, Auth.KEYED);
    }
}
