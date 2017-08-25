package com.vungle.publisher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public abstract class abi<T> extends abj<T> {
    protected abstract T mo4356c(JSONObject jSONObject) throws JSONException;

    abi() {
    }

    public final T m912a(String str) throws JSONException {
        return str == null ? null : mo4356c(new JSONObject(str));
    }

    protected final T[] m913a(JSONArray jSONArray) throws JSONException {
        T[] tArr = null;
        if (jSONArray != null) {
            int length = jSONArray.length();
            tArr = mo4353a(length);
            for (int i = 0; i < length; i++) {
                tArr[i] = mo4356c(jSONArray.optJSONObject(i));
            }
        }
        return tArr;
    }

    protected static void m911a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            Object opt = jSONObject.opt(str);
            if (opt == null) {
                so.m2470a(3, "VungleProtocol", "null " + str + " is required input", null);
            } else {
                so.m2470a(3, "VungleProtocol", "invalid " + str + ": " + opt, null);
            }
        } else if ((obj instanceof String) && ((String) obj).length() == 0) {
            so.m2470a(3, "VungleProtocol", "empty " + str + " is required input", null);
        } else if ((obj instanceof JSONArray) && ((JSONArray) obj).length() == 0) {
            so.m2470a(3, "VungleProtocol", "empty array " + str + " is required input", null);
        }
    }
}
