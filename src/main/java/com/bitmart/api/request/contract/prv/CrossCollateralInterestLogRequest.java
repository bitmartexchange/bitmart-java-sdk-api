package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class CrossCollateralInterestLogRequest extends CloudRequest {

    /**
     * Start time(Timestamp in Seconds)
     */
    @ParamKey("start_time")
    private Long startTime;

    /**
     * End time(Timestamp in Seconds)
     */
    @ParamKey("end_time")
    private Long endTime;

    /**
     * Current page
     */
    @ParamKey("page")
    private Integer page;

    /**
     * Query size
     */
    @ParamKey("size")
    private Integer size;

    /**
     * Coin code(like USDT)
     */
    @ParamKey("coin_code")
    private String coinCode;

    /**
     * Applicable for querying the cross-collateral interest accrual logs
     */
    public CrossCollateralInterestLogRequest() {
        super("/contract/private/cross_collateral/interest_log", Method.GET, Auth.KEYED);
    }
}
