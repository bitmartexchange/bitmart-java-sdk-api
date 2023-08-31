package com.bitmart.api.request.contract.pub;

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
public class DetailsRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     *   (Optional, return the market information of all trading pairs by default)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * url: GET https://api-cloud.bitmart.com/contract/public/details
     * Applicable to query contract details
     */
    public DetailsRequest() {
        super("/contract/public/details", Method.GET, Auth.NONE);
    }
}
