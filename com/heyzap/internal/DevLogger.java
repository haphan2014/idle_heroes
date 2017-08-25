package com.heyzap.internal;

import android.util.Log;

public class DevLogger {
    public static final String TAG = "Heyzap";

    public static void info(String msg) {
        Log.i("Heyzap", msg);
    }

    public static void warn(String msg) {
        Log.w("Heyzap", msg);
    }

    public static void warn(Throwable e, String msg) {
        Log.w("Heyzap", msg, e);
    }

    public static void error(String msg) {
        Log.e("Heyzap", msg);
    }

    public static void error(Throwable e, String msg) {
        Log.e("Heyzap", msg, e);
    }

    public static void debug(String msg) {
        Log.d("Heyzap", msg);
    }
}
