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
public class TradesRequest extends CloudRequest {

    @ParamKey("symbol")
    @SerializedName("symbol")
    private String symbol;     //Contract Trading pair: symbol (Optional, return the market information of all trading pairs by default)

    @ParamKey("start_time")
    private Long start_time;    //Start timestamp (in seconds, UTC+0 TimeZome)

    @ParamKey("end_time")
    private Long end_time;      //End timestamp (in seconds, UTC+0 TimeZome)

    /**
     * url: GET https://api-cloud.bitmart.com/contract/private/trades
     * Applicable for querying contract order trade detail
     */
    public TradesRequest() {
        super("/contract/private/trades", Method.GET, Auth.SIGNED);
    }
}
