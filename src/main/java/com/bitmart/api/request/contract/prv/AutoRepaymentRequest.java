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
public class AutoRepaymentRequest extends CloudRequest {

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
     * Repayment coin code(like USDT)
     */
    @ParamKey("from_coin_code")
    private String fromCoinCode;

    /**
     * Repayment type(like AUTO_REPAY)
     */
    @ParamKey("type")
    private String type;

    /**
     * Applicable for querying the auto repayment records
     */
    public AutoRepaymentRequest() {
        super("/contract/private/auto_repayment", Method.GET, Auth.KEYED);
    }
}
