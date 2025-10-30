package com.bitmart.examples.futures.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.contract.pub.LeverageBracketRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_V2_URL;

@Slf4j
public class GetLeverageBracket {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_V2_URL));

        try {
            // Get leverage bracket for all
            final CloudResponse cloudResponse = call.callCloud(new LeverageBracketRequest());
            System.out.println(cloudResponse.getResponseContent());
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }


        try {
            // Get leverage bracket for specific symbol
            final CloudResponse cloudResponse = call.callCloud(new LeverageBracketRequest().setSymbol("BTCUSDT"));
            System.out.println(cloudResponse.getResponseContent());
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
