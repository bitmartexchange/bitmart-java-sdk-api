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
public class V4QueryOrderByClientOrderIdRequest extends CloudRequest {

    /**
     * Client Order ID
     */
    @ParamKey("clientOrderId")
    private String clientOrderId;

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
     * url: POST https://api-cloud.bitmart.com/spot/v4/query/client-order
     * Query a single order based on the client order id
     */
    public V4QueryOrderByClientOrderIdRequest() {
        super("/spot/v4/query/client-order", Method.POST, Auth.SIGNED);
    }

}
