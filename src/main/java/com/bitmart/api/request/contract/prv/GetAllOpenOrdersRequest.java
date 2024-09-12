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
public class GetAllOpenOrdersRequest extends CloudRequest {

    /**
     * Symbol of the contract(like BTCUSDT)
     */
    @ParamKey("symbol")
    private String symbol;

    /**
     * Order type
     * -limit
     * - market
     * - trailing
     */
    @ParamKey("type")
    private String type;

    /**
     * Order state
     * -all(default)
     * -partially_filled
     */
    @ParamKey("order_state")
    private String orderState;

    /**
     * The number of returned results, with a maximum of 100 and a default of 100
     */
    @ParamKey("limit")
    private Integer limit;

    /**
     * Applicable for querying contract all open orders
     */
    public GetAllOpenOrdersRequest() {
        super("/contract/private/get-open-orders", Method.GET, Auth.KEYED);
    }
}
