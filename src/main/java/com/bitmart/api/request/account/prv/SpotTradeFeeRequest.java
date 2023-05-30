package com.bitmart.api.request.account.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * For the actual fee rate of the trading pairs
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/spot/v1/trade_fee">
 *     https://api-cloud.bitmart.com/spot/v1/trade_fee</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#get-actual-trade-fee-rate-keyed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SpotTradeFeeRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BMX_USDT)
     */
    @ParamKey("symbol")
    private String symbol;


    public SpotTradeFeeRequest() {
        super("/spot/v1/trade_fee", Method.GET, Auth.KEYED);
    }
}
