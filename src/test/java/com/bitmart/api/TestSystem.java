package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.system.pub.SystemServiceRequest;
import com.bitmart.api.request.system.pub.SystemTimeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


final class TestSystem {

    private static Call call;

    TestSystem(){
        CloudContext cloudContext = new CloudContext();
        call = new Call(cloudContext);
    }

    @Test
    @DisplayName("Test. GET /system/time")
    void testTime() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SystemTimeRequest());

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }

    @Test
    @DisplayName("Test. GET /system/service")
    void testService() throws CloudException {
        final CloudResponse cloudResponse = call.callCloud(new SystemServiceRequest());

        System.out.println(cloudResponse);
        assertEquals(200, cloudResponse.getResponseHttpStatus());
    }





}
