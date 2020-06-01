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
public class CancelOrderRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;

    @ParamKey("entrust_id")
    private Long entrust_id;

    public CancelOrderRequest() {
        super("/spot/v1/cancel_order", Method.POST, Auth.SIGNED);
    }
}
