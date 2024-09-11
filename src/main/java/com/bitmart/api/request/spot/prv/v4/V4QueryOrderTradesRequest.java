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
public class V4QueryOrderTradesRequest extends CloudRequest {

    /**
     * bitmart's order id
     */
    @ParamKey("orderId")
    private String orderId;


    /**
     * Transaction aging time (unit milliseconds), default: 5000
     */
    @ParamKey("recvWindow")
    private Long recvWindow;

    /**
     * Query all transaction records of a single order
     */
    public V4QueryOrderTradesRequest() {
        super("/spot/v4/query/order-trades", Method.POST, Auth.SIGNED);
    }

}
