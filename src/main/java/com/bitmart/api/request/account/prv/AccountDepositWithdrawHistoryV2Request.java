package com.bitmart.api.request.account.prv;

import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Search for all existed withdraws and deposits and return their latest status.
 * <br><br>
 * GET <a href="https://api-cloud.bitmart.com/account/v2/deposit-withdraw/history">...</a>
 * <br>
 * @see <a href="https://developer-pro.bitmart.com/en/spot/#get-deposit-and-withdraw-history-keyed">
 *     BitMart Document</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class AccountDepositWithdrawHistoryV2Request extends CloudRequest {

    /**
     * Token symbol, e.g., 'BTC'
     */
    @ParamKey("currency")
    private String currency;


    /**
     * type
     * -deposit=deposit
     * -withdraw=withdraw
     */
    @ParamKey(value = "operation_type", required = true)
    private String operationType;

    /**
     * Recent N records (value range 1-100)
     */
    @ParamKey(value = "N", required = true)
    private Integer N;

    /**
     * Default: 90 days from current timestamp (milliseconds)
     */
    @ParamKey(value = "startTime")
    private Long startTime;

    /**
     * Default: present timestamp (milliseconds)
     */
    @ParamKey(value = "endTime")
    private Long endTime;

    public AccountDepositWithdrawHistoryV2Request() {
        super("/account/v2/deposit-withdraw/history", Method.GET, Auth.KEYED);
    }

}
