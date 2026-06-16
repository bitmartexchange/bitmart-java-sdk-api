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
 * Finance — query flexible savings holdings
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingEarnRequest extends CloudRequest {

    /**
     * Filter by coin name (e.g. USDT)
     */
    @ParamKey("coinName")
    private String coinName;

    /**
     * Filter by product ID
     */
    @ParamKey("productId")
    private String productId;

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

    public SavingEarnRequest() {
        super("/newearn/cloud/v1/saving/earn", Method.GET, Auth.KEYED);
    }
}
