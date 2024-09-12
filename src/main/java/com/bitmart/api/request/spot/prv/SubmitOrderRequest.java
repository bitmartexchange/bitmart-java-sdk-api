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
public class SubmitOrderRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * buy or sell
     */
    @ParamKey(value = "side", required = true)
    private String side;

    /**
     * Yes	Order type
     * -limit=Limit order
     * -market=Market order
     * -limit_maker=PostOnly order
     * -ioc=IOC order
     */
    @ParamKey(value = "type", required = true)
    private String type;

    /**
     * Client-defined OrderId(A combination of numbers and letters, less than 32 bits)
     */
    @ParamKey("client_order_id")
    private String client_order_id;

    /**
     * Order size || Required for placing orders by quantity
     */
    @ParamKey("size")
    private String size;

    /**
     * Order Price
     */
    @ParamKey("price")
    private String price;

    /**
     * Required for placing orders by amount
     */
    @ParamKey("notional")
    private String notional;

    /**
     * url: POST https://api-cloud.bitmart.com/spot/v2/submit_order
     * Place order
     */
    public SubmitOrderRequest() {
        super("/spot/v2/submit_order", Method.POST, Auth.SIGNED);
    }

}
