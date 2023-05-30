package com.bitmart.api.request.account.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * For querying the base rate of the current user
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/spot/v1/user_fee">
 *     https://api-cloud.bitmart.com/spot/v1/user_fee</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#get-basic-fee-rate-keyed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SpotUserFeeRequest extends CloudRequest {

    public SpotUserFeeRequest() {
        super("/spot/v1/user_fee", Method.GET, Auth.KEYED);
    }
}
