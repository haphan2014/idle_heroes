package com.heyzap.common.vast.util;

import android.util.Log;

public class VASTLog {
    private static LOG_LEVEL LEVEL = LOG_LEVEL.none;
    private static String TAG = "VAST";

    public enum LOG_LEVEL {
        verbose(1),
        debug(2),
        info(3),
        warning(4),
        error(5),
        none(6);
        
        private int value;

        private LOG_LEVEL(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void m787v(String tag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.verbose.getValue()) {
            Log.v(TAG, formatMessage(tag, msg));
        }
    }

    public static void m783d(String tag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.debug.getValue()) {
            Log.d(TAG, formatMessage(tag, msg));
        }
    }

    public static void m786i(String tag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.info.getValue()) {
            Log.i(TAG, formatMessage(tag, String.format("[%s] %s", new Object[]{tag, msg})));
        }
    }

    public static void m788w(String tag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.warning.getValue()) {
            Log.w(TAG, formatMessage(tag, msg));
        }
    }

    public static void m784e(String tag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.error.getValue()) {
            Log.e(TAG, formatMessage(tag, msg));
        }
    }

    public static void m785e(String tag, String msg, Throwable tr) {
        if (LEVEL.getValue() <= LOG_LEVEL.error.getValue()) {
            Log.e(TAG, formatMessage(tag, msg) + " e: " + tr.getMessage());
        }
    }

    public static void setLoggingLevel(LOG_LEVEL logLevel) {
        Log.i(TAG, String.format("[VASTLog] Changing logging level from: %s to: %s", new Object[]{LEVEL, logLevel}));
        LEVEL = logLevel;
    }

    public static LOG_LEVEL getLoggingLevel() {
        return LEVEL;
    }

    private static String formatMessage(String tag, String msg) {
        return String.format("[%s] %s", new Object[]{tag, msg});
    }
}
