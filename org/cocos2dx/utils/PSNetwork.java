package org.cocos2dx.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import java.net.HttpURLConnection;
import java.net.URL;

public class PSNetwork {
    static ConnectivityManager mConnManager = null;

    public static void init(Context context) {
        mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean isLocalWiFiAvailable() {
        boolean z = true;
        if (mConnManager == null) {
            return false;
        }
        if (State.CONNECTED != mConnManager.getNetworkInfo(1).getState()) {
            z = false;
        }
        return z;
    }

    public static boolean isInternetConnectionAvailable() {
        boolean z = true;
        if (mConnManager == null) {
            return false;
        }
        if (isLocalWiFiAvailable()) {
            return true;
        }
        try {
            if (State.CONNECTED != mConnManager.getNetworkInfo(0).getState()) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isHostNameReachable(String hostName) {
        int counts = 0;
        if (hostName == null || hostName.length() <= 0) {
            return false;
        }
        while (counts < 3) {
            try {
                return ((HttpURLConnection) new URL(hostName).openConnection()).getResponseCode() == 200;
            } catch (Exception e) {
                counts++;
            }
        }
        return false;
    }

    public static int getInternetConnectionStatus() {
        if (isLocalWiFiAvailable()) {
            return 1;
        }
        if (isInternetConnectionAvailable()) {
            return 2;
        }
        return 0;
    }
}
