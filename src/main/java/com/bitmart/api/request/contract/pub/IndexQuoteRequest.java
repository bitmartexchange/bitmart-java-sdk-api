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
public class IndexQuoteRequest extends CloudRequest {
    @ParamKey("indexID")
    @SerializedName("indexID")
    private long indexId;

    @ParamKey("startTime")
    private long startTime;


    @ParamKey("endTime")
    private long endTime;

    @ParamKey("unit")
    private int unit;

    @ParamKey("resolution")
    private String resolution;

    public IndexQuoteRequest() {
        super("/contract/v1/ifcontract/indexquote", Method.GET, Auth.NONE);
    }
}
