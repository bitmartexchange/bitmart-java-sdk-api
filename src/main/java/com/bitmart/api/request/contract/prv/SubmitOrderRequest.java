package com.bitmart.api.request.contract.prv;

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

    @ParamKey("symbol")
    private String symbol;      //Trading pair (e.g. BTC_USDT)

    @ParamKey("type")
    private String type;        //limit or market

    @ParamKey("side")
    private Integer side;       //1,2,3,4

    @ParamKey("leverage")
    private String leverage;    //leverage

    @ParamKey("open_type")
    private String open_type;    //cross or isolated

    @ParamKey("price")
    private String price;       //Price

    @ParamKey("size")
    private Integer size;        //Order size

    /**
     * url: POST https://api-cloud.bitmart.com/contract/private/submit_order
     * Applicable for placing contract order
     */
    public SubmitOrderRequest() {
        super("/contract/private/submit_order", Method.POST, Auth.SIGNED);
    }

}
