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
public class CancelOrdersRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;      //Trading pair (e.g. BTC_USDT)

    @ParamKey("side")
    private String side;        //buy or sell

    /**
     * url: POST https://api-cloud.bitmart.com/spot/v1/cancel_orders
     * Cancel all outstanding orders in the specified side for a trading pair
     */
    public CancelOrdersRequest() {
        super("/spot/v1/cancel_orders", Method.POST, Auth.SIGNED);
    }
}
