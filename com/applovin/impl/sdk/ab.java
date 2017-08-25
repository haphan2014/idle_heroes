package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.SoftReference;

public class ab {
    private static String f372l = null;
    private final AppLovinSdkImpl f373a;
    private final AppLovinAdServiceImpl f374b;
    private AppLovinAdImpl f375c;
    private String f376d;
    private SoftReference f377e;
    private final Handler f378f;
    private final Object f379g = new Object();
    private volatile String f380h;
    private dm f381i;
    private volatile boolean f382j = false;
    private SoftReference f383k;

    public ab(AppLovinSdk appLovinSdk) {
        this.f373a = (AppLovinSdkImpl) appLovinSdk;
        this.f374b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f378f = new Handler(Looper.getMainLooper());
    }

    public static void m297a(String str) {
        f372l = str;
    }

    public static String m301b() {
        return f372l;
    }

    private void m304e() {
        if (this.f377e != null) {
            AppLovinAdLoadListener appLovinAdLoadListener = (AppLovinAdLoadListener) this.f377e.get();
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
            }
        }
    }

    private AppLovinAdRewardListener m305f() {
        return new ac(this);
    }

    void m306a(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (m312a()) {
            AppLovinAd appLovinAd = this.f375c;
            if (appLovinAd.getType().equals(AppLovinAdType.INCENTIVIZED)) {
                AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f373a, activity);
                AppLovinAdRewardListener agVar = new ag(this, activity, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
                create.setAdDisplayListener(agVar);
                create.setAdVideoPlaybackListener(agVar);
                create.setAdClickListener(agVar);
                create.showAndRender(appLovinAd, this.f376d);
                this.f383k = new SoftReference(create);
                m308a(appLovinAd, agVar);
                return;
            }
            this.f373a.getLogger().mo636e("IncentivizedAdController", "Attempted to render an ad of type " + this.f375c.getType() + " in an Incentivized Ad interstitial.");
            appLovinAdVideoPlaybackListener.videoPlaybackEnded(this.f375c, 0.0d, false);
            return;
        }
        this.f373a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m304e();
    }

    public void m307a(Activity activity, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdRewardListener f = appLovinAdRewardListener == null ? m305f() : appLovinAdRewardListener;
        if (!m312a()) {
            this.f373a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            m304e();
        } else if (this.f375c.isVideoStream() || this.f375c.getVideoUri() == null || this.f373a.getFileManager().m285a(this.f375c.getVideoUri().getLastPathSegment(), (Context) activity)) {
            this.f376d = str;
            if (((Boolean) this.f373a.m253a(cd.aa)).booleanValue()) {
                as asVar = new as(this.f373a, this);
                asVar.m334a(activity);
                asVar.m336a(appLovinAdDisplayListener);
                asVar.m335a(appLovinAdClickListener);
                asVar.m338a(appLovinAdVideoPlaybackListener);
                asVar.m337a(f);
                asVar.m333a();
                return;
            }
            m306a(activity, f, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        }
    }

    void m308a(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f381i = new dm(this.f373a, appLovinAd, appLovinAdRewardListener);
        this.f373a.m252a().m649a(this.f381i, cz.BACKGROUND);
    }

    public void m309a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f373a.getLogger().mo635d("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.f377e = new SoftReference(appLovinAdLoadListener);
        if (m312a()) {
            this.f373a.getLogger().userError("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f375c);
                return;
            }
            return;
        }
        this.f374b.loadNextAd(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, new ad(this, appLovinAdLoadListener));
    }

    void m310a(AppLovinAdRewardListener appLovinAdRewardListener) {
        appLovinAdRewardListener.userDeclinedToViewAd(this.f375c);
    }

    void m311a(String str, Activity activity) {
        if (str != null && ((Boolean) this.f373a.m253a(cd.ab)).booleanValue()) {
            new aq(this.f373a, activity, str).m323a();
        }
    }

    public boolean m312a() {
        return this.f375c != null;
    }

    void m313b(String str) {
        synchronized (this.f379g) {
            this.f380h = str;
        }
    }

    String m314c() {
        String str;
        synchronized (this.f379g) {
            str = this.f380h;
        }
        return str;
    }

    public void m315d() {
        if (this.f383k != null) {
            AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = (AppLovinInterstitialAdDialog) this.f383k.get();
            if (appLovinInterstitialAdDialog != null) {
                appLovinInterstitialAdDialog.dismiss();
            }
        }
    }
}
