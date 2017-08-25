package com.vungle.publisher;

import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class sa {
    public static Boolean m2424a(JSONObject jSONObject, String str) {
        boolean optBoolean = jSONObject.optBoolean(str, false);
        if (optBoolean) {
            return Boolean.valueOf(optBoolean);
        }
        optBoolean = jSONObject.optBoolean(str, true);
        if (!optBoolean) {
            return Boolean.valueOf(optBoolean);
        }
        return null;
    }

    public static Integer m2429c(JSONObject jSONObject, String str) {
        int optInt = jSONObject.optInt(str, -1);
        if (optInt != -1) {
            return Integer.valueOf(optInt);
        }
        optInt = jSONObject.optInt(str, -2);
        if (optInt != -2) {
            return Integer.valueOf(optInt);
        }
        return null;
    }

    public static String m2430d(JSONObject jSONObject, String str) {
        return jSONObject.isNull(str) ? null : jSONObject.optString(str, null);
    }

    public static <T extends aar> JSONArray m2426a(T... tArr) throws JSONException {
        JSONArray jSONArray = null;
        if (tArr != null) {
            jSONArray = new JSONArray();
            for (aar a : tArr) {
                jSONArray.put(m2427a(a));
            }
        }
        return jSONArray;
    }

    public static <T> JSONArray m2425a(List<T> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (T obj : list) {
            jSONArray.put(obj.toString());
        }
        return jSONArray;
    }

    public static JSONObject m2427a(aar com_vungle_publisher_aar) throws JSONException {
        if (com_vungle_publisher_aar != null) {
            return com_vungle_publisher_aar.mo4355a();
        }
        return null;
    }

    public static Float m2428b(JSONObject jSONObject, String str) {
        Double valueOf;
        double optDouble = jSONObject.optDouble(str);
        if (optDouble == Double.NaN) {
            optDouble = jSONObject.optDouble(str, -1.0d);
            if (optDouble != -1.0d) {
                valueOf = Double.valueOf(optDouble);
            } else {
                valueOf = null;
            }
        } else {
            valueOf = Double.valueOf(optDouble);
        }
        if (valueOf == null) {
            return null;
        }
        return Float.valueOf(valueOf.floatValue());
    }

    public static List<String> m2431e(JSONObject jSONObject, String str) {
        Object[] objArr;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            objArr = new String[length];
            for (int i = 0; i < length; i++) {
                objArr[i] = optJSONArray.optString(i, null);
            }
        } else {
            objArr = null;
        }
        if (objArr != null) {
            return Arrays.asList(objArr);
        }
        return null;
    }
}
