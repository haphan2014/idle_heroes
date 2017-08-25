package com.heyzap.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.util.Base64;
import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.net.APIClient;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.http.RequestParams;
import java.util.HashSet;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class PackageManager {
    private static final String BASE_URL = ("https://" + APIClient.DOMAIN + "/in_game_api/ads/");
    private static final String LAST_CHECK_KEY = "last_checked_packages";
    private static final Integer MILLIS_BETWEEN_CHECKS = Integer.valueOf(86400000);

    public static void checkInstalledPackages(final Context context) {
        ExecutorPool.getInstance().execute(new Runnable() {
            public void run() {
                String url;
                if (Utils.isAmazon()) {
                    url = PackageManager.BASE_URL + "gtc/amazon.json";
                } else {
                    url = PackageManager.BASE_URL + "gtc/android.json";
                }
                final SharedPreferences prefs = context.getSharedPreferences(Constants.PREFERENCES_KEY, 0);
                long lastCheck = prefs.getLong(PackageManager.LAST_CHECK_KEY, 0);
                long now = System.currentTimeMillis();
                boolean debug = Utils.isDebug(context).booleanValue();
                if (debug || Utils.isExpired(Long.valueOf(lastCheck), PackageManager.MILLIS_BETWEEN_CHECKS).booleanValue()) {
                    if (debug && (context instanceof Activity)) {
                        Activity activ = context;
                    }
                    APIClient.get(context, url, new RequestParams(), new JsonHttpResponseHandler() {

                        class C13881 extends JsonHttpResponseHandler {
                            C13881() {
                            }

                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            }
                        }

                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                String pVersion = response.optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                List<PackageInfo> pInfos = context.getPackageManager().getInstalledPackages(0);
                                HashSet<String> pInstalled = new HashSet();
                                for (PackageInfo pInfo : pInfos) {
                                    pInstalled.add(pInfo.packageName);
                                }
                                JSONArray pToCheck = response.optJSONArray("packages");
                                boolean any = false;
                                int count = 0;
                                if (pToCheck != null) {
                                    int pToCheckLength = pToCheck.length();
                                    byte[] bits = new byte[((pToCheck.length() + 7) / 8)];
                                    for (int i = 0; i < pToCheck.length(); i++) {
                                        if (pInstalled.contains(pToCheck.getString(i))) {
                                            int i2 = i / 8;
                                            bits[i2] = (byte) (bits[i2] | (1 << (i % 8)));
                                            any = true;
                                            count++;
                                        }
                                    }
                                    int installedCount = count;
                                    int totalCount = pToCheckLength;
                                    if (any) {
                                        RequestParams params = new RequestParams();
                                        params.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, pVersion);
                                        params.put("data", Base64.encodeToString(bits, 2));
                                        APIClient.post(context, PackageManager.BASE_URL + "aip", params, new C13881());
                                    }
                                }
                                Editor editor = prefs.edit();
                                editor.putLong(PackageManager.LAST_CHECK_KEY, System.currentTimeMillis());
                                editor.commit();
                            } catch (Throwable e) {
                                Logger.trace(e);
                            }
                        }
                    });
                }
            }
        });
    }
}
