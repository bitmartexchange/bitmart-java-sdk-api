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
public class MarginIsolatedBorrowRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;      //Borrowing trading pairs(like BTC_USDT)

    @ParamKey("currency")
    private String currency;    //Borrowing currency, selected according to the borrowing trading pair(like BTC or USDT)

    @ParamKey("amount")
    private String amount;      //Amount of borrowing (precision: 8 decimal places)

    public MarginIsolatedBorrowRequest() {
        super("/spot/v1/margin/isolated/borrow", Method.POST, Auth.SIGNED);
    }
}
