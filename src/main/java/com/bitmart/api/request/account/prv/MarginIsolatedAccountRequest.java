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
 * Applicable for isolated margin account inquiries
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/spot/v1/margin/isolated/account">
 *     https://api-cloud.bitmart.com/spot/v1/margin/isolated/account</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#get-margin-account-details-isolated-keyed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class MarginIsolatedAccountRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BMX_USDT), no symbol is passed, and all isolated margin assets are returned
     */
    @ParamKey("symbol")
    private String symbol;

    public MarginIsolatedAccountRequest() {
        super("/spot/v1/margin/isolated/account", Method.GET, Auth.KEYED);
    }
}
