package com.bitmart.api.request.account.prv;

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
public class MarginAssetTransferRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;      //Trading pair, like (BTC_USDT)

    @ParamKey("currency")
    private String currency;    //Currency

    @ParamKey("amount")
    private String amount;      //Amount of transfers (precision: 8 decimal places)

    @ParamKey("side")
    private String side;        //Transfer direction: in=Transfer in,out=Transfer out

    /**
     * url: GET https://api-cloud.bitmart.com/spot/v1/margin/isolated/transfer
     * For fund transfers between a margin account and spot account
     */
    public MarginAssetTransferRequest() {
        super("/spot/v1/margin/isolated/transfer", Method.POST, Auth.SIGNED);
    }
}
