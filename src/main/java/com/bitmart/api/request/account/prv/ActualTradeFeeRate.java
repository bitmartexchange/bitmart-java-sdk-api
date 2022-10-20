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
public class ActualTradeFeeRate extends CloudRequest {

    @ParamKey("symbol")
    private String symbol; //Trading pair, like (BTC_USDT)

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/trade_fee
     * For the actual fee rate of the trading pairs
     */
    public ActualTradeFeeRate() {
        super("/spot/v1/trade_fee", Method.GET, Auth.KEYED);
    }
}
