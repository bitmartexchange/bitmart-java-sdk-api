package com.bitmart.examples.spot.trade;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.v4.V4AlgoCancelAllRequest;
import com.bitmart.api.request.spot.prv.v4.V4AlgoCancelOrderRequest;
import com.bitmart.api.request.spot.prv.v4.V4AlgoSubmitOrderRequest;
import com.bitmart.api.request.spot.prv.v4.V4QueryAlgoClientOrderRequest;
import com.bitmart.api.request.spot.prv.v4.V4QueryAlgoHistoryOrdersRequest;
import com.bitmart.api.request.spot.prv.v4.V4QueryAlgoOpenOrdersRequest;
import com.bitmart.api.request.spot.prv.v4.V4QueryAlgoOrderRequest;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

/**
 * Spot strategy (algo) order endpoints (V4): plan (trigger) and tp/sl orders.
 */
@Slf4j
public class AlgoOrder {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(
            new CloudContext(
                Example.SPOT_HOST,
                new CloudKey(API_KEY, API_SECRET, API_MEMO)
            )
        );

        try {
            // Submit a strategy order (trigger / tp_sl)
            CloudResponse cloudResponse = call.callCloud(
                new V4AlgoSubmitOrderRequest()
                    .setSymbol("BTC_USDT")
                    .setSide("buy")
                    .setType("trigger")
                    .setClientOrderId("def123123123")
                    .setTriggerPrice("30000")
                    .setTriggerType("limit")
                    .setPrice("29000")
                    .setSize("0.1")
            );
            System.out.println(cloudResponse.getResponseContent());

            // Cancel a strategy order
            cloudResponse = call.callCloud(
                new V4AlgoCancelOrderRequest()
                    .setSymbol("BTC_USDT")
                    .setOrderId("1234567890")
                    .setType("trigger")
            );
            System.out.println(cloudResponse.getResponseContent());

            // Cancel all strategy orders
            cloudResponse = call.callCloud(
                new V4AlgoCancelAllRequest()
                    .setSymbol("BTC_USDT")
                    .setType("trigger")
            );
            System.out.println(cloudResponse.getResponseContent());

            // Query a strategy order by orderId
            cloudResponse = call.callCloud(
                new V4QueryAlgoOrderRequest()
                    .setOrderId("1234567890")
                    .setQueryState("open")
                    .setRecvWindow(5000L)
            );
            System.out.println(cloudResponse.getResponseContent());

            // Query a strategy order by clientOrderId
            cloudResponse = call.callCloud(
                new V4QueryAlgoClientOrderRequest()
                    .setClientOrderId("def123123123")
                    .setQueryState("open")
                    .setRecvWindow(5000L)
            );
            System.out.println(cloudResponse.getResponseContent());

            // Query current strategy orders
            cloudResponse = call.callCloud(
                new V4QueryAlgoOpenOrdersRequest()
                    .setSymbol("BTC_USDT")
                    .setOrderMode("trigger")
                    .setLimit(10)
                    .setRecvWindow(5000L)
            );
            System.out.println(cloudResponse.getResponseContent());

            // Query history strategy orders
            cloudResponse = call.callCloud(
                new V4QueryAlgoHistoryOrdersRequest()
                    .setSymbol("BTC_USDT")
                    .setOrderMode("trigger")
                    .setLimit(10)
                    .setRecvWindow(5000L)
            );
            System.out.println(cloudResponse.getResponseContent());
        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
