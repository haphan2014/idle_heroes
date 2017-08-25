package com.applovin.impl.sdk;

import org.json.JSONObject;

class cv extends df {
    final /* synthetic */ cu f624a;

    cv(cu cuVar, String str, cf cfVar, AppLovinSdkImpl appLovinSdkImpl) {
        this.f624a = cuVar;
        super(str, cfVar, appLovinSdkImpl);
    }

    public void mo622a(int i) {
        this.f624a.m609b(i);
    }

    protected void mo624a(C0164o c0164o, C0151p c0151p) {
        c0164o.m745a(this.f624a.m626c(), ((Integer) this.f.m253a(cd.f577p)).intValue(), c0151p);
    }

    public void mo623a(JSONObject jSONObject, int i) {
        if (i == 200) {
            this.f624a.m610b(jSONObject);
        } else {
            this.f624a.m609b(i);
        }
    }
}
