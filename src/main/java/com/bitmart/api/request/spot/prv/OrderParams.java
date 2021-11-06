package com.bitmart.api.request.spot.prv;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class OrderParams implements Serializable {

    private String symbol;

    private String side;

    private String type;

    private String size;
    private String price;
    private String notional;

}
