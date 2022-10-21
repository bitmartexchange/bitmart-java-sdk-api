package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class CancelOrdersRequest extends CloudRequest {

    @ParamKey("symbol")
    @SerializedName("symbol")
    private String symbol;     //Contract Trading pair: symbol (Optional, return the market information of all trading pairs by default)

    /**
     * url: POST https://api-cloud.bitmart.com/contract/private/cancel-orders
     * Applicable for batch order cancellation under a particular contract
     */
    public CancelOrdersRequest() {
        super("/contract/private/cancel-orders", Method.POST, Auth.SIGNED);
    }
}
