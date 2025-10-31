package com.bitmart.examples.spot.trade;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.v4.V4QueryHistoryOrdersRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class QueryHistoryOrders {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            final CloudResponse cloudResponse = call.callCloud(new V4QueryHistoryOrdersRequest()
                    .setSymbol("BTC_USDT")
                    .setOrderMode("spot")
                    .setStartTime(System.currentTimeMillis() - 86400000L) // 1 day ago
                    .setEndTime(System.currentTimeMillis()) // now
                    .setLimit(100)
                    .setRecvWindow(5000L));
            
            System.out.println("Response: " + cloudResponse.getResponseContent());
            
            // The response now includes new fields for each order:
            // - stpMode: Self-trade prevention mode used in the order
            // - cancelSource: Reason for order cancellation (including new value "stp")
            
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
