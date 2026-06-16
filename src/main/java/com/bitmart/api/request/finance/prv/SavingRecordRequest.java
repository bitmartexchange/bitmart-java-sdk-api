package com.bitmart.api.request.finance.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Finance — query flexible savings history records
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingRecordRequest extends CloudRequest {

    /**
     * Record type
     * -subscribe
     * -redeem
     * -interest
     */
    @ParamKey(value = "type", required = true)
    private String type;

    /**
     * Start time in milliseconds, (e.g. 1714329600000)
     */
    @ParamKey("startTime")
    private Long startTime;

    /**
     * End time in milliseconds, (e.g. 1714416000000)
     */
    @ParamKey("endTime")
    private Long endTime;

    /**
     * Filter by coin name (e.g. USDT)
     */
    @ParamKey("coinName")
    private String coinName;

    /**
     * Current page number
     */
    @ParamKey(value = "currentPage", required = true)
    private Integer currentPage;

    /**
     * Records per page, max 100
     */
    @ParamKey(value = "sizePage", required = true)
    private Integer sizePage;

    public SavingRecordRequest() {
        super("/newearn/cloud/v1/saving/record", Method.GET, Auth.KEYED);
    }
}
