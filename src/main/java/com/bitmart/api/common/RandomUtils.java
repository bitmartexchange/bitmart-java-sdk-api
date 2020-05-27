package com.bitmart.api.common;

public final class RandomUtils {
    public RandomUtils() {
    }

    public static long genNonce() {
        return System.currentTimeMillis() / 1000;
    }
}
