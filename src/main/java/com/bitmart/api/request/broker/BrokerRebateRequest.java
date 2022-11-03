package com.bitmart.api.request.broker;

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
public class BrokerRebateRequest extends CloudRequest {

    @ParamKey("start_time")
    private Long start_time;    // Query start time stamp (seconds)

    @ParamKey("end_time")
    private Long end_time;      // Query end time stamp (seconds)

    public BrokerRebateRequest() {
        super("/spot/v1/broker/rebate", Method.GET, Auth.KEYED);
    }
}
