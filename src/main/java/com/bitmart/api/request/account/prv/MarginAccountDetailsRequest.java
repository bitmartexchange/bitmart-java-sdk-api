package com.bitmart.api.request.account.prv;

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
public class MarginAccountDetailsRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol; //Trading pair, like (BTC_USDT), no symbol is passed, and all isolated margin assets are returned

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/margin/isolated/account
     * Applicable for isolated margin account inquiries
     */
    public MarginAccountDetailsRequest() {
        super("/spot/v1/margin/isolated/account", Method.GET, Auth.KEYED);
    }
}
