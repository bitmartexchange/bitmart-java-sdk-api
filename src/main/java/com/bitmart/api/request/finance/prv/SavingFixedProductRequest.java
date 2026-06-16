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
 * Finance — query the fixed savings product list
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SavingFixedProductRequest extends CloudRequest {

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

    public SavingFixedProductRequest() {
        super("/newearn/cloud/v1/saving/fixed/product", Method.GET, Auth.KEYED);
    }
}
