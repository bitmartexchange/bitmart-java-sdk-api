package com.bitmart.api.request.margin_loan.prv;

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
public class MarginRepayIsolatedRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;      //Repayment trading pairs(like BTC_USDT)

    @ParamKey("currency")
    private String currency;    //Repayment currency, selected according to the borrowing trading pair(like BTC or USDT)

    @ParamKey("amount")
    private String amount;      //Amount of repayments (precision: 8 decimal places)

    public MarginRepayIsolatedRequest() {
        super("/spot/v1/margin/isolated/repay", Method.POST, Auth.SIGNED);
    }
}
