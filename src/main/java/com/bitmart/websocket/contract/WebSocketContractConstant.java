package com.bitmart.websocket.contract;

public class WebSocketContractConstant {

    // contract public
    public static final String WS_PUBLIC_CONTRACT_TICKER = "futures/ticker";
    public static final String WS_PUBLIC_CONTRACT_DEPTH5 = "futures/depth5";
    public static final String WS_PUBLIC_CONTRACT_DEPTH20 = "futures/depth20";
    public static final String WS_PUBLIC_CONTRACT_DEPTH50 = "futures/depth50";
    public static final String WS_PUBLIC_CONTRACT_KLINE_1M = "futures/klineBin1m";
    public static final String WS_PUBLIC_CONTRACT_KLINE_5M = "futures/klineBin5m";
    public static final String WS_PUBLIC_CONTRACT_KLINE_15M = "futures/klineBin15m";
    public static final String WS_PUBLIC_CONTRACT_KLINE_30M = "futures/klineBin30m";
    public static final String WS_PUBLIC_CONTRACT_KLINE_1H = "futures/klineBin1H";
    public static final String WS_PUBLIC_CONTRACT_KLINE_2H = "futures/klineBin2H";
    public static final String WS_PUBLIC_CONTRACT_KLINE_4H = "futures/klineBin4H";
    public static final String WS_PUBLIC_CONTRACT_KLINE_1D = "futures/klineBin1D";
    public static final String WS_PUBLIC_CONTRACT_KLINE_1W = "futures/klineBin1W";

    // contract user private
    public static final String WS_USER_CONTRACT_ASSET = "futures/asset";
    public static final String WS_USER_CONTRACT_POSITION = "futures/position";

    public static String createChannel(String channel, String symbol){
        return String.format("%s:%s", channel, symbol);
    }
    
}
