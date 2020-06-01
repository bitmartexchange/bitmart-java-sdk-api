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
public class TradesHistoryRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;

    @ParamKey("offset")
    private Integer offset;

    @ParamKey("limit")
    private Integer limit;

    public TradesHistoryRequest() {
        super("/spot/v1/trades", Method.GET, Auth.KEYED);
    }
}
