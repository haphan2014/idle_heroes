package com.applovin.impl.sdk;

import org.json.JSONObject;

class ct extends df {
    final /* synthetic */ cs f619a;

    ct(cs csVar, String str, int i, AppLovinSdkImpl appLovinSdkImpl) {
        this.f619a = csVar;
        super(str, i, appLovinSdkImpl);
    }

    public void mo622a(int i) {
        this.f619a.f615c.onPostbackFailure(this.f619a.f613a, i);
    }

    protected void mo624a(C0164o c0164o, C0151p c0151p) {
        int intValue = this.f619a.f618j < 0 ? ((Integer) this.f.m253a(cd.ay)).intValue() : this.f619a.f618j;
        if (this.f619a.f614b == null) {
            c0164o.m747a(this.f619a.f613a, intValue, false, c0151p);
        } else {
            c0164o.m746a(this.f619a.f613a, intValue, new JSONObject(this.f619a.f614b), false, c0151p);
        }
    }

    public void mo623a(JSONObject jSONObject, int i) {
        this.f619a.f615c.onPostbackSuccess(this.f619a.f613a);
    }
}
