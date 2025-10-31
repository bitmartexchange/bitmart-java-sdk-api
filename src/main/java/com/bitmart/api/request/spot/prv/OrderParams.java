package com.bitmart.api.request.spot.prv;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class OrderParams implements Serializable {

    private String side;                //buy or sell

    private String type;                //limit/market/limit_maker/ioc

    private String clientOrderId;     //Client-defined OrderId(A combination of numbers and letters, less than 32 bits)

    private String size;                //Order size
    private String price;               //Price
    private String notional;            //Quantity bought, required when buying at market price
    private String stpMode;            //Self-trade prevention mode

}
