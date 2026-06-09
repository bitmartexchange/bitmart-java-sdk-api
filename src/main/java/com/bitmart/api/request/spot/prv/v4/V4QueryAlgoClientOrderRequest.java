package com.bitmart.api.request.spot.prv.v4;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Algo order (V4) — query a single strategy order by clientOrderId
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class V4QueryAlgoClientOrderRequest extends CloudRequest {

    /**
     * Client-defined order id
     */
    @ParamKey(value = "clientOrderId", required = true)
    private String clientOrderId;

    /**
     * Query order state
     * -open = orders with state [new, partially_filled]
     * -history = orders with state [filled, canceled, partially_canceled]
     */
    @ParamKey("queryState")
    private String queryState;

    /**
     * Transaction aging time, range (0,60000], default: 5000 milliseconds
     */
    @ParamKey("recvWindow")
    private Long recvWindow;

    public V4QueryAlgoClientOrderRequest() {
        super("/spot/v4/query/algo/client-order", Method.POST, Auth.SIGNED);
    }
}
