package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C0149b extends bx {
    public C0149b(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    private cf m364a(AppLovinAdType appLovinAdType, AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize.equals(AppLovinAdSize.BANNER) ? cd.ac : appLovinAdSize.equals(AppLovinAdSize.MREC) ? cd.ad : appLovinAdSize.equals(AppLovinAdSize.INTERSTITIAL) ? cd.ae : appLovinAdSize.equals(AppLovinAdSize.LEADER) ? cd.af : cd.ac;
    }

    C0150c mo599a(bf bfVar) {
        return new C0150c((AppLovinAd) bfVar);
    }

    cc mo600a(C0150c c0150c) {
        cc cuVar = new cu(c0150c.m469a(), c0150c.m470b(), this, this.a);
        cuVar.m623a(true);
        return cuVar;
    }

    Map mo601a() {
        Map hashMap = new HashMap(5);
        for (AppLovinAdSize appLovinAdSize : AppLovinAdSize.allSizes()) {
            hashMap.put(new C0150c(appLovinAdSize, AppLovinAdType.REGULAR), new by(((Integer) this.a.m253a(m364a(AppLovinAdType.REGULAR, appLovinAdSize))).intValue()));
        }
        hashMap.put(new C0150c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED), new by(((Integer) this.a.m253a(cd.ag)).intValue()));
        return hashMap;
    }

    public void mo602a(C0150c c0150c, int i) {
        m356b(c0150c, i);
    }

    void mo603a(Object obj, bf bfVar) {
        ((AppLovinAdLoadListener) obj).adReceived((AppLovinAd) bfVar);
    }

    void mo604a(Object obj, C0150c c0150c, int i) {
        if (obj instanceof C0148y) {
            ((C0148y) obj).mo602a(c0150c, i);
        }
        if (obj instanceof AppLovinAdLoadListener) {
            ((AppLovinAdLoadListener) obj).failedToReceiveAd(i);
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        m358c((bf) appLovinAd);
    }

    public /* bridge */ /* synthetic */ bf mo606b(C0150c c0150c) {
        return super.mo606b(c0150c);
    }

    public /* bridge */ /* synthetic */ void mo607b(C0150c c0150c, Object obj) {
        super.mo607b(c0150c, obj);
    }

    public /* bridge */ /* synthetic */ boolean mo608c(C0150c c0150c) {
        return super.mo608c(c0150c);
    }

    public /* bridge */ /* synthetic */ void mo609d(C0150c c0150c) {
        super.mo609d(c0150c);
    }

    public /* bridge */ /* synthetic */ boolean mo610e(C0150c c0150c) {
        return super.mo610e(c0150c);
    }

    public /* bridge */ /* synthetic */ void mo611f(C0150c c0150c) {
        super.mo611f(c0150c);
    }

    public void failedToReceiveAd(int i) {
    }

    public void onNativeAdsFailedToLoad(int i) {
    }

    public void onNativeAdsLoaded(List list) {
    }
}
