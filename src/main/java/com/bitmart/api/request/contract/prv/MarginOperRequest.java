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
public class MarginOperRequest extends CloudRequest {
    @ParamKey("contract_id")
    @SerializedName("contract_id")
    private long contractId;

    @ParamKey("position_id")
    @SerializedName("position_id")
    private long positionId;

    @ParamKey("vol")
    private int vol;

    @ParamKey("oper_type")
    @SerializedName("oper_type")
    private int operType;

    public MarginOperRequest() {
        super("/contract/v1/ifcontract/marginOper", Method.POST, Auth.SIGNED);
    }
}
