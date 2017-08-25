package com.applovin.impl.sdk;

import org.json.JSONObject;

class cb extends df {
    final /* synthetic */ String f532a;
    final /* synthetic */ JSONObject f533b;
    final /* synthetic */ C0151p f534c;
    final /* synthetic */ ca f535d;

    cb(ca caVar, String str, cf cfVar, AppLovinSdkImpl appLovinSdkImpl, String str2, JSONObject jSONObject, C0151p c0151p) {
        this.f535d = caVar;
        this.f532a = str2;
        this.f533b = jSONObject;
        this.f534c = c0151p;
        super(str, cfVar, appLovinSdkImpl);
    }

    public void mo622a(int i) {
        this.f534c.mo622a(i);
    }

    protected void mo624a(C0164o c0164o, C0151p c0151p) {
        c0164o.m749a(C0165q.m752a(C0165q.m753a(this.f532a, this.f)), this.f533b, c0151p);
    }

    public void mo623a(JSONObject jSONObject, int i) {
        this.f534c.mo623a(jSONObject, i);
    }
}
