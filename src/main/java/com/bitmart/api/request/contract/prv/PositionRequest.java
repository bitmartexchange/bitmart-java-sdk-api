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
public class PositionRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * url: GET https://api-cloud.bitmart.com/contract/private/position
     * Applicable for checking the position details a specified contract
     */
    public PositionRequest() {
        super("/contract/private/position", Method.GET, Auth.SIGNED);
    }
}
