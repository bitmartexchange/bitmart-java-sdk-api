package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class UserOrdersRequest extends CloudRequest {
    @ParamKey("contractID")
    @SerializedName("contractID")
    private long contractId;

    @ParamKey("offset")
    private int offset;

    /**
     * size 请求数量,如果size不传或size为0,系统最多返回60条
     */
    @ParamKey("size")
    private int size;

    /**
     * 订单状态 1:申报中 2:委托中 4:完成 如果请求参数status=3,标识同时请求申报中和委托中的订单,如果请求参数status=0或者7,标识同时请求所有状态的订单
     */
    @ParamKey("status")
    private int status;

    public UserOrdersRequest() {
        super("/contract/v1/ifcontract/userOrders", Method.GET, Auth.KEYED);
    }
}
