package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.request.contract.pub.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class TestContract extends TestData {

    // ------------------  public -------------------------

    @Test
    @DisplayName("Test. GET /contract/v1/tickers")
    void contracts() throws CloudException {
        System.out.println(
                call.callCloud(new TickerRequest().setContract_symbol("ETHUSDT"))
        );
    }

}
