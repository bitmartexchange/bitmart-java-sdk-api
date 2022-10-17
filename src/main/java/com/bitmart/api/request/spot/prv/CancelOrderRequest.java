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
    private String symbol;              //Trading pair (e.g. BTC_USDT)

    @ParamKey("order_id")
    private String order_id;            //Order id

    @ParamKey("client_order_id")
    private String client_order_id;     //Client-defined Order ID

    /**
     * url: POST https://api-cloud.bitmart.com/spot/v3/cancel_order
     * Cancel an outstanding order
     */
    public CancelOrderRequest() {
        super("/spot/v3/cancel_order", Method.POST, Auth.SIGNED);
    }
}
