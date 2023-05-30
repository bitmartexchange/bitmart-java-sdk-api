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
 * For fund transfers between a margin account and spot account
 * <br><br>
 * POST <a href="https://api-cloud.bitmart.com/spot/v1/margin/isolated/transfer">
 *     https://api-cloud.bitmart.com/spot/v1/margin/isolated/transfer</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#margin-asset-transfer-signed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class MarginIsolatedTransferRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BMX_USDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Currency
     */
    @ParamKey("currency")
    private String currency;

    /**
     * Amount of transfers (precision: 8 decimal places)
     */
    @ParamKey("amount")
    private String amount;

    /**
     * Transfer direction
     * - in=Transfer in
     * - out=Transfer out
     */
    @ParamKey("side")
    private String side;

    public MarginIsolatedTransferRequest() {
        super("/spot/v1/margin/isolated/transfer", Method.POST, Auth.SIGNED);
    }
}
