package com.bitmart.api.request.spot.prv.v4;

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
public class V4QueryOrderByOrderIdRequest extends CloudRequest {

    /**
     * bitmart's order id
     */
    @ParamKey("orderId")
    private String orderId;

    /**
     * Query order state , `open` or `history`
     */
    @ParamKey("queryState")
    private String queryState;

    /**
     * Transaction aging time, default: 5000 milliseconds
     */
    @ParamKey("recvWindow")
    private Long recvWindow;


    /**
     * Query a single order based on the order id
     */
    public V4QueryOrderByOrderIdRequest() {
        super("/spot/v4/query/order", Method.POST, Auth.SIGNED);
    }

}
