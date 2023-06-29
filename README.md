[![Logo](./logo.png)](https://bitmart.com)

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
The latest version：1.0.0
```xml
<dependency>
    <groupId>io.github.bitmartexchange</groupId>
    <artifactId>bitmart-java-sdk-api</artifactId>
    <version>1.0.0</version>
</dependency>
```

Run `mvn install` where `pom.xml` is located to install the dependency.
[How do ues maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

Documentation
=========================
[API Documentation](https://developer-pro.bitmart.com/en/spot/#change-log)


Example
=========================
#### Spot Market API Example

```java
public class TestSpotMark {

    public static void main(String[] args) {
        Call call = new Call(new CloudContext(new CloudKey("", "", "")));
        
        // Get Currency List
        call.callCloud(new CurrenciesRequest());
        
        // Get List of Trading Pair Details
        call.callCloud(new SymbolsDetailsRequest());
        
        // Get Ticker of a Trading Pair
        call.callCloud(new TickerDetailRequest().setSymbol("BTC_USDT"));
    }

}
```

#### Spot Trade API Example
```java
public class TestSpot {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    public static void main(String[] args) {
        CloudContext cloudContext = new CloudContext(new CloudKey(API_KEY, API_SECRET, API_MEMO));
        Call call = new Call(cloudContext);

        CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                .setSide("sell")
                .setType("limit")
                .setSymbol("BTC_USDT")
                .setPrice("800000")
                .setSize("100"));

        System.out.println(cloudResponse);
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

* More Spot Websocket Example: [TestWebSocket.java](https://github.com/bitmartexchange/bitmart-java-sdk-api/blob/master/src/test/java/com/bitmart/api/TestWebSocket.java)


---

#### Futures API Example

```java
public class TestContract {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    public static void main(String[] args) {
        CloudContext cloudContext = new CloudContext(new CloudKey(API_KEY, API_SECRET, API_MEMO));
        Call call = new Call(cloudContext);

        final CloudResponse cloudResponse = call.callCloud(new SubmitOrderRequest()
                .setSymbol("ETHUSDT")
                .setType("limit")
                .setSide(4)
                .setLeverage("1")
                .setOpen_type("isolated")
                .setSize(1000)
                .setPrice("200000"));

        System.out.println(cloudResponse);
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
* More Futures Websocket Example: [TestContractWebSocket.java](https://github.com/bitmartexchange/bitmart-java-sdk-api/blob/master/src/test/java/com/bitmart/api/TestContractWebSocket.java)

## License
MIT