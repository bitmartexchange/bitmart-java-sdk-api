[![Logo](./logo.png)](https://bitmart.com)

BitMart-Java-SDK-API
=========================
[![maven](https://img.shields.io/maven-central/v/io.github.binance/binance-connector-java)](https://repo1.maven.org/maven2/io/github/binance/binance-connector-java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Java client for the [BitMart Cloud API](http://developer-pro.bitmart.com).


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


Usage
=========================
* An example of a spot trade API
* Replace it with your own API KEY
* Run

#### Spot API Example
```java
public class TestSpot {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";
    private static Call call;

    TestSpot(){
        CloudContext cloudContext = new CloudContext(new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);

        System.out.println(
               call.callCloud(new SystemServiceRequest())
        );
    }

}
```

#### Spot WebSocket Public Channel Example
```java
public class TestWebSocket {

    TestWebSocket() throws Exception{

        // 1.Connection
        WebSocketClient webSocketClient = new WebSocketClient(
                "wss://ws-manager-compress.bitmart.com/api?protocol=1.1", new ReceiveMessage());

        // 2. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                createChannel(WS_PUBLIC_SPOT_TICKER, "BTC_USDT"),
                createChannel(WS_PUBLIC_SPOT_DEPTH5, "BTC_USDT")

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

    TestWebSocket() throws Exception{

        // 1.Connection
        WebSocketClient webSocketClient = new WebSocketClient(
                "wss://ws-manager-compress.bitmart.com/user?protocol=1.1", new ReceiveMessage());

        // 2. login
        webSocketClient.login();

        Thread.sleep(2000L); // wait login

        // 3. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // private channel
                createChannel(WS_USER_SPOT_ORDER, "BTC_USDT")

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

#### Contract API Example
```java
public class TestContract {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";
    private static Call call;

    TestContract(){
        CloudContext cloudContext = new CloudContext(new CloudKey(API_KEY, API_SECRET, API_MEMO));
        call = new Call(cloudContext);

          System.out.println(
                  call.callCloud(new TickerRequest().setContract_symbol("ETHUSDT"))
                );
    }

}
```

#### Contract WebSocket Public Channel Example
```java
public class TestContractWebSocket {

  TestContractWebSocket() throws Exception{

        // 1.Connection
        ContractWebSocket webSocketClient = new ContractWebSocket(
                "wss://openapi-ws.bitmart.com/api?protocol=1.1", new ReceiveMessage());

        // 2. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                WS_PUBLIC_CONTRACT_TICKER,
                createChannel(WS_PUBLIC_CONTRACT_DEPTH5, "BTCUSDT"),

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

#### Contract WebSocket Private Channel Example
```java
public class TestContractWebSocket {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    TestContractWebSocket() throws Exception{

        // 1.Connection
        ContractWebSocket webSocketClient = new ContractWebSocket(
                "wss://openapi-ws.bitmart.com/user?protocol=1.1", new ReceiveMessage());

        // 2. login
        webSocketClient.login();

        Thread.sleep(2000L); // wait login

        // 3. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // private channel
                WS_USER_CONTRACT_POSITION,
                createChannel(WS_USER_CONTRACT_ASSET, "USDT")

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
