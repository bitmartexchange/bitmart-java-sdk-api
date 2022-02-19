package com.bitmart.websocket.spot;

public class WebSocketConstant {

    // spot public
    public static final String WS_PUBLIC_SPOT_TICKER = "spot/ticker";
    public static final String WS_PUBLIC_SPOT_TRADE = "spot/trade";
    public static final String WS_PUBLIC_SPOT_DEPTH5 = "spot/depth5";
    public static final String WS_PUBLIC_SPOT_DEPTH20 = "spot/depth20";
    public static final String WS_PUBLIC_SPOT_DEPTH50 = "spot/depth50";
    public static final String WS_PUBLIC_SPOT_KLINE_1M = "spot/kline1m";
    public static final String WS_PUBLIC_SPOT_KLINE_3M = "spot/kline3m";
    public static final String WS_PUBLIC_SPOT_KLINE_5M = "spot/kline5m";
    public static final String WS_PUBLIC_SPOT_KLINE_15M = "spot/kline15m";
    public static final String WS_PUBLIC_SPOT_KLINE_30M = "spot/kline30m";
    public static final String WS_PUBLIC_SPOT_KLINE_1H = "spot/kline1H";
    public static final String WS_PUBLIC_SPOT_KLINE_2H = "spot/kline2H";
    public static final String WS_PUBLIC_SPOT_KLINE_4H = "spot/kline4H";
    public static final String WS_PUBLIC_SPOT_KLINE_1D = "spot/kline1D";
    public static final String WS_PUBLIC_SPOT_KLINE_1W = "spot/kline1W";
    public static final String WS_PUBLIC_SPOT_KLINE_1MON = "spot/kline1M";

    // spot user private
    public static final String WS_USER_SPOT_ORDER = "spot/user/order";

    public static String createChannel(String channel, String symbol){
        return String.format("%s:%s", channel, symbol);
    }
    
}
