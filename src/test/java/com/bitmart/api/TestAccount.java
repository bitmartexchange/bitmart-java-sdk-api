package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.account.prv.*;
import com.bitmart.api.request.account.pub.AccountCurrenciesRequest;
import com.bitmart.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


final class TestAccount extends TestData {


    // -------------- pub

    @Test
    @DisplayName("Test. GET /account/v1/currencies")
    void testCurrencies() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AccountCurrenciesRequest());
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    // -------------- prv

    @Test
    @DisplayName("Test. GET /account/v1/wallet")
    void wallet() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AccountWalletRequest()
                .setCurrency("BTC")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());


        final CloudResponse cloudResponse1 = call.callCloud(new AccountWalletRequest());
        System.out.println(cloudResponse1);
        assertEquals(200, cloudResponse1.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. GET /account/v1/deposit/address")
    void depositAddress() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AccountDepositAddressRequest()
                .setCurrency("USDT-TRC20")
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/v1/withdraw/charge")
    void withdrawCharge() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AccountWithdrawChargeRequest()
                .setCurrency("BMX")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }


    @Test
    @DisplayName("Test. POST /account/v1/withdraw/apply")
    void withdrawApply() throws CloudException {

        // Parameters for Withdraw to the blockchain
        final CloudResponse cloudResponse = call.callCloud(new AccountWithdrawApplyRequest()
                .setCurrency("USDT-ERC20")
                .setAmount("50.000")
                .setDestination("2:BitMart")
                .setAddress("0xe57b69a8776b37860407965B73cdFFBDFe668Bb5")
                .setAddress_memo("")
        );
        //assertEquals(200, cloudResponse.getResponseHttpStatus());


        // Parameters for Withdraw to BitMart account
        final CloudResponse cloudResponse2 = call.callCloud(new AccountWithdrawApplyRequest()
                .setCurrency("USDT-ERC20")
                .setAmount("50.000")
                .setType(1)
                .setValue("876940329")
                .setAreaCode("")
        );
        assertEquals(200, cloudResponse2.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/v2/deposit-withdraw/history")
    void depositWithdrawHistoryV2() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AccountDepositWithdrawHistoryV2Request()
                // .setCurrency("BMX")
                .setOperationType("withdraw")
                .setN(10)
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/v1/deposit-withdraw/detail")
    void depositWithdrawDetail() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new AccountDepositWithdrawDetailRequest()
                .setId(1679947L)
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/margin/isolated/account")
    void marginAccountDetails() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedAccountRequest()
                .setSymbol("BTC_USDT")
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /spot/v1/margin/isolated/transfer")
    void marginAssetTransfer() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MarginIsolatedTransferRequest()
                .setSymbol("BTC_USDT")
                .setCurrency("USDT")
                .setAmount("1")
                .setSide("in")
        );

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/user_fee")
    void getBasicFeeRate() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SpotUserFeeRequest());

        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /spot/v1/trade_fee")
    void getActualTradeFeeRate() throws CloudException {
        System.out.println(
                call.callCloud(new SpotTradeFeeRequest()
                        .setSymbol("BTC_USDT")
                )
        );
    }

}
