package com.bitmart.api.contract.prv;

import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.contract.prv.*;
import com.bitmart.api.request.contract.pub.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class TestContract {

    private static String CLOUD_URL =  "http://localhost:8080";;
    private static String API_KEY = "80618e45710812162b04892c7ee5ead4a3cc3e56";
    private static String API_SECRET = "6c6c98544461bbe71db2bca4c6d7fd0021e0ba9efc215f9c6ad41852df9d9df9";
    private static String API_MEMO = "test001";
    private static Call call;

    TestContract(){
        CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);

    }

    // ------------------  public -------------------------

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/contracts")
    void contracts() throws CloudException {
        System.out.println(
            call.callCloud(new ContractsRequest().setContractId(1))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/pnls")
    void pnls() throws CloudException {
        System.out.println(
                call.callCloud(new PnlsRequest().setContractId(1))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/indexes")
    void indexes() throws CloudException {
        System.out.println(
                call.callCloud(new IndexesRequest())
        );
    }


    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/tickers")
    void tickers() throws CloudException {
        System.out.println(
                call.callCloud(new TickersRequest().setContractId(1))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/quote")
    void quote() throws CloudException {
        System.out.println(
                call.callCloud(new QuoteRequest()
                        .setContractId(1)
                        .setStartTime(1584343602L)
                        .setEndTime(1586643602L)
                        .setUnit(5)
                        .setResolution("M")
                )
        );
    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/indexquote")
    void indexQuote() throws CloudException {
        System.out.println(
                call.callCloud(new IndexQuoteRequest()
                        .setIndexId(1)
                        .setStartTime(1586721942L)
                        .setEndTime(1589313942L)
                        .setUnit(1)
                        .setResolution("H")
                )
        );
    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/trades")
    void trades() throws CloudException {
        System.out.println(
                call.callCloud(new TradesRequest()
                        .setContractId(1)
                )
        );
    }


    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/depth")
    void depth() throws CloudException {
        System.out.println(
                call.callCloud(new DepthRequest()
                        .setContractId(1)
                        .setCount(10)
                )
        );
    }

    // -------------- prv

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/fundingrate")
    void fundingrate() throws CloudException {
        System.out.println(
                call.callCloud(new FundingRateRequest()
                        .setContractId(1)
                )
        );
    }






    // ------------------  private -------------------------


    @Test
    @DisplayName("Test. POST /contract/v1/ifcontract/submitOrder")
    void submitOrder() throws CloudException {
        System.out.println(
            call.callCloud(new SubmitOrderRequest()
                .setContractId(1)
                .setCategory(1)
                .setOpenType(1)
                .setWay(1)
                .setLeverage(50)
                .setCustomId(10)
                .setPrice(BigDecimal.valueOf(8885).toPlainString())
                .setVol(BigDecimal.valueOf(10).toPlainString())) // System.currentTimeMillis() / 1000))
        );
    }

    @Test
    @DisplayName("Test. POST /contract/v1/ifcontract/batchOrders")
    void batchOrders() throws CloudException {
        SubmitOrderRequest submitOrderRequest = new SubmitOrderRequest()
                .setContractId(1)
                .setCategory(1)
                .setOpenType(1).setWay(1)
                .setCustomId(1)
                .setLeverage(10)
                .setPrice(BigDecimal.valueOf(5000).toPlainString())
                .setVol(BigDecimal.valueOf(10).toPlainString());
        System.out.println(
                call.callCloud(new BatchOrdersRequest()
                        .setOrders(new ArrayList<SubmitOrderRequest>() {{
                            add(submitOrderRequest);
                            add(submitOrderRequest);
                        }}))
        );
        // {"message":"OK","data":{"orders":[{"custom_id":1,"order_id":2802671644},{"custom_id":1,"order_id":2802671645}]}}
    }


    @Test
    @DisplayName("Test. POST /contract/v1/ifcontract/cancelOrders")
    void cancelOrders() throws CloudException {
        List<Long> orderIds = new ArrayList<Long>() {{
            add(2802671644L);
            add(2802671645L);
        }};

        System.out.println(
            call.callCloud(new CancelOrdersRequest()
                    .setOrders(new ArrayList<CancelOrdersRequest.Orders>() {{
                        add(new CancelOrdersRequest.Orders().setContract_id(1).setOrders(orderIds));
                        add(new CancelOrdersRequest.Orders().setContract_id(2).setOrders(orderIds));
                    }}))
        );

    }


    private static final Long orderId = 2802614433L;
    // {"message":"OK","data":{"order_id":2802614433}}

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/userOrders")
    void userOrders() throws CloudException {
        System.out.println(
            call.callCloud(new UserOrdersRequest()
                .setContractId(1)
                .setStatus(0))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/userOrderInfo")
    void userOrderInfo() throws CloudException {
        System.out.println(
            call.callCloud(new UserOrderInfoRequest()
                .setContractId(1)
                .setOrderId(orderId))
        );
    }


    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/userTrades")
    void userTrades() throws CloudException {
        System.out.println(
            call.callCloud(new UserTradesRequest()
                .setContractId(1))
        );
    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/orderTrades")
    void orderTrades() throws CloudException {
        System.out.println(
                call.callCloud(new OrderTradesRequest()
                        .setContractId(1)
                        .setOrderID(orderId)
                )
        );
    }



    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/userPositions")
    void userPositions() throws CloudException {
        System.out.println(
                call.callCloud(new UserPositionsRequest().setContractId(1))
        );

    }

    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/accounts")
    void accounts() throws CloudException {
        System.out.println(
                call.callCloud(new AccountsRequest().setCoinCode("USDT"))
        );
    }



    @Test
    @DisplayName("Test. POST /contract/v1/ifcontract/marginOper")
    void marginOper() throws CloudException {
        call.callCloud(new MarginOperRequest()
                .setContractId(1)
                .setPositionId(2802613453L)
                .setOperType(1)
                .setVol(10));
    }


    @Test
    @DisplayName("Test. GET /contract/v1/ifcontract/userLiqRecords")
    void userLiqRecords() throws CloudException {
        call.callCloud(new UserLiqRecordsRequest()
                .setContractId(1)
                .setOrderID(2727478575L));
    }




}
