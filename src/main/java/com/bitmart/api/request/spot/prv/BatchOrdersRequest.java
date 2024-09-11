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
public class BatchOrdersRequest extends CloudRequest {

    /**
     * Trading pair (e.g. BTC_USDT)
     */
    @ParamKey(value = "symbol", required = true)
    private String symbol;

    /**
     * Order parameters, the number of transactions cannot exceed 10
     */
    @ParamKey("orderParams")
    private List<OrderParams> orderParams;


    /**
     * Transaction aging time (unit milliseconds), default: 5000
     */
    @ParamKey("recvWindow")
    private Long recvWindow;

    /**
     * Batch order
     */
    public BatchOrdersRequest() {
        super("/spot/v4/batch_orders", Method.POST, Auth.SIGNED);
    }

}
