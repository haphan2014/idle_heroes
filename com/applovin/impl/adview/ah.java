package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinAdImpl.AdPresentationMode;
import com.applovin.impl.sdk.AppLovinAdImpl.AdTarget;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0163n;
import com.applovin.impl.sdk.ch;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ah implements AppLovinInterstitialAdDialog {
    public static volatile boolean f130a = false;
    public static volatile boolean f131b = false;
    private static final Map f132c = Collections.synchronizedMap(new HashMap());
    private static volatile boolean f133o;
    private final String f134d;
    private final AppLovinSdkImpl f135e;
    private final WeakReference f136f;
    private volatile AppLovinAdLoadListener f137g;
    private volatile AppLovinAdDisplayListener f138h;
    private volatile AppLovinAdVideoPlaybackListener f139i;
    private volatile AppLovinAdClickListener f140j;
    private volatile AppLovinAdImpl f141k;
    private volatile AdTarget f142l;
    private volatile C0096w f143m;
    private volatile String f144n;

    ah(AppLovinSdk appLovinSdk, Activity activity) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            this.f135e = (AppLovinSdkImpl) appLovinSdk;
            this.f134d = UUID.randomUUID().toString();
            f130a = true;
            f131b = false;
            this.f136f = new WeakReference(activity);
        }
    }

    public static ah m124a(String str) {
        return (ah) f132c.get(str);
    }

    private void m126a(int i) {
        Activity i2 = m136i();
        if (i2 != null) {
            i2.runOnUiThread(new al(this, i));
        } else {
            this.f135e.getLogger().userError("InterstitialAdDialogWrapper", "Failed to notify load listener: activity reference is stale");
        }
    }

    private void m127a(Activity activity) {
        Object c0143x = new C0143x(this.f135e, activity);
        c0143x.m229a(this);
        this.f143m = c0143x;
        c0143x.m230a(this.f141k, this.f144n);
    }

    private void m128a(Activity activity, boolean z, boolean z2) {
        if (z && z2) {
            m134b(activity);
        } else {
            m127a(activity);
        }
    }

    private void m132a(AppLovinAd appLovinAd) {
        if (this.f138h != null) {
            this.f138h.adHidden(appLovinAd);
        }
    }

    private void m134b(Activity activity) {
        Intent intent = new Intent(activity, AppLovinInterstitialActivity.class);
        intent.putExtra(AppLovinInterstitialActivity.KEY_WRAPPER_ID, this.f134d);
        AppLovinInterstitialActivity.lastKnownWrapper = this;
        activity.startActivity(intent);
        m139a(true);
    }

    private void m135b(AppLovinAd appLovinAd) {
        Activity i = m136i();
        if (i != null) {
            i.runOnUiThread(new ak(this, appLovinAd));
        } else {
            this.f135e.getLogger().userError("InterstitialAdDialogWrapper", "Failed to notify load listener: activity reference is stale");
        }
    }

    private Activity m136i() {
        return this.f136f != null ? (Activity) this.f136f.get() : null;
    }

    public AppLovinSdk m137a() {
        return this.f135e;
    }

    public void m138a(C0096w c0096w) {
        this.f143m = c0096w;
    }

    public void m139a(boolean z) {
        f133o = z;
    }

    public AppLovinAd m140b() {
        return this.f141k;
    }

    public AppLovinAdVideoPlaybackListener m141c() {
        return this.f139i;
    }

    public AppLovinAdDisplayListener m142d() {
        return this.f138h;
    }

    public void dismiss() {
        Activity i = m136i();
        if (i == null) {
            this.f135e.getLogger().userError("InterstitialAdDialogWrapper", "Failed to notify load listener: activity reference is stale");
        } else if (this.f143m != null) {
            i.runOnUiThread(new am(this));
        }
    }

    public AppLovinAdClickListener m143e() {
        return this.f140j;
    }

    public AdTarget m144f() {
        return this.f142l;
    }

    public String m145g() {
        return this.f144n;
    }

    public void m146h() {
        f130a = false;
        f131b = true;
        f132c.remove(this.f134d);
    }

    public boolean isAdReadyToDisplay() {
        return this.f135e.getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public boolean isShowing() {
        return f133o;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f140j = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f138h = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f137g = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f139i = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        show(null);
    }

    public void show(String str) {
        this.f135e.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new ai(this, str));
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        showAndRender(appLovinAd, null);
    }

    public void showAndRender(AppLovinAd appLovinAd, String str) {
        boolean z = false;
        if (isShowing()) {
            this.f135e.getLogger().userError("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
            return;
        }
        f132c.put(this.f134d, this);
        this.f141k = (AppLovinAdImpl) appLovinAd;
        this.f144n = str;
        this.f142l = this.f141k != null ? this.f141k.getTarget() : AdTarget.DEFAULT;
        Context i = m136i();
        if (i == null) {
            this.f135e.getLogger().mo636e("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            m132a(appLovinAd);
        } else if (this.f141k.isVideoStream() || this.f141k.getVideoUri() == null || this.f135e.getFileManager().m285a(this.f141k.getVideoUri().getLastPathSegment(), i)) {
            boolean a = C0163n.m732a(AppLovinInterstitialActivity.class, i);
            boolean z2 = ((AppLovinAdImpl) appLovinAd).getPresentationMode() == AdPresentationMode.ACTIVITY;
            boolean z3 = this.f142l == AdTarget.ACTIVITY_LANDSCAPE || this.f142l == AdTarget.ACTIVITY_PORTRAIT;
            if (z2 || z3) {
                z = true;
            }
            long max = Math.max(0, new ch(this.f135e).m525R());
            Handler handler = new Handler(i.getMainLooper());
            this.f135e.getLogger().mo635d("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
            handler.postDelayed(new aj(this, i, a, z), max);
        } else {
            m132a(appLovinAd);
        }
    }
}
