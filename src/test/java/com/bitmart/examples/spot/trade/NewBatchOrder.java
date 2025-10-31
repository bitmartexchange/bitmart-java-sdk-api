package com.bitmart.examples.spot.trade;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.BatchOrdersRequest;
import com.bitmart.api.request.spot.prv.OrderParams;
import com.bitmart.examples.Example;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.bitmart.api.common.GlobalConst.CLOUD_URL;

@Slf4j
public class NewBatchOrder {

    private static final String API_KEY = Example.YOUR_API_KEY;
    private static final String API_SECRET = Example.YOUR_API_SECRET;
    private static final String API_MEMO = Example.YOUR_API_MEMO;

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO)));

        try {
            // Create order parameters
            List<OrderParams> orderParams = new ArrayList<>();
            
            // First order
            OrderParams order1 = new OrderParams()
                    .setSide("buy")
                    .setType("limit")
                    .setClientOrderId("batch_order_1")
                    .setPrice("800")
                    .setSize("0.1")
                    .setStpMode("cancel_taker"); // cancel_taker
            orderParams.add(order1);
            
            // Second order
            OrderParams order2 = new OrderParams()
                    .setSide("sell")
                    .setType("limit")
                    .setClientOrderId("batch_order_2")
                    .setPrice("850")
                    .setSize("0.1")
                    .setStpMode("cancel_maker"); // cancel_maker
            orderParams.add(order2);

            final CloudResponse cloudResponse = call.callCloud(new BatchOrdersRequest()
                    .setSymbol("BTC_USDT")
                    .setOrderParams(orderParams)
                    .setRecvWindow(5000L));
            System.out.println(cloudResponse);

        } catch (CloudException e) {
            log.error("Error response: " + e.getMessage());
        }
    }
}
