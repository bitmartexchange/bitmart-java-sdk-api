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
public class AccountWithdrawApplyRequest extends CloudRequest {

    @ParamKey("currency")
    private String currency;        //Token symbol, e.g., 'BTC'

    @ParamKey("amount")
    private String amount;          //The amount of currency to withdraw

    @ParamKey("destination")
    private String destination;     //To Digital Address=Withdraw to the digital currency address

    @ParamKey("address")
    private String address;         //Address (only the address added on the official website is supported)

    @ParamKey("address_memo")
    private String address_memo;    //Tag(tag Or payment_id Or memo)

    /**
     * url: POST https://api-cloud.bitmart.com/account/v1/withdraw/apply
     * Creates a withdraw request from spot account to an external address
     */
    public AccountWithdrawApplyRequest() {
        super("/account/v1/withdraw/apply", Method.POST, Auth.SIGNED);
    }
}

