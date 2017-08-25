package com.applovin.impl.sdk;

import org.json.JSONObject;

abstract class ca extends cc {
    protected ca(String str, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
    }

    protected void m473a(String str, JSONObject jSONObject, C0151p c0151p) {
        df cbVar = new cb(this, "Repeat" + this.e, cd.f568g, this.f, str, jSONObject, c0151p);
        cbVar.m484a(cd.f571j);
        cbVar.run();
    }
}
