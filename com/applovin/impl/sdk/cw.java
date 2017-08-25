package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.Map;
import org.json.JSONObject;

class cw extends cu {
    private int f625a;
    private final AppLovinNativeAdLoadListener f626b;

    public cw(AppLovinSdkImpl appLovinSdkImpl, int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(NativeAdImpl.SIZE_NATIVE, NativeAdImpl.TYPE_NATIVE, null, appLovinSdkImpl);
        this.f626b = appLovinNativeAdLoadListener;
        this.f625a = i;
    }

    protected cc mo630a(JSONObject jSONObject) {
        return new de(jSONObject, this.f, this.f626b);
    }

    protected void mo631a(int i) {
        if (this.f626b != null) {
            this.f626b.onNativeAdsFailedToLoad(i);
        }
    }

    protected void mo632b(Map map) {
        map.put("slot_count", Integer.toString(this.f625a));
    }

    protected void mo633c(Map map) {
        dl a = dj.m670a().m671a("tFNW");
        if (a != null) {
            map.put("etfw", Long.toString(a.m674b()));
            map.put("ntfw", a.m673a());
        }
    }

    protected String mo634d() {
        return C0165q.m760b("nad", this.f);
    }

    public String mo629e() {
        return "tFNW";
    }
}
