package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

public class cn extends co {
    public cn(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdLoadListener);
    }

    public cn(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdPrecacheListener);
    }

    private boolean m586b(NativeAdImpl nativeAdImpl) {
        this.g.mo641w("TaskCacheNativeAdImages", "Unable to cache image resource");
        m588a(nativeAdImpl, !C0165q.m758a(this.h) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES);
        return false;
    }

    protected void mo625a(NativeAdImpl nativeAdImpl) {
        if (this.b != null) {
            this.b.onNativeAdImagesPrecached(nativeAdImpl);
        }
    }

    protected void m588a(NativeAdImpl nativeAdImpl, int i) {
        if (this.b != null) {
            this.b.onNativeAdImagePrecachingFailed(nativeAdImpl, i);
        }
    }

    protected boolean mo626a(NativeAdImpl nativeAdImpl, aa aaVar) {
        this.f.getLogger().mo635d("TaskCacheNativeAdImages", "Beginning slot image caching for ad " + nativeAdImpl.getAdId());
        if (((Boolean) this.f.m253a(cd.f537B)).booleanValue()) {
            String a = m583a(nativeAdImpl.getSourceIconUrl(), aaVar);
            if (a == null) {
                return m586b(nativeAdImpl);
            }
            nativeAdImpl.setIconUrl(a);
            a = m583a(nativeAdImpl.getSourceImageUrl(), aaVar);
            if (a == null) {
                return m586b(nativeAdImpl);
            }
            nativeAdImpl.setImageUrl(a);
        } else {
            this.f.getLogger().mo635d("TaskCacheNativeAdImages", "Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
