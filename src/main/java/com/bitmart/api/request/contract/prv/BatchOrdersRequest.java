package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 批量下单
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class BatchOrdersRequest extends CloudRequest {

    @ParamKey("orders")
    private List<SubmitOrderRequest> orders;

    public BatchOrdersRequest() {
        super("/contract/v1/ifcontract/batchOrders", Method.POST, Auth.SIGNED);
    }
}
