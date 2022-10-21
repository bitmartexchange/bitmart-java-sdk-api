package com.bitmart.api.request.margin_loan.prv;

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
public class MarginIsolatedPairsRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;      //It can be multiple-choice; if not filled in, then return all, like BTC_USDT, ETH_USDT

    public MarginIsolatedPairsRequest() {
        super("/spot/v1/margin/isolated/pairs", Method.GET, Auth.KEYED);
    }
}
