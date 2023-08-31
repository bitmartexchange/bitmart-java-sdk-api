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
public class OpenInterestRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * url: GET <a href="https://api-cloud.bitmart.com/contract/public/open-interest">...</a>
     * Applicable for querying the open interest and open interest value data of the specified contract
     */
    public OpenInterestRequest() {
        super("/contract/public/open-interest", Method.GET, Auth.NONE);
    }
}
