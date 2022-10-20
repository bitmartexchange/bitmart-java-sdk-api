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
public class CancelOrderRequest extends CloudRequest {

    @ParamKey("symbol")
    @SerializedName("symbol")
    private String symbol;     //Contract Trading pair: symbol (Optional, return the market information of all trading pairs by default)

    @ParamKey("order_id")
    private String order_id;

    /**
     * url: POST https://api-cloud.bitmart.com/contract/private/cancel-order
     * Applicable for canceling a specific contract order
     */
    public CancelOrderRequest() {
        super("/contract/private/cancel-order", Method.POST, Auth.SIGNED);
    }
}
