package com.bitmart.api.request.contract.prv;


import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class TransferListRequest extends CloudRequest {

    /**
     * Currency (like USDT)
     */
    @ParamKey("currency")
    private String currency;

    /**
     * Start time in milliseconds, (e.g. 1681701557927)
     */
    @ParamKey("time_start")
    private Long timeStart;

    /**
     * End time in milliseconds, (e.g. 1681701557927)
     */
    @ParamKey("time_end")
    private Long timeEnd;

    /**
     * Number of pages, allowed range [1,1000]
     */
    @ParamKey(value = "page", required = true)
    private Integer page;

    /**
     * Number of queries, allowed range [10,100]
     */
    @ParamKey(value = "limit", required = true)
    private Integer limit;

    /**
     * Trade time limit, allowed range (0,60000], default: 5000 milliseconds
     */
    @ParamKey("recvWindow")
    private Long recvWindow;


    /**
     * url: POST https://api-cloud.bitmart.com/account/v1/transfer-contract-list
     * Query futures account transfer records
     */
    public TransferListRequest() {
        super("/account/v1/transfer-contract-list", Method.POST, Auth.SIGNED);
    }


}
