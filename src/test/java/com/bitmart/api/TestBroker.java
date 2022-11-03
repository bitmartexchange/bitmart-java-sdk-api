package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.request.broker.BrokerRebateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBroker extends TestData {

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. GET /spot/v1/broker/rebate")
    void getBrokerRebate() throws CloudException {
        System.out.println(
                call.callCloud(new BrokerRebateRequest())   //Default last 180 days
        );
        System.out.println(
                call.callCloud(new BrokerRebateRequest()
                        .setStart_time(System.currentTimeMillis() / 1000 - 60 * 60 * 24 * 7)
                        .setEnd_time(System.currentTimeMillis() / 1000))    //Query the records of the last 7 days
        );
    }
}
