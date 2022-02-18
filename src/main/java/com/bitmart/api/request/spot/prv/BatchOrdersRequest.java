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

    @ParamKey("orderParams")
    private List<OrderParams> orderParams;      //Order parameters, the number of transactions cannot exceed 10

    /**
     * url: POST https://api-cloud.bitmart.com/spot/v1/batch_orders
     * Batch order
     */
    public BatchOrdersRequest() {
        super("/spot/v1/batch_orders", Method.POST, Auth.SIGNED);
    }

}
