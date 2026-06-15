package com.bitmart.api.request.subaccount.contract;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Sub-Account (contract) — query sub-account transfer history (for main account)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class ContractSubTransferListRequest extends CloudRequest {

    /**
     * Sub-account username
     */
    @ParamKey(value = "subAccount", required = true)
    private String subAccount;

    /**
     * The most recent N records (range 1-100)
     */
    @ParamKey(value = "limit", required = true)
    private Integer limit;

    public ContractSubTransferListRequest() {
        super("/account/contract/sub-account/main/v1/transfer-list", Method.GET, Auth.KEYED);
    }
}
