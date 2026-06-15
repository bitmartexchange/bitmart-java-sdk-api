package com.bitmart.unit.api;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.subaccount.contract.*;
import com.bitmart.unit.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TestContractSubAccount extends TestData {

    TestContractSubAccount() {
        CloudContext cloudContext = new CloudContext(FUTURES_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        cloudContext.setReadTimeoutMilliSeconds(10000); // Set read timeout
        // Set your custom headers
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("Your-Custom-Header", "xxxxx");
        cloudContext.setCustomHeaders(customHeaders);
        call = new Call(cloudContext);
    }

    @Test
    @DisplayName("Test. POST /account/contract/sub-account/main/v1/sub-to-main")
    void testContractSubToMain() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new ContractSubToMainRequest()
                .setRequestNo("3989672177547886592")
                .setAmount("1")
                .setCurrency("USDT")
                .setSubAccount("subAccountName")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /account/contract/sub-account/main/v1/main-to-sub")
    void testContractMainToSub() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new ContractMainToSubRequest()
                .setRequestNo("3989672177547886592")
                .setAmount("1")
                .setCurrency("USDT")
                .setSubAccount("subAccountName")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. POST /account/contract/sub-account/sub/v1/sub-to-main")
    void testContractSubToMainSub() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new ContractSubToMainSubRequest()
                .setRequestNo("3989672177547886592")
                .setAmount("1")
                .setCurrency("USDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/contract/sub-account/main/v1/wallet")
    void testContractSubWallet() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new ContractSubWalletRequest()
                .setSubAccount("subAccountName")
                .setCurrency("USDT")
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/contract/sub-account/main/v1/transfer-list")
    void testContractSubTransferList() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new ContractSubTransferListRequest()
                .setSubAccount("subAccountName")
                .setLimit(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /account/contract/sub-account/v1/transfer-history")
    void testContractSubTransferHistory() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new ContractSubTransferHistoryRequest()
                .setLimit(10)
        );
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

}
