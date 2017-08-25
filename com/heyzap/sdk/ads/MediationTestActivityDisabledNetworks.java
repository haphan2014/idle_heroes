package com.heyzap.sdk.ads;

import android.content.Context;
import android.content.SharedPreferences;

public class MediationTestActivityDisabledNetworks {
    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("mediation_test_activity_disabled_networks", 0);
    }

    public static void disableNetwork(Context context, String canonicalName, boolean isDisabled) {
        getPrefs(context).edit().putBoolean(canonicalName, isDisabled).commit();
    }

    public static boolean isNetworkDisabled(Context context, String canonicalName) {
        return getPrefs(context).getBoolean(canonicalName, false);
    }
}
