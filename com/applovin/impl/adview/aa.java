package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

class aa implements AppLovinAdVideoPlaybackListener {
    final /* synthetic */ ah f120a;
    final /* synthetic */ C0143x f121b;

    aa(C0143x c0143x, ah ahVar) {
        this.f121b = c0143x;
        this.f120a = ahVar;
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        AppLovinAdVideoPlaybackListener c = this.f120a.m141c();
        if (c != null) {
            c.videoPlaybackBegan(appLovinAd);
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        AppLovinAdVideoPlaybackListener c = this.f120a.m141c();
        if (c != null) {
            c.videoPlaybackEnded(appLovinAd, d, z);
        }
    }
}
