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
public class OrderDetailRequest extends CloudRequest {

    @ParamKey("order_id")
    private String order_id;  //Order id

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v2/order_detail
     * Get order detail
     */
    public OrderDetailRequest() {
        super("/spot/v2/order_detail", Method.GET, Auth.KEYED);
    }
}
