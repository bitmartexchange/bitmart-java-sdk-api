package com.bitmart.api.request.contract.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * category 订单类型 1:限价单,2:市价单
 *
 * way 订单方向 1:开多,2:平空,3:平多,4:开空
 *
 * open_type 开仓方式 1:逐仓,2:全仓
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SubmitOrderRequest extends CloudRequest {

    @ParamKey("contract_id")
    @SerializedName("contract_id")
    private long contractId;

    @ParamKey("category")
    private int category;

    @ParamKey("way")
    private int way;

    @ParamKey("open_type")
    @SerializedName("open_type")
    private int openType;

    @ParamKey("leverage")
    private int leverage;

    @ParamKey("custom_id")
    @SerializedName("custom_id")
    private int customId;

    @ParamKey("price")
    private String price;

    @ParamKey("vol")
    private String vol;

    public SubmitOrderRequest() {
        super("/contract/v1/ifcontract/submitOrder", Method.POST, Auth.SIGNED);
    }

    @Override
    public String toString() {
        return "{" +
                "contract_id=" + contractId +
                ", category=" + category +
                ", way=" + way +
                ", open_type=" + openType +
                ", leverage=" + leverage +
                ", custom_id=" + customId +
                ", price=" + price +
                ", vol=" + vol +
                '}';
    }
}
