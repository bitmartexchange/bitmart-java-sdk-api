package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.system.pub.SystemServiceRequest;
import com.bitmart.api.request.system.pub.SystemTimeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


final class TestSystem {

    private static final String CLOUD_URL = GlobalConst.CLOUD_URL;
    private static final String API_KEY = "";
    private static final String API_SECRET = "";
    private static final String API_MEMO = "";
    private static Call call;

    TestSystem(){
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
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
