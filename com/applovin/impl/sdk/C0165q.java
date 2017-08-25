package com.applovin.impl.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.InputStream;
import java.util.Scanner;
import org.json.JSONObject;

class C0165q {
    private static final int[] f694a = new int[]{7, 4, 2, 1, 11};
    private static final int[] f695b = new int[]{5, 6, 10, 3, 9, 8, 14};
    private static final int[] f696c = new int[]{15, 12, 13};
    private static final String f697d = C0165q.class.getSimpleName();

    C0165q() {
    }

    static String m750a(AppLovinSdkImpl appLovinSdkImpl) {
        NetworkInfo b = C0165q.m759b(appLovinSdkImpl.getApplicationContext());
        if (b == null) {
            return "unknown";
        }
        int type = b.getType();
        int subtype = b.getSubtype();
        String str = type == 1 ? "wifi" : type == 0 ? C0165q.m757a(subtype, f694a) ? "2g" : C0165q.m757a(subtype, f695b) ? "3g" : C0165q.m757a(subtype, f696c) ? "4g" : "mobile" : "unknown";
        appLovinSdkImpl.getLogger().mo635d(f697d, "Network " + type + "/" + subtype + " resolved to " + str);
        return str;
    }

    static String m751a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        Scanner scanner = new Scanner(inputStream, AsyncHttpResponseHandler.DEFAULT_CHARSET);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }

    static String m752a(String str) {
        return str.startsWith("https://") ? str : str.replace("http://", "https://");
    }

    static String m753a(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            String str2 = (String) appLovinSdkImpl.m253a(cd.f566e);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) appLovinSdkImpl.m253a(cd.f571j));
            stringBuilder.append(str);
            if (str2 == null || str2.length() <= 0) {
                stringBuilder.append("?api_key=");
                stringBuilder.append(appLovinSdkImpl.getSdkKey());
            } else {
                stringBuilder.append("?device_token=");
                stringBuilder.append(str2);
            }
            return stringBuilder.toString();
        }
    }

    static JSONObject m754a(JSONObject jSONObject) {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    static void m755a(int i, AppLovinSdkImpl appLovinSdkImpl) {
        cg settingsManager = appLovinSdkImpl.getSettingsManager();
        if (i == 401) {
            settingsManager.m502a(cd.f564c, "");
            settingsManager.m502a(cd.f566e, "");
            settingsManager.m505b();
        } else if (i == 418) {
            settingsManager.m502a(cd.f562a, Boolean.valueOf(true));
            settingsManager.m505b();
        } else if (i >= 400 && i < 500) {
            appLovinSdkImpl.m261h();
        } else if (i == -1) {
            appLovinSdkImpl.m261h();
        }
    }

    static void m756a(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                if (jSONObject.has("settings")) {
                    cg settingsManager = appLovinSdkImpl.getSettingsManager();
                    if (!jSONObject.isNull("settings")) {
                        settingsManager.m504a(jSONObject.getJSONObject("settings"));
                        settingsManager.m505b();
                        appLovinSdkImpl.getLogger().mo635d(f697d, "New settings processed");
                    }
                }
            } catch (Throwable e) {
                appLovinSdkImpl.getLogger().mo637e(f697d, "Unable to parse settings out of API response", e);
            }
        }
    }

    private static boolean m757a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    static boolean m758a(Context context) {
        NetworkInfo b = C0165q.m759b(context);
        return b == null || b.isConnected();
    }

    private static NetworkInfo m759b(Context context) {
        if (C0166r.m764a("android.permission.ACCESS_NETWORK_STATE", context)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
        }
        return null;
    }

    static String m760b(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (appLovinSdkImpl != null) {
            return ((String) appLovinSdkImpl.m253a(cd.f572k)) + str;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    static void m761b(int i, AppLovinSdkImpl appLovinSdkImpl) {
        if (i == 418) {
            cg settingsManager = appLovinSdkImpl.getSettingsManager();
            settingsManager.m502a(cd.f562a, Boolean.valueOf(true));
            settingsManager.m505b();
        }
    }
}
