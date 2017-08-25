package com.heyzap.house.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.games.Games;
import com.heyzap.common.net.APIClient;
import com.heyzap.house.Manager;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.model.AdModel;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Preconditions;
import com.heyzap.internal.Utils;
import java.util.ArrayList;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.json.JSONObject;

public class AttributionHandler {
    private static volatile AttributionHandler ref;

    public void didImpression(Context context, AdModel ad) {
        try {
            String prefKey = "impression." + ad.getGamePackage();
            Editor editor = context.getSharedPreferences(Constants.PREFERENCES_KEY, 0).edit();
            editor.putString(prefKey, ad.getImpressionId());
            editor.commit();
        } catch (Throwable e) {
            Logger.trace(e);
        }
    }

    public void didInstall(final Context context, final ArrayList<String> impressionIds, final Boolean rejected) {
        RequestParams reqParameters = new RequestParams();
        if (Utils.isAmazon()) {
            reqParameters.put("platform", "amazon");
        } else {
            reqParameters.put("platform", "android");
        }
        if (rejected.booleanValue()) {
            reqParameters.put("install_type", "rejected");
        }
        reqParameters.put(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY, TextUtils.join(",", impressionIds.toArray()));
        APIClient.post(context, Manager.AD_SERVER + "/event/install", reqParameters, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    if (response.optInt(Games.EXTRA_STATUS, 0) == 200 && !rejected.booleanValue()) {
                        SharedPreferences prefs = context.getSharedPreferences(Constants.PREFERENCES_KEY, 0);
                        Editor editor = prefs.edit();
                        for (Entry<String, ?> entry : prefs.getAll().entrySet()) {
                            if (((String) entry.getKey()).startsWith("impression") && impressionIds.contains(entry.getValue())) {
                                Logger.format("(INSTALL) %s (%s)", entry.getValue(), entry.getKey());
                                editor.remove((String) entry.getKey());
                            }
                        }
                        editor.commit();
                    }
                } catch (Throwable e) {
                    Logger.trace(e);
                }
            }

            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject e) {
                Logger.error("Could not record package install!", throwable);
            }
        });
    }

    public void didInstall(Context context, String packageName) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(packageName);
            try {
                String existingImpressionId = context.getSharedPreferences(Constants.PREFERENCES_KEY, 0).getString(String.format("impression.%s", new Object[]{packageName}), null);
                if (existingImpressionId != null) {
                    ArrayList<String> impressionIds = new ArrayList();
                    impressionIds.add(existingImpressionId);
                    didInstall(context, impressionIds, Boolean.valueOf(false));
                }
            } catch (Exception e) {
                Logger.error("Problem registering app install!", e);
            }
        } catch (NullPointerException e2) {
            Logger.error("Invalid context or package name for install!", e2);
        }
    }

    public void doSelfInstallOnce(Context context) {
        boolean firstRun = false;
        SharedPreferences prefs = context.getSharedPreferences(Constants.PREFERENCES_KEY, 0);
        Editor editor = prefs.edit();
        if (!prefs.getBoolean("ran_once", false)) {
            firstRun = true;
        }
        if (firstRun) {
            Logger.log("Doing self install");
            doSelfInstall(context);
            editor.putBoolean("ran_once", true);
            editor.commit();
        }
    }

    public void doSelfInstall(Context context) {
        if (context != null) {
            RequestParams reqParameters = new RequestParams();
            if (Utils.isAmazon()) {
                reqParameters.put("platform", "amazon");
            } else {
                reqParameters.put("platform", "android");
            }
            final String packageName = Utils.getPackageName(context);
            reqParameters.put("for_game_package", packageName);
            APIClient.post(context, Manager.AD_SERVER + "/register_new_game_install", reqParameters, new JsonHttpResponseHandler() {
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    try {
                        if (response.optInt(Games.EXTRA_STATUS, 0) == 200) {
                            Logger.log("(SELF INSTALL) Package: " + packageName);
                        }
                    } catch (Throwable e) {
                        Logger.trace(e);
                    }
                }
            });
        }
    }

    public static synchronized AttributionHandler getInstance() {
        AttributionHandler attributionHandler;
        synchronized (AttributionHandler.class) {
            if (ref == null) {
                ref = new AttributionHandler();
            }
            attributionHandler = ref;
        }
        return attributionHandler;
    }

    public Object clone() {
        return null;
    }
}
