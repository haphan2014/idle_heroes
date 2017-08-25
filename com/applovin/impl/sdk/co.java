package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;

abstract class co extends cc {
    protected AppLovinNativeAdLoadListener f608a;
    protected AppLovinNativeAdPrecacheListener f609b;
    private List f610c;
    private int f611d = 0;

    co(String str, AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(str, appLovinSdkImpl);
        this.f608a = appLovinNativeAdLoadListener;
        this.f610c = list;
    }

    co(String str, AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super(str, appLovinSdkImpl);
        if (list == null) {
            throw new IllegalArgumentException("Slots cannot be null");
        }
        this.f610c = list;
        this.f609b = appLovinNativeAdPrecacheListener;
    }

    private void m581a(int i) {
        if (this.f608a != null) {
            this.f608a.onNativeAdsFailedToLoad(i);
        }
    }

    private void m582a(List list) {
        if (this.f608a != null) {
            this.f608a.onNativeAdsLoaded(list);
        }
    }

    protected String m583a(String str, aa aaVar) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            this.f.getLogger().mo635d(m471a(), "Asked to cache file with null/empty URL, nothing to do.");
            return null;
        } else if (dp.m704a(this.f, str)) {
            try {
                String a = aaVar.m278a(this.h, str, true);
                if (a != null) {
                    return a;
                }
                this.g.mo641w(m471a(), "Unable to cache icon resource " + str);
                return null;
            } catch (Throwable e) {
                this.g.mo642w(m471a(), "Unable to cache icon resource " + str, e);
                return null;
            }
        } else {
            this.f.getLogger().mo635d(m471a(), "Domain is not whitelisted, skipping precache for URL " + str);
            return null;
        }
    }

    protected abstract void mo625a(NativeAdImpl nativeAdImpl);

    protected abstract boolean mo626a(NativeAdImpl nativeAdImpl, aa aaVar);

    public void run() {
        for (NativeAdImpl nativeAdImpl : this.f610c) {
            aa fileManager = this.f.getFileManager();
            this.f.getLogger().mo635d(m471a(), "Beginning resource caching phase...");
            if (mo626a(nativeAdImpl, fileManager)) {
                this.f611d++;
                mo625a(nativeAdImpl);
            } else {
                this.f.getLogger().mo636e(m471a(), "Unable to cache resources");
            }
        }
        try {
            if (this.f611d == this.f610c.size()) {
                m582a(this.f610c);
            } else if (((Boolean) this.f.m253a(cd.aG)).booleanValue()) {
                this.f.getLogger().mo636e(m471a(), "Mismatch between successful populations and requested size");
                m581a(-6);
            } else {
                m582a(this.f610c);
            }
        } catch (Throwable th) {
            this.f.getLogger().userError(m471a(), "Encountered exception while notifying publisher code", th);
        }
    }
}
