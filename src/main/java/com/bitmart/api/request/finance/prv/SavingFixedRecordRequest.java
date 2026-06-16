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
 * Finance — query fixed savings history records
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingFixedRecordRequest extends CloudRequest {

    /**
     * Record type
     * -subscribe
     * -redeem
     * -interest
     */
    @ParamKey(value = "type", required = true)
    private String type;

    /**
     * Start time in milliseconds, (e.g. 1681701557927)
     */
    @ParamKey("startTime")
    private Long startTime;

    /**
     * End time in milliseconds, (e.g. 1681701557927)
     */
    @ParamKey("endTime")
    private Long endTime;

    /**
     * Coin name
     */
    @ParamKey("coinName")
    private String coinName;

    /**
     * Current page number, default 1
     */
    @ParamKey(value = "currentPage", required = true)
    private Integer currentPage;

    /**
     * Page size, default 1, max 100
     */
    @ParamKey(value = "sizePage", required = true)
    private Integer sizePage;

    public SavingFixedRecordRequest() {
        super("/newearn/cloud/v1/saving/fixed/record", Method.GET, Auth.KEYED);
    }
}
