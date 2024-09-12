package com.bitmart.api.request.spot.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class CancelOrdersRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order Id List (Either orderIds or clientOrderIds must be provided)
     */
    @ParamKey("orderIds")
    private List<String> orderIds;

    /**
     * Client-defined OrderId List (Either orderIds or clientOrderIds must be provided)
     */
    @ParamKey("clientOrderIds")
    private List<String> clientOrderIds;

    /**
     * Transaction aging time (unit milliseconds), default: 5000
     */
    @ParamKey("recvWindow")
    private Long recvWindow;

    /**
     * Cancel all outstanding orders in the specified direction for the specified trading pair or cancel based on the order ID
     */
    public CancelOrdersRequest() {
        super("/spot/v4/cancel_orders", Method.POST, Auth.SIGNED);
    }
}
