[![Logo](https://img.bitmart.com/static-file/public/sdk/sdk_logo.png)](https://bitmart.com)

BitMart-Java-SDK-API
=========================
[![Maven Central](https://img.shields.io/maven-central/v/io.github.bitmartexchange/bitmart-java-sdk-api)](https://repo1.maven.org/maven2/io/github/bitmartexchange/bitmart-java-sdk-api/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Telegram](https://img.shields.io/badge/Telegram-Join%20Us-blue?logo=Telegram)](https://t.me/bitmart_api)


[BitMart Exchange](https://bitmart.com) official Java client for the BitMart Cloud API.


Feature
=========================
- Provides exchange quick trading API
- Easier withdrawal
- Efficiency, higher speeds, and lower latencies
- Priority in development and maintenance
- Dedicated and responsive technical support
- Supported APIs:
    - `/spot/*`
    - `/contract/*`
    - `/account/*`
- Supported websockets:
    - Spot WebSocket Market Stream
    - Spot User Data Stream
    - futures User Data Stream
    - futures WebSocket Market Stream
- Test cases and examples


Installation
=========================
Copy and paste the following dependency snippet into your `pom.xml` file, replacing `LATEST_VERSION` with the most [recent version](https://mvnrepository.com/artifact/io.github.bitmartexchange/bitmart-java-sdk-api) available:

```xml
<dependency>
    <groupId>io.github.bitmartexchange</groupId>
    <artifactId>bitmart-java-sdk-api</artifactId>
    <version>LATEST_VERSION</version>
</dependency>
```

Next, install the dependency by executing `mvn install` in the directory where your `pom.xml` is located.
[How do ues maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

Documentation
=========================
[API Documentation](https://developer-pro.bitmart.com/en/spot/#change-log)


Example
=========================
#### Spot Market API Example

```java
import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.spot.pub.market.*;

public class Market {

    public static void main(String[] args) throws CloudException {
        Call call = new Call(new CloudContext());

        // Get Ticker of a Trading Pair (V3)
        CloudResponse cloudResponse = call.callCloud(new V3TickerRequest().setSymbol("BTC_USDT"));
        System.out.println(cloudResponse.getResponseContent());

        // Get Ticker of All Pairs (V3)
        cloudResponse = call.callCloud(new V3TickersRequest());
        System.out.println(cloudResponse.getResponseContent());

        // Get Depth (V3)
        cloudResponse = call.callCloud(new V3DepthRequest().setSymbol("BTC_USDT").setLimit(10));
        System.out.println(cloudResponse.getResponseContent());

        // Get Latest K-Line (V3)
        cloudResponse = call.callCloud(new V3HistoryKlineRequest().setSymbol("BTC_USDT"));
        System.out.println(cloudResponse.getResponseContent());

        // Get History K-Line (V3)
        cloudResponse = call.callCloud(new V3LatestKlineRequest().setSymbol("BTC_USDT"));
        System.out.println(cloudResponse.getResponseContent());

        // Get Recent Trades (V3)
        cloudResponse = call.callCloud(new V3TradeRequest().setSymbol("BTC_USDT"));
        System.out.println(cloudResponse.getResponseContent());
    }
}
```

#### Spot Trade API Example

```java
import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.spot.prv.SubmitOrderRequest;

public class TestSpotTrading {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    public static void main(String[] args) {
        CloudContext cloudContext = new CloudContext(new CloudKey(API_KEY, API_SECRET, API_MEMO));
        Call call = new Call(cloudContext);
        try {
            CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                    .setSide("sell")
                    .setType("limit")
                    .setSymbol("BTC_USDT")
                    .setPrice("800000")
                    .setSize("100"));
            System.out.println(cloudResponse);

        } catch (CloudException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

}
```

* Please find [examples/spot](https://github.com/bitmartexchange/bitmart-java-sdk-api/tree/master/src/test/java/com/bitmart/examples/spot) folder to check for more endpoints.


---

#### Spot WebSocket Public Channel Example

```java
import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.ContractWebSocket;
import com.bitmart.websocket.OpParam;
import com.bitmart.websocket.WebSocketCallBack;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_WS_URL;

@Slf4j
public class Ticker {
    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }
    }

    public static void main(String[] args) {
        try {
            ContractWebSocket webSocketClient = new ContractWebSocket(CLOUD_WS_URL,
                    new CloudKey(), new ReceiveMessage());

            // Ticker Channel
            webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/ticker:BTC_USDT")));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }

    }
}

```

#### Spot WebSocket Private Channel Example

```java
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.OpParam;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.WebSocketClient;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BalanceChange {

    private static final String API_KEY = "your_api_key";
    private static final String API_SECRET = "your_secret_key";
    private static final String API_MEMO = "your_memo";

    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }

    public static void main(String[] args) {
        try {
            WebSocketClient webSocketClient = new WebSocketClient(GlobalConst.CLOUD_WS_PRIVATE_URL,
                    new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());

            // need login
            webSocketClient.login();

            // subscribe private channel
            webSocketClient.send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/user/balance:BALANCE_UPDATE")));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }

    }
}
```

* Please find [examples/spot/websocket](https://github.com/bitmartexchange/bitmart-java-sdk-api/tree/master/src/test/java/com/bitmart/examples/spot/websocket) folder to check for more endpoints.



---

#### Futures Market API Example

```java
import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.request.contract.pub.DepthRequest;
import com.bitmart.api.request.contract.pub.DetailsRequest;
import com.bitmart.api.request.contract.pub.FundingRateRequest;
import com.bitmart.api.request.contract.pub.OpenInterestRequest;
import com.bitmart.api.request.spot.pub.market.V3TradeRequest;

public class TestFuturesMarket {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext());

        // Get Contract Details
        CloudResponse cloudResponse = call.callCloud(new DetailsRequest().setSymbol("ETHUSDT"));
        System.out.println(cloudResponse.getResponseContent());

        // Get Market Depth
        cloudResponse = call.callCloud(new DepthRequest().setSymbol("ETHUSDT"));
        System.out.println(cloudResponse.getResponseContent());

        // Get Futures Open Interest
        cloudResponse = call.callCloud(new OpenInterestRequest().setSymbol("ETHUSDT"));
        System.out.println(cloudResponse.getResponseContent());

        // Get Current Funding Rate
        cloudResponse = call.callCloud(new FundingRateRequest().setSymbol("ETHUSDT"));
        System.out.println(cloudResponse.getResponseContent());

        // Get Recent Trades (V3)
        cloudResponse = call.callCloud(new V3TradeRequest().setSymbol("BTC_USDT"));
        System.out.println(cloudResponse.getResponseContent());
    }

}
```

#### Futures Trade API Example

```java
import com.bitmart.api.Call;
import com.bitmart.api.CloudContext;
import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CloudResponse;
import com.bitmart.api.key.CloudKey;
import com.bitmart.api.request.contract.prv.SubmitOrderRequest;

public class TestFuturesTrading {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    public static void main(String[] args) {
        CloudContext cloudContext = new CloudContext(new CloudKey(API_KEY, API_SECRET, API_MEMO));
        Call call = new Call(cloudContext);

        try {
            CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                    .setSymbol("ETHUSDT")
                    .setType("limit")
                    .setSide(4)
                    .setLeverage("1")
                    .setOpenType("isolated")
                    .setSize(1000)
                    .setPrice("200000"));
            System.out.println(cloudResponse);

        } catch (CloudException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

}
```

* Please find [examples/futures](https://github.com/bitmartexchange/bitmart-java-sdk-api/tree/master/src/test/java/com/bitmart/examples/futures) folder to check for more endpoints.


---

#### Futures WebSocket Public Channel Example

```java

import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.ContractWebSocket;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.contract.ActionParam;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_CONTRACT_WS_URL;

@Slf4j
public class Ticker {

    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }
    public static void main(String[] args) {
        try {
            ContractWebSocket webSocketClient = new ContractWebSocket(CLOUD_CONTRACT_WS_URL,
                    new CloudKey(), new ReceiveMessage());

            // Ticker Channel
            webSocketClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/ticker")));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }

    }
}
```

#### Futures WebSocket Private Channel Example

```java

import com.bitmart.api.common.CloudException;
import com.bitmart.api.key.CloudKey;
import com.bitmart.websocket.ContractWebSocket;
import com.bitmart.websocket.WebSocketCallBack;
import com.bitmart.websocket.contract.ActionParam;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import static com.bitmart.api.common.GlobalConst.CLOUD_CONTRACT_WS_PRIVATE_URL;

@Slf4j
public class Assets {

    private static final String API_KEY = "your_api_key";
    private static final String API_SECRET = "your_secret_key";
    private static final String API_MEMO = "your_memo";

    public static class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            log.info("onMessage------>{}", text);
        }

    }
    public static void main(String[] args) {
        try {
            ContractWebSocket webSocketPrivateClient = new ContractWebSocket(CLOUD_CONTRACT_WS_PRIVATE_URL,
                    new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());

            // login
            webSocketPrivateClient.login();

            // subscribe private channel
            webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/asset:USDT")));
            webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/position")));
            webSocketPrivateClient.send(new ActionParam().setAction("subscribe").setArgs(ImmutableList.of("futures/order")));

        } catch (CloudException e) {
            log.error("CloudException: {}", e.getMessage());
        }

    }
}

```

* Please find [examples/futures/websocket](https://github.com/bitmartexchange/bitmart-java-sdk-api/tree/master/src/test/java/com/bitmart/examples/futures/websocket) folder to check for more endpoints.



### Logging
This SDK uses [`SLF4J`](https://www.slf4j.org/) as an abstraction layer for diverse logging frameworks.

It's end-user's responsibility to select the appropriate `SLF4J` binding to use as the logger (e.g, `logback-classic`).
Otherwise, you might see the following informative output:

```shell
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

If you prefer to not use a logger and suppress the `SLF4J` messages instead, you can refer to `slf4j-nop`.

#### Here is an example using logback-classic

Taking Maven project as an example, 
you should introduce the log package in the `pom.xml` file, as follows:

```xml
 <dependency>
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-classic</artifactId>
  <version>1.2.11</version>
</dependency>
```

Then add `logback.xml` to your project `resource directory`, after completion you will not encounter SLF4J prompt output.


```xml
<configuration>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="STDOUT" />
    </root>

</configuration>
```



### Timeout
After initializing the CloudContext, you can set the OkHttpClient timeout.

* Connect Timeout: A connect timeout defines a time period in which our client should establish a connection with a target host.
* Read Timeout: A read timeout is applied from the moment the connection between a client and a target host has been successfully established.
* Write Timeout: A write timeout defines a maximum time of inactivity between two data packets when sending the request to the server.


In SDK, if you do not set it, its value will use the default value. The default setting of `Connect Timeout` and `Write Timeout` is 2 second,
and the default setting of `Read Timeout` is 10 second.


```java
CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
cloudContext.setReadTimeoutMilliSeconds(10000); // 10 second
cloudContext.setWriteTimeoutMilliSeconds(2000); // 2 second
cloudContext.setConnectTimeoutMilliSeconds(2000); // 2 second
call = new Call(cloudContext);
```


### Debug
If you want to print the request and response information, you can set it to true.

```java
CloudContext cloudContext = new CloudContext(CLOUD_URL, new CloudKey(API_KEY, API_SECRET, API_MEMO));
cloudContext.setDebug(true);
call = new Call(cloudContext);
```

### Custom request headers
You can add your own request header information here, but please do not fill in `X-BM-KEY, X-BM-SIGN, X-BM-TIMESTAMP`.
This request header will be carried in each request.

```java
 // Set your custom headers
Map<String, String> customHeaders = new HashMap<>();
customHeaders.put("Your-Custom-Header", "Your_Value");
cloudContext.setCustomHeaders(customHeaders);
call = new Call(cloudContext);
```


### Add new endpoint
If the interface you need is not in the SDK, you can add it yourself. Create a new class, inherit `CloudRequest`, and implement the `CloudRequest` interface.
The field definitions in the class are the requested parameters, and the field names must be consistent with the parameter names in the interface document. 
If it is inconsistent, you can use the annotation `@ParamKey` to specify it.

```java
import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class NewPointRequest extends CloudRequest {

    @ParamKey(value = "symbol", required = true)
    private String symbol;

    @ParamKey("limit")
    private Integer limit;

    // param1: api path 
    // param2: api method
    // param3: api auth (NONE,KEYED, SIGNED)
    public NewPointRequest() {
        super("/xxx/xxx", Method.GET, Auth.NONE);
    }

}

```

###### After the definition is complete, it can be used as follows:

```java
public class TestSpotMark {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext());

        // Call and get response
        CloudResponse cloudResponse = call.callCloud(new NewPointRequest().setSymbol("BTCUSD").setLimit(100));
    }
}
```


###### Output: CloudResponse Description
* responseContent: the server original data returned
* responseHttpStatus: returned http status code
* cloudLimit: limit on the number of interface calls

```output
INFO: CloudResponse(responseContent={"code":1000,"message":"success","data":{...},"trace":"b731916b11234da281d888d1f19c8d6c.53.16933945763822873"}, responseHttpStatus=200, cloudLimit=CloudLimit(remaining=1, limit=15, reset=2)
```


