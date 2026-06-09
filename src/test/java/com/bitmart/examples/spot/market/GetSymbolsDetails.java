package com.bitmart.examples.spot.market;

import com.bitmart.examples.Example;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.SymbolsDetailsRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GetSymbolsDetails {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(Example.SPOT_HOST));

        try {
            // Get all trading pair details
            final CloudResponse cloudResponse = call.callCloud(new SymbolsDetailsRequest());
            System.out.println("All trading pair details: " + cloudResponse.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
