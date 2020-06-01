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
```java
public class TestSpot {

    private static String API_KEY = "xxxx";
    private static String API_SECRET = "xxxxx";
    private static String API_MEMO = "xxxxxx";
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


License
=========================
