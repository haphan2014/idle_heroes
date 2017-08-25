package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bi extends bx {
    public bi(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    C0150c mo599a(bf bfVar) {
        return NativeAdImpl.SPEC_NATIVE;
    }

    cc mo600a(C0150c c0150c) {
        cc cwVar = new cw(this.a, 1, this);
        cwVar.m623a(true);
        return cwVar;
    }

    Map mo601a() {
        Map hashMap = new HashMap(1);
        hashMap.put(NativeAdImpl.SPEC_NATIVE, new by(((Integer) this.a.m253a(cd.aK)).intValue()));
        return hashMap;
    }

    public void mo602a(C0150c c0150c, int i) {
    }

    void mo603a(Object obj, bf bfVar) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = (AppLovinNativeAdLoadListener) obj;
        appLovinNativeAdLoadListener.onNativeAdsLoaded(Arrays.asList(new AppLovinNativeAd[]{(AppLovinNativeAd) bfVar}));
    }

    void mo604a(Object obj, C0150c c0150c, int i) {
        ((AppLovinNativeAdLoadListener) obj).onNativeAdsFailedToLoad(i);
    }

    public void adReceived(AppLovinAd appLovinAd) {
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
        m356b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdsLoaded(List list) {
        AppLovinNativeAd appLovinNativeAd = (AppLovinNativeAd) list.get(0);
        if (((Boolean) this.a.m253a(cd.bs)).booleanValue()) {
            this.a.getNativeAdService().precacheResources(appLovinNativeAd, new bj(this));
        } else {
            m358c((bf) appLovinNativeAd);
        }
    }
}
