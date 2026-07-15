package com.bitmart.api.request.account.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Query the default deposit-crediting account. No request parameters.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class GetDepositAccountRequest extends CloudRequest {

    public GetDepositAccountRequest() {
        super("/account/v1/get-deposit-account", Method.GET, Auth.KEYED);
    }
}
