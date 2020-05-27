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
public class UserTradesRequest extends CloudRequest {
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

    public UserTradesRequest() {
        super("/contract/v1/ifcontract/userTrades", Method.GET, Auth.KEYED);
    }
}
