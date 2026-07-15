package com.bitmart.api.request.account.prv;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Query account information. No request parameters.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountInfoRequest extends CloudRequest {

    public AccountInfoRequest() {
        super("/uapi-key/v1/account/info", Method.GET, Auth.KEYED);
    }
}
