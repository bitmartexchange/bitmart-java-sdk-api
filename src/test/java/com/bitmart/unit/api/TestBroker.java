package com.bitmart.unit.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.broker.BrokerRebateRequest;
import com.bitmart.unit.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestBroker extends TestData {

    // ------------------------ prv ------------------------------------------

    @Test
    @DisplayName("Test. GET /spot/v1/broker/rebate")
    void testBrokerRebate() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new BrokerRebateRequest());//Default last 180 days
        assertEquals(200, cloudResponse.getResponseHttpStatus());

        final CloudResponse cloudResponse1 = call.callCloud(new BrokerRebateRequest()
                .setStart_time(System.currentTimeMillis() / 1000 - 60 * 60 * 24 * 7)
                .setEnd_time(System.currentTimeMillis() / 1000));//Query the records of the last 7 days
        assertEquals(200, cloudResponse1.getResponseHttpStatus());
    }
}
