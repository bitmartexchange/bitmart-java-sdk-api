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
public class PlaceMarginOrderRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;              //Trading pair (e.g. BTC_USDT)

    @ParamKey("side")
    private String side;                //buy or sell

    @ParamKey("type")
    private String type;                //limit/market/limit_maker/ioc

    @ParamKey("clientOrderId")
    private String clientOrderId;       //Client-defined OrderId(A combination of numbers and letters, less than 32 bits)

    @ParamKey("size")
    private String size;                //Order size

    @ParamKey("price")
    private String price;               //Price

    @ParamKey("notional")
    private String notional;            //Quantity bought, required when buying at market price

    /**
     * url: POST https://api-cloud.bitmart.com/spot/v1/margin/submit_order
     * Applicable for margin order placement
     */
    public PlaceMarginOrderRequest() {
        super("/spot/v1/margin/submit_order", Method.POST, Auth.SIGNED);
    }
}
