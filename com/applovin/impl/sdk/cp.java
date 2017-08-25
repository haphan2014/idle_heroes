package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;

public class cp extends co {
    public cp(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdVideos", appLovinSdkImpl, list, appLovinNativeAdLoadListener);
    }

    public cp(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdVideos", appLovinSdkImpl, list, appLovinNativeAdPrecacheListener);
    }

    private boolean m590b(NativeAdImpl nativeAdImpl) {
        this.g.mo641w("TaskCacheNativeAdVideos", "Unable to cache video resource " + nativeAdImpl.getSourceVideoUrl());
        m592a(nativeAdImpl, !C0165q.m758a(this.h) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
        return false;
    }

    protected void mo625a(NativeAdImpl nativeAdImpl) {
        if (this.b != null) {
            this.b.onNativeAdVideoPreceached(nativeAdImpl);
        }
    }

    protected void m592a(NativeAdImpl nativeAdImpl, int i) {
        if (this.b != null) {
            this.b.onNativeAdVideoPrecachingFailed(nativeAdImpl, i);
        }
    }

    protected boolean mo626a(NativeAdImpl nativeAdImpl, aa aaVar) {
        if (AppLovinSdkUtils.isValidString(nativeAdImpl.getSourceVideoUrl())) {
            this.f.getLogger().mo635d("TaskCacheNativeAdVideos", "Beginning slot video caching for ad " + nativeAdImpl.getAdId());
            if (((Boolean) this.f.m253a(cd.f537B)).booleanValue()) {
                String a = m583a(nativeAdImpl.getSourceVideoUrl(), aaVar);
                if (a == null) {
                    return m590b(nativeAdImpl);
                }
                nativeAdImpl.setVideoUrl(a);
            } else {
                this.f.getLogger().mo635d("TaskCacheNativeAdVideos", "Resource caching is disabled, skipping...");
            }
            return true;
        }
        this.f.getLogger().mo635d("TaskCacheNativeAdVideos", "No video attached to ad, nothing to cache...");
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
