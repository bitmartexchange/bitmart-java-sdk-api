package com.bitmart.examples.spot.market;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.market.V3TradeRequest;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class GetV3Trades {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL));

        try {
            // Get recent trades for BTC_USDT
            final CloudResponse cloudResponse = call.callCloud(new V3TradeRequest()
                    .setSymbol("BTC_USDT")
                    .setLimit(2));
            System.out.println("BTC_USDT recent trades: " + cloudResponse.getResponseContent());

            // Get recent trades for ETH_USDT
            final CloudResponse cloudResponse2 = call.callCloud(new V3TradeRequest()
                    .setSymbol("ETH_USDT")
                    .setLimit(5));
            System.out.println("ETH_USDT recent trades: " + cloudResponse2.getResponseContent());

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
