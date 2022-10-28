package com.bitmart.websocket.contract;

public abstract class WebSocketCallBack {
    /** Invoked when a text (type {@code 0x1}) message has been received. */
    public abstract void onMessage(String text);

}
