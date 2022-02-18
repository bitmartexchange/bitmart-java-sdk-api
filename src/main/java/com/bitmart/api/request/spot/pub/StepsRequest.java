package com.bitmart.api.request.spot.pub;


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

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/steps
     * Get all k-line steps supported by the platform, expressed in minutes, minimum 1 minute.
     */
    public StepsRequest() {
        super("/spot/v1/steps", Method.GET, Auth.NONE);
    }
}
