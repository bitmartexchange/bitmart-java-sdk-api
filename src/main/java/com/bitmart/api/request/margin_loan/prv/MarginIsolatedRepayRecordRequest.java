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
public class MarginIsolatedRepayRecordRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;      //Trading pair(like BTC_USDT)

    @ParamKey("repay_id")
    private String repay_id;    //Repayment ID

    @ParamKey("currency")
    private String currency;    //Currency

    @ParamKey("start_time")
    private Long start_time;    //Query start time: Timestamp

    @ParamKey("end_time")
    private Long end_time;      //Query end time: Timestamp

    @ParamKey("N")
    private Integer N;          //Query record size (1-100). Default is 50

    public MarginIsolatedRepayRecordRequest() {
        super("/spot/v1/margin/isolated/repay_record", Method.GET, Auth.KEYED);
    }
}
