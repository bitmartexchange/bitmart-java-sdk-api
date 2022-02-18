package com.bitmart.api.request.contract.pub;

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
public class TickerRequest extends CloudRequest {

    @ParamKey("contract_symbol")
    @SerializedName("contract_symbol")
    private String contract_symbol;     //Contract Trading pair: contract_symbol (Optional, return the market information of all trading pairs by default)

    /**
     * url: GET https://api-cloud.bitmart.com/contract/v1/tickers
     * Get the latest market quotations of the futures
     */
    public TickerRequest() {
        super("/contract/v1/tickers", Method.GET, Auth.NONE);
    }
}
