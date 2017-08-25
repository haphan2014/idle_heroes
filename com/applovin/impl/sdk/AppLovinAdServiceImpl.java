package com.applovin.impl.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    public static String URI_NO_OP = "/adservice/no_op";
    public static String URI_SKIP_AD = "/adservice/skip";
    public static String URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
    private final AppLovinSdkImpl f314a;
    private final AppLovinLogger f315b;
    private Handler f316c;
    private final Map f317d;

    AppLovinAdServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f314a = appLovinSdkImpl;
        this.f315b = appLovinSdkImpl.getLogger();
        this.f316c = new Handler(Looper.getMainLooper());
        this.f317d = new HashMap(2);
        for (AppLovinAdType put : AppLovinAdType.allTypes()) {
            this.f317d.put(put, new HashMap());
        }
        ((Map) this.f317d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.BANNER, new C0158i(AppLovinAdSize.BANNER));
        ((Map) this.f317d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.MREC, new C0158i(AppLovinAdSize.MREC));
        ((Map) this.f317d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.INTERSTITIAL, new C0158i(AppLovinAdSize.INTERSTITIAL));
        ((Map) this.f317d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.LEADER, new C0158i(AppLovinAdSize.LEADER));
        ((Map) this.f317d.get(AppLovinAdType.INCENTIVIZED)).put(AppLovinAdSize.INTERSTITIAL, new C0158i(AppLovinAdSize.INTERSTITIAL));
    }

    private void m232a(Uri uri, AppLovinAdImpl appLovinAdImpl, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        adViewControllerImpl.removeClickTrackingOverlay();
        expireAdLoadState(appLovinAdImpl);
        AppLovinSdkUtils.openUri(appLovinAdView.getContext(), uri, this.f314a);
        adViewControllerImpl.dismissInterstitialIfRequired();
    }

    private void m233a(AppLovinAdImpl appLovinAdImpl, String str) {
        String supplementalClickTrackingUrl = appLovinAdImpl.getSupplementalClickTrackingUrl(str);
        if (AppLovinSdkUtils.isValidString(supplementalClickTrackingUrl)) {
            this.f314a.getPersistentPostbackManager().m454a(supplementalClickTrackingUrl, null);
        }
    }

    private void m236a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener) {
        C0150c c0150c = new C0150c(appLovinAdSize, appLovinAdType);
        AppLovinAd appLovinAd = (AppLovinAd) this.f314a.m256c().mo606b(c0150c);
        if (appLovinAd != null) {
            this.f315b.mo635d("AppLovinAdService", "Using pre-loaded ad: " + appLovinAd + " for size " + appLovinAdSize + " and type " + appLovinAdType);
            appLovinAdLoadListener.adReceived(appLovinAd);
        } else {
            this.f314a.m252a().m649a(new cu(appLovinAdSize, appLovinAdType, appLovinAdLoadListener, this.f314a), cz.MAIN);
        }
        this.f314a.m256c().mo611f(c0150c);
    }

    private boolean m237a() {
        return ((PowerManager) this.f314a.getApplicationContext().getSystemService("power")).isScreenOn();
    }

    private boolean m239a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER ? ((Boolean) this.f314a.m253a(cd.f581t)).booleanValue() : appLovinAdSize == AppLovinAdSize.MREC ? ((Boolean) this.f314a.m253a(cd.f583v)).booleanValue() : appLovinAdSize == AppLovinAdSize.LEADER ? ((Boolean) this.f314a.m253a(cd.f585x)).booleanValue() : false;
    }

    private boolean m240a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return !((Boolean) this.f314a.m253a(cd.f536A)).booleanValue() ? false : !m244b(appLovinAdSize, appLovinAdType) ? false : appLovinAdType.equals(AppLovinAdType.INCENTIVIZED) ? ((Boolean) this.f314a.m253a(cd.aw)).booleanValue() : appLovinAdSize.equals(AppLovinAdSize.INTERSTITIAL) ? ((Boolean) this.f314a.m253a(cd.ax)).booleanValue() : false;
    }

    private long m242b(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER ? ((Long) this.f314a.m253a(cd.f582u)).longValue() : appLovinAdSize == AppLovinAdSize.MREC ? ((Long) this.f314a.m253a(cd.f584w)).longValue() : appLovinAdSize == AppLovinAdSize.LEADER ? ((Long) this.f314a.m253a(cd.f586y)).longValue() : 0;
    }

    private boolean m244b(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        try {
            return appLovinAdType.equals(AppLovinAdType.INCENTIVIZED) ? ((Boolean) this.f314a.m253a(cd.f541F)).booleanValue() : ((String) this.f314a.m253a(cd.f540E)).toUpperCase(Locale.ENGLISH).contains(appLovinAdSize.getLabel());
        } catch (Throwable e) {
            this.f314a.getLogger().mo637e("AppLovinAdService", "Unable to safely test preload merge capability", e);
            return false;
        }
    }

    private void m247c(AppLovinAdSize appLovinAdSize) {
        long b = m242b(appLovinAdSize);
        if (b > 0) {
            this.f314a.m252a().m650a(new C0159j(this, appLovinAdSize), cz.MAIN, (b + 2) * 1000);
        }
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener) {
        addAdUpdateListener(appLovinAdUpdateListener, AppLovinAdSize.BANNER);
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        if (appLovinAdUpdateListener == null) {
            throw new IllegalArgumentException("No ad listener specified");
        }
        Object obj;
        C0158i c0158i = (C0158i) ((Map) this.f317d.get(AppLovinAdType.REGULAR)).get(appLovinAdSize);
        synchronized (c0158i.f680b) {
            if (c0158i.f684f.contains(appLovinAdUpdateListener)) {
                obj = null;
            } else {
                c0158i.f684f.add(appLovinAdUpdateListener);
                obj = 1;
                this.f315b.mo635d("AppLovinAdService", "Added update listener: " + appLovinAdUpdateListener);
            }
        }
        if (obj != null) {
            this.f314a.m252a().m649a(new C0159j(this, appLovinAdSize), cz.MAIN);
        }
    }

    public void expireAdLoadState(AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        C0158i c0158i = (C0158i) ((Map) this.f317d.get(appLovinAdImpl.getType())).get(appLovinAdImpl.getSize());
        synchronized (c0158i.f680b) {
            c0158i.f681c = null;
            c0158i.f682d = 0;
        }
    }

    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f314a.m256c().mo610e(new C0150c(appLovinAdSize, AppLovinAdType.REGULAR));
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        loadNextAd(appLovinAdSize, AppLovinAdType.REGULAR, appLovinAdLoadListener);
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener) {
        Object obj = 1;
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (appLovinAdType == null) {
            throw new IllegalArgumentException("No ad type specificed");
        } else {
            AppLovinAd appLovinAd;
            this.f314a.getLogger().mo635d("AppLovinAdService", "Loading next ad of size " + appLovinAdSize.getLabel() + " and type " + appLovinAdType.getLabel());
            if (appLovinAdSize.equals(AppLovinAdSize.BANNER) || appLovinAdSize.equals(AppLovinAdSize.MREC) || appLovinAdSize.equals(AppLovinAdSize.LEADER)) {
                this.f314a.getLogger().userError("AppLovinAdService", "Banners, MRecs and Leaderboards are deprecated and will be removed in a future SDK version!");
            }
            C0158i c0158i = (C0158i) ((Map) this.f317d.get(appLovinAdType)).get(appLovinAdSize);
            synchronized (c0158i.f680b) {
                if (System.currentTimeMillis() <= c0158i.f682d) {
                    obj = null;
                }
                if (c0158i.f681c == null || r2 != null) {
                    c0158i.f685g.add(appLovinAdLoadListener);
                    if (c0158i.f683e) {
                        this.f315b.mo635d("AppLovinAdService", "Already waiting on an ad load...");
                        appLovinAd = null;
                    } else {
                        this.f315b.mo635d("AppLovinAdService", "Loading next ad...");
                        c0158i.f683e = true;
                        obj = new C0157h(this, (C0158i) ((Map) this.f317d.get(appLovinAdType)).get(appLovinAdSize), null);
                        if (!m240a(appLovinAdSize, appLovinAdType)) {
                            this.f315b.mo635d("AppLovinAdService", "Task merge not necessary.");
                            m236a(appLovinAdSize, appLovinAdType, obj);
                        } else if (this.f314a.m256c().mo605a(new C0150c(appLovinAdSize, appLovinAdType), obj)) {
                            this.f315b.mo635d("AppLovinAdService", "Attaching load listener to initial preload task...");
                        } else {
                            this.f315b.mo635d("AppLovinAdService", "Skipped attach of initial preload callback.");
                            m236a(appLovinAdSize, appLovinAdType, obj);
                        }
                        appLovinAd = null;
                    }
                } else {
                    appLovinAd = c0158i.f681c;
                }
            }
            if (appLovinAd != null) {
                appLovinAdLoadListener.adReceived(appLovinAd);
            }
        }
    }

    public void preloadAd(AppLovinAdSize appLovinAdSize) {
        this.f314a.m256c().mo611f(new C0150c(appLovinAdSize, AppLovinAdType.REGULAR));
    }

    public void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        if (appLovinAdUpdateListener != null) {
            C0158i c0158i = (C0158i) ((Map) this.f317d.get(AppLovinAdType.REGULAR)).get(appLovinAdSize);
            synchronized (c0158i.f680b) {
                c0158i.f684f.remove(appLovinAdUpdateListener);
            }
            this.f315b.mo635d("AppLovinAdService", "Removed update listener: " + appLovinAdUpdateListener);
        }
    }

    public void trackAndLaunchClick(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        m233a(appLovinAdImpl, str);
        m232a(uri, appLovinAdImpl, appLovinAdView, adViewControllerImpl);
    }

    public void trackAndLaunchForegroundClick(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        this.f315b.mo635d("AppLovinAdService", "Tracking foreground click on an ad...");
        int intValue = ((Integer) this.f314a.m253a(cd.bk)).intValue();
        int intValue2 = ((Integer) this.f314a.m253a(cd.bl)).intValue();
        int intValue3 = ((Integer) this.f314a.m253a(cd.bm)).intValue();
        this.f314a.getPostbackService().dispatchPostbackAsync(((AppLovinAdImpl) appLovinAd).getSupplementalClickTrackingUrl(str), null, intValue, intValue2, intValue3, new C0154e(this, adViewControllerImpl, uri, appLovinAdImpl, appLovinAdView));
    }

    public void trackAndLaunchVideoClick(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, Uri uri) {
        m233a((AppLovinAdImpl) appLovinAd, str);
        AppLovinSdkUtils.openUri(appLovinAdView.getContext(), uri, this.f314a);
    }
}
