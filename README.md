[![Logo](./logo.png)](https://bitmart.com)

BitMart-Java-SDK-API
=========================
<p align="left">
    <a href='#'><img src='https://travis-ci.org/meolu/walle-web.svg?branch=master' alt="Build Status"></a>  
</p>

Java client for the [BitMart Cloud API](http://developer-pro.bitmart.com).



Feature
=========================
- Provides exchange quick trading API
- Easier withdrawal
- Efficiency, higher speeds, and lower latencies
- Priority in development and maintenance
- Dedicated and responsive technical support
- Provide webSocket apis calls


Installation
=========================

* 1.JDK 1.8 support

* 2.Clone
```git
git clone git@github.com:bitmartexchange/bitmart-java-sdk-api.git
```



Usage
=========================
* An example of a spot trade API
* Replace it with your own API KEY
* Run

#### API Example
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

#### WebSocket Example
```java
public class TestWebSocket {

    private static String API_KEY = "YOUR ACCESS KEY";
    private static String API_SECRET = "YOUR SECRET KEY";
    private static String API_MEMO = "YOUR MEMO";

    TestWebSocket() throws Exception{

        // 1.Connection
        WebSocketClient webSocketClient = new WebSocketClient(
                new CloudKey(API_KEY, API_SECRET, API_MEMO), new ReceiveMessage());
        
        // 2. login
        webSocketClient.login();

        Thread.sleep(2000L); // wait login

        // 3. send subscribe message
        webSocketClient.subscribe(ImmutableList.of(

                // public channel
                createChannel(WS_PUBLIC_SPOT_TICKER, "BTC_USDT"),
                createChannel(WS_PUBLIC_SPOT_DEPTH5, "BTC_USDT"),

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

Release Notes
=========================

###### 2020-07-16 
- Interface Spot API `Cancel Order` update to v2 version that is `POST https://api-cloud.bitmart.com/spot/v2/cancel_order`
- UserAgent set "BitMart-Java-SDK/1.0.1"
                                                    
 
###### 2020-09-21
- Interface Spot API `/spot/v1/symbols/book` add `size` parameter, which represents the number of depths

License
=========================
