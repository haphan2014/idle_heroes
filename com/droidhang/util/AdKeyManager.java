package com.droidhang.util;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Log;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class AdKeyManager {
    private static String _advertisingId = "";
    private static String _appsFlyerId = "";

    public static void init(final Activity activity) {
        _appsFlyerId = AppsFlyerLib.getInstance().getAppsFlyerUID(activity);
        new Thread(new Runnable() {
            public void run() {
                AdKeyManager.getAdIdThread(activity);
            }
        }).start();
    }

    public static String getAppsFlyerId() {
        return _appsFlyerId;
    }

    public static String getOSVersion() {
        return VERSION.RELEASE;
    }

    public static String getAdvertisingId() {
        return _advertisingId;
    }

    private static void getAdIdThread(Activity activity) {
        try {
            _advertisingId = AdvertisingIdClient.getAdvertisingIdInfo(activity).getId();
            Log.e("dh", "_advertisingId=" + _advertisingId);
        } catch (Exception e) {
            Log.e("dh", "Exception=" + e.getMessage());
        }
    }
}
