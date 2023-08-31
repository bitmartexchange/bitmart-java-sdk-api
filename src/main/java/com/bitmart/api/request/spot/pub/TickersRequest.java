package com.bitmart.api.request.spot.pub;


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
@Deprecated
public final class TickersRequest extends CloudRequest {

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v2/ticker
     * Applicable to query the latest ticker of all trading pairs,
     * please note that the endpoint returns more data, please reduce the frequency of calls
     */
    public TickersRequest() {
        super("/spot/v2/ticker", Method.GET, Auth.NONE);
    }
}
