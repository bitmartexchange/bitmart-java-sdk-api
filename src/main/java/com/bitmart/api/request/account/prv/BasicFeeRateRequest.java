package com.bitmart.api.request.account.prv;

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
public class BasicFeeRateRequest extends CloudRequest {

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/user_fee
     * For querying the base rate of the current user
     */
    public BasicFeeRateRequest() {
        super("/spot/v1/user_fee", Method.GET, Auth.KEYED);
    }
}
