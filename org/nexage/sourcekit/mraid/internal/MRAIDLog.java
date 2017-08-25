package org.nexage.sourcekit.mraid.internal;

import android.util.Log;

public class MRAIDLog {
    private static LOG_LEVEL LEVEL = LOG_LEVEL.warning;
    private static final String TAG = "MRAID";

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

    public static void m2729d(String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.debug.getValue()) {
            Log.d(TAG, msg);
        }
    }

    public static void m2731e(String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.error.getValue()) {
            Log.e(TAG, msg);
        }
    }

    public static void m2733i(String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.info.getValue()) {
            Log.i(TAG, msg);
        }
    }

    public static void m2735v(String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.verbose.getValue()) {
            Log.v(TAG, msg);
        }
    }

    public static void m2737w(String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.warning.getValue()) {
            Log.w(TAG, msg);
        }
    }

    public static void m2730d(String subTag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.debug.getValue()) {
            Log.d(TAG, "[" + subTag + "] " + msg);
        }
    }

    public static void m2732e(String subTag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.error.getValue()) {
            Log.e(TAG, "[" + subTag + "] " + msg);
        }
    }

    public static void m2734i(String subTag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.info.getValue()) {
            Log.i(TAG, "[" + subTag + "] " + msg);
        }
    }

    public static void m2736v(String subTag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.verbose.getValue()) {
            Log.v(TAG, "[" + subTag + "] " + msg);
        }
    }

    public static void m2738w(String subTag, String msg) {
        if (LEVEL.getValue() <= LOG_LEVEL.warning.getValue()) {
            Log.w(TAG, "[" + subTag + "] " + msg);
        }
    }

    public static void setLoggingLevel(LOG_LEVEL logLevel) {
        Log.i(TAG, "Changing logging level from :" + LEVEL + ". To:" + logLevel);
        LEVEL = logLevel;
    }

    public static LOG_LEVEL getLoggingLevel() {
        return LEVEL;
    }
}
