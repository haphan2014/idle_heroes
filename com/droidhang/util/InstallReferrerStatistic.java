package com.droidhang.util;

import android.content.Context;
import android.util.Log;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONException;
import org.json.JSONObject;

public class InstallReferrerStatistic {
    private static final String STATISTIC_URL = "http://games.droidhang.com/featuredgame/install_referrer.php";
    private static final String TAG = "CrossPromotion_Statistic";
    private static Context _context;
    private static SimpleHttpThread _httpThread;

    public static void init(Context context) {
        _context = context;
        _httpThread = new SimpleHttpThread();
        _httpThread.init();
    }

    private static String getPostJsonString(String referrer) {
        JSONObject json = new JSONObject();
        String result = json.toString();
        try {
            json.put("referrer", referrer);
            json.put(AppsFlyerProperties.APP_ID, _context.getPackageName());
            Log.d(TAG, "appid:" + _context.getPackageName());
            result = json.toString();
        } catch (JSONException e) {
        }
        return result;
    }

    public static void install(String referrer, Context context) {
        init(context);
        Log.d(TAG, "install, referrer = " + referrer);
        _httpThread.postAsyncRequest(STATISTIC_URL, getPostJsonString(referrer), null, false);
    }
}
