package com.appsflyer;

import android.util.Log;

class C0188a {
    public static final String LOG_TAG = ("AppsFlyer_" + AppsFlyerLib.SERVER_BUILD_NUMBER + "." + AppsFlyerLib.SDK_BUILD_NUMBER);

    public static void afLog(String logMessage) {
        if (C0188a.shouldLog()) {
            Log.i(LOG_TAG, logMessage);
        }
    }

    public static void afDebugLog(String logMessage) {
        if (C0188a.shouldLog()) {
            Log.d(LOG_TAG, logMessage);
        }
    }

    public static void afLogE(String message, Throwable ex) {
        if (C0188a.shouldLog()) {
            Log.e(LOG_TAG, message, ex);
        }
    }

    public static void afWarnLog(String warnMessage) {
        if (C0188a.shouldLog()) {
            Log.w(LOG_TAG, warnMessage);
        }
    }

    private static boolean shouldLog() {
        return AppsFlyerProperties.getInstance().isEnableLog();
    }

    public static void afLogM(String logMessage) {
        if (!C0188a.noLogsAllowed()) {
            Log.d(LOG_TAG, logMessage);
        }
    }

    private static boolean noLogsAllowed() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }
}
