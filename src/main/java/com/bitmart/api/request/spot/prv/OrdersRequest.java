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
public class OrdersRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;

    @ParamKey("offset")
    private Integer offset;

    @ParamKey("limit")
    private Integer limit;

    @ParamKey("status")
    private String status;

    public OrdersRequest() {
        super("/spot/v1/orders", Method.GET, Auth.KEYED);
    }
}
