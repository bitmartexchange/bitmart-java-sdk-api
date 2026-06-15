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
 * Sub-Account (spot) — query sub-account transfer history (for main account)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class SubTransferListRequest extends CloudRequest {

    /**
     * Transfer type, e.g. "spot to spot"
     */
    @ParamKey(value = "moveType", required = true)
    private String moveType;

    /**
     * Sub-account username (default: query all sub-accounts)
     */
    @ParamKey("accountName")
    private String accountName;

    /**
     * The most recent N records (range 1-100)
     */
    @ParamKey(value = "N", required = true)
    private Integer n;

    public SubTransferListRequest() {
        super("/account/sub-account/main/v1/transfer-list", Method.GET, Auth.KEYED);
    }
}
