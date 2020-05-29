package com.bitmart.api.request.Quotation;


import com.bitmart.api.annotations.ParamKey;
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
public final class StepsRequest extends CloudRequest {


    public StepsRequest() {
        super("/spot/v1/steps", Method.GET, Auth.NONE);
    }
}
