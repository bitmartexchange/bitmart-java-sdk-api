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
 * Finance — query the flexible savings product list
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingProductRequest extends CloudRequest {

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

    public SavingProductRequest() {
        super("/newearn/cloud/v1/saving/product", Method.GET, Auth.KEYED);
    }
}
