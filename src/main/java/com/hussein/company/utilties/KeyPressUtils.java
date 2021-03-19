package com.hussein.company.utilties;

import java.util.HashMap;
import java.util.Map;

public class KeyPressUtils {
    private static final long DOUBLE_CLICK_THRESHOLD_IN_MILLIS = 300;
    private static final Map<Integer, Long> lastTimePressedInMillisKeyMap = new HashMap<>();

    public static boolean isDoublePressed(int keyCode) {
        if (!lastTimePressedInMillisKeyMap.containsKey(keyCode)) {
            lastTimePressedInMillisKeyMap.put(keyCode, System.currentTimeMillis());
        } else {
            long lastPressedTimeInMillis = lastTimePressedInMillisKeyMap.get(keyCode);
            long currentTimeInMillis = System.currentTimeMillis();
            if (currentTimeInMillis - lastPressedTimeInMillis < DOUBLE_CLICK_THRESHOLD_IN_MILLIS) {
                return true;
            } else {
                lastTimePressedInMillisKeyMap.put(keyCode, currentTimeInMillis);
            }

        }
        return false;
    }

    public static void clearMapContent() {
        lastTimePressedInMillisKeyMap.clear();
    }
}
