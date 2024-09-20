[![Logo](https://img.bitmart.com/static-file/public/sdk/sdk_logo.png)](https://bitmart.com)

BitMart-Java-SDK-API
=========================
[![Maven Central](https://img.shields.io/maven-central/v/io.github.bitmartexchange/bitmart-java-sdk-api)](https://repo1.maven.org/maven2/io/github/bitmartexchange/bitmart-java-sdk-api/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


[BitMart Exchange](https://bitmart.com) official Java client for the BitMart Cloud API.


Feature
=========================
- Provides exchange quick trading API
- Easier withdrawal
- Efficiency, higher speeds, and lower latencies
- Priority in development and maintenance
- Dedicated and responsive technical support
- Provide webSocket apis calls
- Supported APIs:
    - `/spot/*`
    - `/contract/*`
    - `/account/*`
    - Spot WebSocket Market Stream
    - Spot User Data Stream
    - Contract User Data Stream
    - Contract WebSocket Market Stream
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
        cloudResponse =call.callCloud(new V3TickersRequest());
        System.out.println(cloudResponse.getResponseContent());

        // Get Depth (V3)
        cloudResponse =call.callCloud(new V3DepthRequest().setSymbol("BTC_USDT").setLimit(10));
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

* More Spot API Example: [TestSpot.java](https://github.com/bitmartexchange/bitmart-java-sdk-api/blob/master/src/test/java/com/bitmart/api/TestSpot.java)

---

#### Spot WebSocket Public Channel Example
```java
public class TestWebSocket {

    public static void main(String[] args) throws Exception {

        // 1.Connection
        WebSocketClient webSocketClient = new WebSocketClient(
                "wss://ws-manager-compress.bitmart.com/api?protocol=1.1", new ReceiveMessage());

        // 2. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                "spot/ticker:BTC_USDT",
                "spot/kline1m:BTC_USDT",
                "spot/depth5:BTC_USDT",
                "spot/trade:BTC_USDT"
        ));

    }

    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println(text);
        }

    }
}

```

#### Spot WebSocket Private Channel Example
```java
public class TestWebSocket {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    public static void main(String[] args) throws Exception {

        // 1.Connection
        WebSocketClient webSocketClient = new WebSocketClient(
                "wss://ws-manager-compress.bitmart.com/user?protocol=1.1", new ReceiveMessage());

        // 2. login
        webSocketClient.login();

        Thread.sleep(2000L); // wait login

        // 3. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // private channel
                "spot/user/order:BTC_USDT"
        ));

    }

    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println(text);
        }

    }
}

```

* More Spot Websocket Example: [TestWebSocket.java](https://github.com/bitmartexchange/bitmart-java-sdk-api/blob/master/src/test/java/com/bitmart/websocket/TestSpotWebSocket.java)



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

#### Futures API Example

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

* More Futures API Example: [TestContract.java](https://github.com/bitmartexchange/bitmart-java-sdk-api/blob/master/src/test/java/com/bitmart/api/TestContract.java)

---

#### Futures WebSocket Public Channel Example

```java
public class TestContractWebSocket {

    public static void main(String[] args) throws Exception {

        // 1.Connection
        ContractWebSocket webSocketClient = new ContractWebSocket(
                "wss://openapi-ws.bitmart.com/api?protocol=1.1", new ReceiveMessage());

        // 2. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                "futures/ticker:BTCUSDT",
                "futures/depth20:BTCUSDT",
                "futures/trade:BTCUSDT",
                "futures/klineBin1m:BTCUSDT"
        ));

    }

    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println(text);
        }

    }
}

```

#### Futures WebSocket Private Channel Example

```java
public class TestContractWebSocket {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    public static void main(String[] args) throws Exception {

        // 1.Connection
        ContractWebSocket webSocketClient = new ContractWebSocket(
                "wss://openapi-ws.bitmart.com/user?protocol=1.1", new ReceiveMessage());

        // 2. login
        webSocketClient.login();

        Thread.sleep(2000L); // wait login

        // 3. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // private channel
                "futures/asset:BTC",
                "futures/position",
                "futures/order"
        ));

    }

    public class ReceiveMessage extends WebSocketCallBack {
        @Override
        public void onMessage(String text) {
            System.out.println(text);
        }

    }
}

```
* More Futures Websocket Example: [TestContractWebSocket.java](https://github.com/bitmartexchange/bitmart-java-sdk-api/blob/master/src/test/java/com/bitmart/websocket/TestFuturesWebSocket.java)


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


