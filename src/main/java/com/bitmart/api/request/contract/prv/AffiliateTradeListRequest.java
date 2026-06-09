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
 * Affiliate — query the contract trade records of invited users within a time range
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AffiliateTradeListRequest extends CloudRequest {

    /**
     * Query user ID
     */
    @ParamKey(value = "user_id", required = true)
    private Long userId;

    /**
     * Query type
     * -1 = USDT-margined (U本位)
     * -2 = Coin-margined (币本位)
     */
    @ParamKey(value = "type", required = true)
    private Integer type;

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
     * Start time(Timestamp in Seconds)
     */
    @ParamKey("start_time")
    private Long startTime;

    /**
     * End time(Timestamp in Seconds)
     */
    @ParamKey("end_time")
    private Long endTime;

    public AffiliateTradeListRequest() {
        super("/contract/private/affiliate/trade-list", Method.GET, Auth.KEYED);
    }
}
