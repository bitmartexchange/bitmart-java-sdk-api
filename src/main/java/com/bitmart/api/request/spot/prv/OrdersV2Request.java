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
    private String symbol;  //Trading pair (e.g. BTC_USDT)

    @ParamKey("N")
    private Integer N;      //Recent N records (value range 1-100)

    @ParamKey("status")
    private String status;  //1=Order failure;2=Order success;3=Freeze failure;4=Freeze success;5=Partially filled;6=Fully filled;7=Canceling;8=Canceled;9=Outstanding (4 and 5);10= 6 and 8

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v2/orders
     * Get a list of user orders
     */
    public OrdersV2Request() {
        super("/spot/v2/orders", Method.GET, Auth.KEYED);
    }

}
