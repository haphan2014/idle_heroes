package com.applovin.impl.sdk;

import org.json.JSONObject;

class cl extends df {
    final /* synthetic */ JSONObject f600a;
    final /* synthetic */ ck f601b;

    cl(ck ckVar, String str, cf cfVar, AppLovinSdkImpl appLovinSdkImpl, JSONObject jSONObject) {
        this.f601b = ckVar;
        this.f600a = jSONObject;
        super(str, cfVar, appLovinSdkImpl);
    }

    public void mo622a(int i) {
        C0165q.m755a(i, this.f);
    }

    protected void mo624a(C0164o c0164o, C0151p c0151p) {
        c0164o.m749a(C0165q.m753a("device", this.f), this.f600a, c0151p);
    }

    public void mo623a(JSONObject jSONObject, int i) {
        this.f601b.m564a(jSONObject);
    }
}
