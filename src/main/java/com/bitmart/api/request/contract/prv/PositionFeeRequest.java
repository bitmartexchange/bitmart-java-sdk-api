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

/**
 * 查询仓位费用情况
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class PositionFeeRequest extends CloudRequest {
    @ParamKey("contractID")
    @SerializedName("contractID")
    private long contractId;

    @ParamKey("positionID")
    @SerializedName("positionID")
    private long positionID;

    public PositionFeeRequest() {
        super("/contract/v1/ifcontract/positionFee", Method.GET, Auth.KEYED);
    }
}
