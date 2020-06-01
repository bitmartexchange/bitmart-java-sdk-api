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
public class SubmitSellLimitOrderRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;

    @ParamKey("side")
    private String side = "sell";

    @ParamKey("type")
    private String type = "limit";

    @ParamKey("size")
    private String size;

    @ParamKey("price")
    private String price;

    public SubmitSellLimitOrderRequest() {
        super("/spot/v1/submit_order", Method.POST, Auth.SIGNED);
    }
}
