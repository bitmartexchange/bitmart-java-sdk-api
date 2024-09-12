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
public class TransferRequest extends CloudRequest {

    /**
     * Currency (Only USDT is supported)
     */
    @ParamKey("currency")
    private String currency;

    /**
     * Transfer amount，allowed range[0.01,10000000000]
     */
    @ParamKey("amount")
    private String amount;

    /**
     * Transfer type
     *  -spot_to_contract
     *  -contract_to_spot
     */
    @ParamKey("type")
    private String type;

    /**
     * Trade time limit, allowed range (0,60000], default: 5000 milliseconds
     */
    @ParamKey("recvWindow")
    private Long recvWindow;

    /**
     * Transfer between spot account and contract account
     */
    public TransferRequest() {
        super("/account/v1/transfer-contract", Method.POST, Auth.SIGNED);
    }


}
