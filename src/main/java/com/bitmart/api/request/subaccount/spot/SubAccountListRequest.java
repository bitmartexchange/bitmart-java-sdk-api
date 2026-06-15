package com.bitmart.api.request.subaccount.spot;

import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Sub-Account (spot) — query the sub-account list (for main account). No request parameters.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubAccountListRequest extends CloudRequest {

    public SubAccountListRequest() {
        super("/account/sub-account/main/v1/subaccount-list", Method.GET, Auth.KEYED);
    }
}
