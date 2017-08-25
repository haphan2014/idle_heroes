package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class be {
    public static float m380a(JSONObject jSONObject, String str, float f, AppLovinSdk appLovinSdk) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f;
        }
        try {
            double d = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d || d >= 3.4028234663852886E38d) ? f : (float) d;
        } catch (JSONException e) {
            appLovinSdk.getLogger().mo636e("JsonUtils", "Failed to retrieve float property for key = " + str);
            return f;
        }
    }

    public static int m381a(JSONObject jSONObject, String str, int i, AppLovinSdk appLovinSdk) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                i = jSONObject.getInt(str);
            } catch (JSONException e) {
                appLovinSdk.getLogger().mo636e("JsonUtils", "Failed to retrieve int property for key = " + str);
            }
        }
        return i;
    }

    private static Object m382a(Object obj) {
        return obj == JSONObject.NULL ? null : obj instanceof JSONObject ? m385a((JSONObject) obj) : obj instanceof JSONArray ? m384a((JSONArray) obj) : obj;
    }

    public static String m383a(JSONObject jSONObject, String str, String str2, AppLovinSdk appLovinSdk) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                str2 = jSONObject.getString(str);
            } catch (JSONException e) {
                appLovinSdk.getLogger().mo636e("JsonUtils", "Failed to retrieve string property for key = " + str);
            }
        }
        return str2;
    }

    public static List m384a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m382a(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static Map m385a(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, m382a(jSONObject.get(str)).toString());
        }
        return hashMap;
    }

    static JSONObject m386a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static boolean m387a(JSONObject jSONObject, String str, boolean z, AppLovinSdk appLovinSdk) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                z = jSONObject.getBoolean(str);
            } catch (JSONException e) {
                appLovinSdk.getLogger().mo636e("JsonUtils", "Failed to retrieve boolean property for key = " + str);
            }
        }
        return z;
    }
}
