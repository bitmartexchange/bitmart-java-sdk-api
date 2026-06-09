package com.bitmart.examples.futures.market;

import com.bitmart.examples.Example;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.contract.pub.OpenInterestRequest;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class GetOpenInterest {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.FUTURES_HOST));

        try {
            // /contract/public/open-interest
            final CloudResponse cloudResponse = call.callCloud(new OpenInterestRequest()
                    .setSymbol("ETHUSDT")
            );
            System.out.println(cloudResponse.getResponseContent());
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
