package com.bitmart.api.request.spot.prv;

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
public class OrdersV2Request extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;

    @ParamKey("N")
    private Integer N;

    @ParamKey("status")
    private String status;

    public OrdersV2Request() {
        super("/spot/v2/orders", Method.GET, Auth.KEYED);
    }

}
