package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AssetsDetailRequest extends CloudRequest {

    /**
     * url: GET https://api-cloud.bitmart.com/contract/private/assets-detail
     * Applicable for querying user contract asset details
     */
    public AssetsDetailRequest() {
        super("/contract/private/assets-detail", Method.GET, Auth.SIGNED);
    }
}
