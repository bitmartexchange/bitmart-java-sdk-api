package com.bitmart.api.request.system.pub;

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
public class SystemServiceRequest extends CloudRequest {

    public SystemServiceRequest() {
        super("/system/service", Method.GET, Auth.NONE);
    }
}
