package com.heyzap.common.vast.util;

import android.text.TextUtils;
import com.google.android.gms.fitness.FitnessStatusCodes;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpTools {
    private static final String TAG = HttpTools.class.getName();
    private static String disallowedCharacters = " \"<>%{}|\\^~[]`$";

    public static void httpGetURL(final String url) {
        if (TextUtils.isEmpty(url)) {
            VASTLog.m788w(TAG, "url is null or empty");
        } else {
            new Thread() {
                public void run() {
                    HttpURLConnection conn = null;
                    try {
                        VASTLog.m787v(HttpTools.TAG, "connection to URL:" + url);
                        URL httpUrl = new URL(url);
                        HttpURLConnection.setFollowRedirects(true);
                        conn = (HttpURLConnection) httpUrl.openConnection();
                        conn.setConnectTimeout(FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
                        conn.setRequestProperty("Connection", "close");
                        conn.setRequestMethod("GET");
                        VASTLog.m787v(HttpTools.TAG, "response code:" + conn.getResponseCode() + ", for URL:" + url);
                        if (conn != null) {
                            try {
                                conn.disconnect();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        VASTLog.m788w(HttpTools.TAG, url + ": " + e2.getMessage() + ":" + e2.toString());
                        if (conn != null) {
                            try {
                                conn.disconnect();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th) {
                        if (conn != null) {
                            try {
                                conn.disconnect();
                            } catch (Exception e4) {
                            }
                        }
                    }
                }
            }.start();
        }
    }

    public static String fixupURI(String uriString) {
        if (uriString == null) {
            return null;
        }
        for (int charIdx = 0; charIdx < disallowedCharacters.length(); charIdx++) {
            String badChar = disallowedCharacters.substring(charIdx, charIdx + 1);
            uriString = uriString.replace(badChar, URLEncoder.encode(badChar));
        }
        return uriString;
    }
}
