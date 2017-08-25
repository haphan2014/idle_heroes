package com.applovin.impl.sdk;

import org.json.JSONObject;

abstract class df extends cc implements C0151p {
    private int f528a;
    private long f529b;
    private final C0151p f530c;
    private cf f531d;

    df(String str, int i, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
        this.f529b = -1;
        this.f531d = null;
        this.f528a = i;
        this.f530c = new dg(this, appLovinSdkImpl, str);
    }

    df(String str, cf cfVar, AppLovinSdkImpl appLovinSdkImpl) {
        this(str, ((Integer) appLovinSdkImpl.m253a(cfVar)).intValue(), appLovinSdkImpl);
    }

    static /* synthetic */ int m478b(df dfVar, int i) {
        int i2 = dfVar.f528a - i;
        dfVar.f528a = i2;
        return i2;
    }

    private void m480c() {
        if (this.f531d != null) {
            cg settingsManager = this.f.getSettingsManager();
            settingsManager.m502a(this.f531d, this.f531d.m496c());
            settingsManager.m505b();
        }
    }

    public void mo622a(int i) {
    }

    public void m483a(long j) {
        this.f529b = j;
    }

    public void m484a(cf cfVar) {
        this.f531d = cfVar;
    }

    protected abstract void mo624a(C0164o c0164o, C0151p c0151p);

    public void mo623a(JSONObject jSONObject, int i) {
    }

    public void run() {
        mo624a(this.f.getConnectionManager(), this.f530c);
    }
}
