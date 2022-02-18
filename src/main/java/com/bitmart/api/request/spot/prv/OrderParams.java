package com.bitmart.api.request.spot.prv;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class OrderParams implements Serializable {

    private String symbol;      //Trading pair (e.g. BTC_USDT)

    private String side;        //buy or sell

    private String type;        //limit/market/limit_maker/ioc

    private String size;        //Order size
    private String price;       //Price
    private String notional;    //Quantity bought, required when buying at market price

}
