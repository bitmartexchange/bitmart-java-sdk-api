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

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class CancelOrdersRequest extends CloudRequest {

    @ParamKey("orders")
    private List<Orders> orders;


    public CancelOrdersRequest() {
        super("/contract/v1/ifcontract/cancelOrders", Method.POST, Auth.SIGNED);
    }

    @Data
    @Accessors(chain = true)
    public static class Orders  {

        private int contract_id;

        private List<Long> orders;


        @Override
        public String toString() {
            return "{" +
                    "contract_id=" + contract_id +
                    ", orders=" + orders +
                    '}';
        }
    }
}
