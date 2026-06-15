package com.bitmart.api.request.subaccount.spot;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Sub-Account (spot) — query account transfer history (for both main and sub accounts)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubTransferHistoryRequest extends CloudRequest {

    /**
     * Transfer type, e.g. "spot to spot"
     */
    @ParamKey(value = "moveType", required = true)
    private String moveType;

    /**
     * The most recent N records (range 1-100)
     */
    @ParamKey(value = "N", required = true)
    private Integer n;

    public SubTransferHistoryRequest() {
        super("/account/sub-account/v1/transfer-history", Method.GET, Auth.KEYED);
    }
}
