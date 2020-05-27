package com.bitmart.api.request.contract.pub;

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
public class FundingRateRequest extends CloudRequest {
    @ParamKey("contractID")
    @SerializedName("contractID")
    private long contractId;

    public FundingRateRequest() {
        super("/contract/v1/ifcontract/fundingrate", Method.GET, Auth.NONE);
    }
}
