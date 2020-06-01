package com.bitmart.api.contract.prv;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.system.pub.SystemServiceRequest;
import com.bitmart.api.request.system.pub.SystemTimeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestSystem {

    //    private static String CLOUD_URL =  "http://localhost:8080";
    private static String CLOUD_URL = GlobalConst.CLOUD_URL;
    private static String API_KEY = "";
    private static String API_SECRET = "";
    private static String API_MEMO = "";
    private static Call call;

    TestSystem(){
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);
    }

    @Test
    @DisplayName("Test. GET /system/time")
    void time() throws CloudException {
        System.out.println(
                call.callCloud(new SystemTimeRequest())
        );
    }

    @Test
    @DisplayName("Test. GET /system/service")
    void service() throws CloudException {
        System.out.println(
                call.callCloud(new SystemServiceRequest())
        );
    }





}
