package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

class C0126e implements AppLovinAdVideoPlaybackListener {
    final /* synthetic */ AdViewControllerImpl f188a;

    C0126e(AdViewControllerImpl adViewControllerImpl) {
        this.f188a = adViewControllerImpl;
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        if (this.f188a.f109x != null) {
            this.f188a.f109x.videoPlaybackBegan(appLovinAd);
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        if (this.f188a.f109x != null) {
            this.f188a.f109x.videoPlaybackEnded(appLovinAd, d, z);
        }
    }
}
