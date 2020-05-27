package com.bitmart.api.request.contract.pub;

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
public class IndexesRequest extends CloudRequest {

    public IndexesRequest() {
        super("/contract/v1/ifcontract/indexes", Method.GET, Auth.NONE);
    }
}
