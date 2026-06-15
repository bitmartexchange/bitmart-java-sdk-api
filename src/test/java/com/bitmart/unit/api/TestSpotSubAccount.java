package com.bitmart.unit.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.subaccount.spot.*;
import com.bitmart.unit.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TestSpotSubAccount extends TestData {

    @Test
    @DisplayName("Test. POST /account/sub-account/main/v1/sub-to-main")
    void testSubToMain() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubToMainRequest()
                .setRequestNo("3989672177547886592")
                .setAmount("1")
                .setCurrency("USDT")
                .setSubAccount("subAccountName")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /account/sub-account/sub/v1/sub-to-main")
    void testSubToMainSub() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubToMainSubRequest()
                .setRequestNo("3989672177547886592")
                .setAmount("1")
                .setCurrency("USDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /account/sub-account/main/v1/main-to-sub")
    void testMainToSub() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new MainToSubRequest()
                .setRequestNo("3989672177547886592")
                .setAmount("1")
                .setCurrency("USDT")
                .setSubAccount("subAccountName")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /account/sub-account/main/v1/sub-to-sub")
    void testSubToSub() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubToSubRequest()
                .setRequestNo("3989672177547886592")
                .setAmount("1")
                .setCurrency("USDT")
                .setFromAccount("fromSubAccount")
                .setToAccount("toSubAccount")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/sub-account/main/v1/transfer-list")
    void testSubTransferList() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubTransferListRequest()
                .setMoveType("spot to spot")
                .setAccountName("subAccountName")
                .setN(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/sub-account/v1/transfer-history")
    void testSubTransferHistory() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubTransferHistoryRequest()
                .setMoveType("spot to spot")
                .setN(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/sub-account/main/v1/wallet")
    void testSubWallet() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubWalletRequest()
                .setSubAccount("subAccountName")
                .setCurrency("USDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/sub-account/main/v1/subaccount-list")
    void testSubAccountList() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SubAccountListRequest());
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

}
