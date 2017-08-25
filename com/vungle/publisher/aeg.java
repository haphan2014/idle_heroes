package com.vungle.publisher;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class aeg {
    public final String f1218a;
    public final String f1219b;
    public final String f1220c;

    public aeg(String str, JSONObject jSONObject) throws JSONException {
        this.f1218a = jSONObject.getString("extension");
        this.f1219b = jSONObject.getString("url");
        this.f1220c = str;
    }
}
