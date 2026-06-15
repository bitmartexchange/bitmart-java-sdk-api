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
 * Sub-Account (contract) — query account transfer history (for both main and sub accounts)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class ContractSubTransferHistoryRequest extends CloudRequest {

    /**
     * The most recent N records (range 1-100)
     */
    @ParamKey(value = "limit", required = true)
    private Integer limit;

    public ContractSubTransferHistoryRequest() {
        super("/account/contract/sub-account/v1/transfer-history", Method.GET, Auth.KEYED);
    }
}
