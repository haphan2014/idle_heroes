package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class bk implements AppLovinNativeAdService {
    private final AppLovinSdkImpl f480a;
    private final Object f481b = new Object();

    bk(AppLovinSdkImpl appLovinSdkImpl) {
        this.f480a = appLovinSdkImpl;
    }

    private List m421a(AppLovinNativeAd appLovinNativeAd) {
        List arrayList = new ArrayList(1);
        arrayList.add((NativeAdImpl) appLovinNativeAd);
        return arrayList;
    }

    private void m428a(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isVideoPrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            return;
        }
        this.f480a.m252a().m649a(new cp(this.f480a, m421a(appLovinNativeAd), new bn(this, appLovinNativeAdPrecacheListener)), cz.MAIN);
    }

    private void m429a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, int i) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
            } catch (Throwable e) {
                this.f480a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    private void m430a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List list) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
            } catch (Throwable e) {
                this.f480a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    private void m431a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, int i, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPrecachingFailed(appLovinNativeAd, i);
                return;
            } catch (Throwable e) {
                this.f480a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
                return;
            }
        }
        appLovinNativeAdPrecacheListener.onNativeAdImagePrecachingFailed(appLovinNativeAd, i);
    }

    private void m432a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
                return;
            } catch (Throwable e) {
                this.f480a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
                return;
            }
        }
        appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
    }

    private void m433b(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f480a.m252a().m649a(new cn(this.f480a, list, new bq(this, appLovinNativeAdLoadListener)), cz.MAIN);
    }

    private void m434c(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f480a.m252a().m649a(new cp(this.f480a, list, new br(this, appLovinNativeAdLoadListener)), cz.MAIN);
    }

    public void m435a(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        int intValue = ((Integer) this.f480a.m253a(cd.aR)).intValue();
        if (intValue > 0) {
            list = list;
            int size = list.size();
            if (size != 0) {
                intValue = Math.min(intValue, size);
                List subList = list.subList(0, intValue);
                m433b(subList, new bo(this, subList, appLovinNativeAdLoadListener, list.subList(intValue, size)));
            } else if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            }
        } else if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    public void loadNativeAds(int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        AppLovinNativeAd appLovinNativeAd = null;
        synchronized (this.f481b) {
            if (i == 1) {
                if (this.f480a.m257d().mo610e(NativeAdImpl.SPEC_NATIVE)) {
                    appLovinNativeAd = (AppLovinNativeAd) this.f480a.m257d().mo606b(NativeAdImpl.SPEC_NATIVE);
                }
            }
        }
        if (appLovinNativeAd != null) {
            m430a(appLovinNativeAdLoadListener, Arrays.asList(new AppLovinNativeAd[]{appLovinNativeAd}));
            return;
        }
        this.f480a.m252a().m649a(new cw(this.f480a, i, new bl(this, appLovinNativeAdLoadListener)), cz.MAIN);
    }

    public void precacheResources(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isImagePrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
            m428a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            return;
        }
        this.f480a.m252a().m649a(new cn(this.f480a, m421a(appLovinNativeAd), new bm(this, appLovinNativeAdPrecacheListener)), cz.MAIN);
    }
}
