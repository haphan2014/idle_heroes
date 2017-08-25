package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.ClickTrackingOverlayView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ch;
import com.applovin.impl.sdk.cj;
import com.applovin.impl.sdk.dp;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl implements AdViewController {
    private Activity f86a;
    private AppLovinSdk f87b;
    private AppLovinAdService f88c;
    private AppLovinLogger f89d;
    private AppLovinAdSize f90e;
    private String f91f;
    private C0139r f92g;
    private C0133l f93h;
    private C0136o f94i;
    private AppLovinAd f95j;
    private Runnable f96k;
    private Runnable f97l;
    private Runnable f98m;
    private volatile AppLovinAd f99n = null;
    private ClickTrackingOverlayView f100o = null;
    private WeakReference f101p = null;
    private final AtomicReference f102q = new AtomicReference();
    private volatile boolean f103r = false;
    private volatile boolean f104s = true;
    private volatile boolean f105t = false;
    private volatile boolean f106u = false;
    private volatile AppLovinAdLoadListener f107v;
    private volatile AppLovinAdDisplayListener f108w;
    private volatile AppLovinAdVideoPlaybackListener f109x;
    private volatile AppLovinAdClickListener f110y;
    private volatile boolean f111z;

    private void m105a(ViewGroup viewGroup, AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else if (context instanceof Activity) {
            this.f87b = appLovinSdk;
            this.f88c = appLovinSdk.getAdService();
            this.f89d = appLovinSdk.getLogger();
            this.f90e = appLovinAdSize;
            this.f86a = (Activity) context;
            this.f95j = dp.m695a();
            this.f92g = new C0139r(this, appLovinSdk);
            this.f98m = new C0127f();
            this.f96k = new C0132k();
            this.f97l = new C0130i();
            this.f93h = new C0133l(this, appLovinSdk);
            if (m108a(context)) {
                this.f94i = m109b();
                viewGroup.setBackgroundColor(0);
                viewGroup.addView(this.f94i);
                m111b(this.f94i, appLovinAdSize);
                m107a(this.f98m);
                m107a(new C0131j());
                this.f103r = true;
                return;
            }
            this.f89d.userError("AppLovinAdView", "Web view database is corrupt, AdView not loaded");
        } else {
            throw new IllegalArgumentException("Specified context is not an activity");
        }
    }

    private void m106a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, Uri uri) {
        if (this.f100o == null) {
            this.f89d.mo635d("AppLovinAdView", "Creating and rendering click overlay");
            this.f100o = new ClickTrackingOverlayView(appLovinAdView.getContext(), this.f87b);
            this.f100o.setLayoutParams(new LayoutParams(-1, -1));
            appLovinAdView.addView(this.f100o);
            appLovinAdView.bringChildToFront(this.f100o);
            ((AppLovinAdServiceImpl) this.f88c).trackAndLaunchForegroundClick(appLovinAd, this.f91f, appLovinAdView, this, uri);
            return;
        }
        this.f89d.mo635d("AppLovinAdView", "Skipping click overlay rendering because it already exists");
    }

    private void m107a(Runnable runnable) {
        this.f86a.runOnUiThread(runnable);
    }

    private static boolean m108a(Context context) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return true;
            }
            WebViewDatabase instance = WebViewDatabase.getInstance(context);
            Method declaredMethod = WebViewDatabase.class.getDeclaredMethod("getCacheTotalSize", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, new Object[0]);
            return true;
        } catch (Throwable e) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e);
            return true;
        } catch (Throwable e2) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e2);
            return true;
        } catch (Throwable e22) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e22);
            return true;
        } catch (Throwable e3) {
            Log.e("AppLovinAdView", "getCacheTotalSize() reported exception", e3);
            return false;
        } catch (Throwable e32) {
            Log.e("AppLovinAdView", "Unexpected error while checking DB state", e32);
            return false;
        }
    }

    private C0136o m109b() {
        C0136o c0136o = new C0136o(this.f92g, this.f87b, this.f86a);
        c0136o.setBackgroundColor(0);
        c0136o.setWillNotCacheDrawing(false);
        if (new ch(this.f87b).m513F() && VERSION.SDK_INT >= 19) {
            c0136o.setLayerType(2, null);
        }
        return c0136o;
    }

    private static void m111b(View view, AppLovinAdSize appLovinAdSize) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
        int applyDimension2 = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
        ViewGroup.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -2);
        }
        layoutParams.width = applyDimension;
        layoutParams.height = applyDimension2;
        if (layoutParams instanceof LayoutParams) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        view.setLayoutParams(layoutParams);
    }

    void m120a() {
        this.f89d.mo635d("AppLovinAdView", "Ad: " + this.f99n + " with placement = \"" + this.f91f + "\" closed.");
        m107a(this.f98m);
        m107a(new C0129h(this, this.f99n));
        this.f99n = null;
        this.f91f = null;
    }

    void m121a(int i) {
        if (!this.f105t) {
            this.f88c.addAdUpdateListener(this.f93h, this.f90e);
            m107a(this.f98m);
        }
        m107a(new C0123b(this, i));
    }

    void m122a(AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            this.f106u = true;
            if (this.f105t) {
                this.f102q.set(appLovinAd);
                this.f89d.mo635d("AppLovinAdView", "Ad view has paused when an ad was recieved, ad saved for later");
            } else {
                this.f88c.addAdUpdateListener(this.f93h, this.f90e);
                renderAd(appLovinAd);
            }
            m107a(new C0121a(this, appLovinAd));
            return;
        }
        this.f89d.mo636e("AppLovinAdView", "No provided when to the view controller");
        m121a(-1);
    }

    void m123a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        AppLovinAdServiceImpl appLovinAdServiceImpl = (AppLovinAdServiceImpl) this.f88c;
        if (!new ch(this.f87b).m517J() || uri == null) {
            appLovinAdServiceImpl.trackAndLaunchClick(appLovinAd, this.f91f, appLovinAdView, this, uri);
        } else {
            m106a(appLovinAd, appLovinAdView, uri);
        }
        m107a(new C0128g(this, appLovinAd));
    }

    public void destroy() {
        if (this.f88c != null) {
            this.f88c.removeAdUpdateListener(this.f93h, getSize());
        }
        if (this.f94i != null) {
            try {
                ViewParent parent = this.f94i.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f94i);
                }
                this.f94i.removeAllViews();
                this.f94i.destroy();
                this.f94i = null;
            } catch (Throwable th) {
                this.f89d.mo642w("AppLovinAdView", "Unable to destroy ad view", th);
            }
        }
        this.f105t = true;
    }

    public void dismissInterstitialIfRequired() {
        if (!new ch(this.f87b).m521N()) {
            return;
        }
        if (this.f86a != null && (this.f86a instanceof AppLovinInterstitialActivity)) {
            ((AppLovinInterstitialActivity) this.f86a).dismiss();
        } else if (this.f101p != null) {
            C0143x c0143x = (C0143x) this.f101p.get();
            if (c0143x != null) {
                c0143x.dismiss();
            }
        }
    }

    public AppLovinAdSize getSize() {
        return this.f90e;
    }

    public void initializeAdView(ViewGroup viewGroup, Context context, AppLovinAdSize appLovinAdSize, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null) {
                appLovinAdSize = C0134m.m178a(attributeSet);
                if (appLovinAdSize == null) {
                    appLovinAdSize = AppLovinAdSize.BANNER;
                }
            }
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m105a(viewGroup, appLovinSdk, appLovinAdSize, context);
                if (C0134m.m179b(attributeSet)) {
                    loadNextAd();
                }
            }
        }
    }

    public boolean isAdReadyToDisplay() {
        return this.f87b.getAdService().hasPreloadedAd(this.f90e);
    }

    public boolean isAutoDestroy() {
        return this.f104s;
    }

    public boolean isForegroundClickInvalidated() {
        return this.f111z;
    }

    public void loadNextAd() {
        if (this.f87b == null || this.f93h == null || this.f86a == null || !this.f103r) {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f88c.loadNextAd(this.f90e, this.f93h);
        }
    }

    public void onAdHtmlLoaded(WebView webView) {
        if (this.f99n != null) {
            webView.setVisibility(0);
            try {
                if (this.f108w != null) {
                    this.f108w.adDisplayed(this.f99n);
                }
            } catch (Throwable th) {
                this.f89d.userError("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (this.f103r) {
            m107a(new C0129h(this, this.f99n));
            if (this.f104s) {
                destroy();
            }
        }
    }

    public void onVisibilityChanged(int i) {
        if (!this.f103r || !this.f104s) {
            return;
        }
        if (i == 8 || i == 4) {
            pause();
        } else if (i == 0) {
            resume();
        }
    }

    public void pause() {
        if (this.f103r) {
            this.f88c.removeAdUpdateListener(this.f93h, getSize());
            AppLovinAd appLovinAd = this.f99n;
            renderAd(this.f95j);
            if (appLovinAd != null) {
                this.f102q.set(appLovinAd);
            }
            this.f105t = true;
        }
    }

    public void removeClickTrackingOverlay() {
        if (this.f100o != null) {
            ViewParent parent = this.f100o.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f100o);
                this.f100o = null;
                return;
            }
            return;
        }
        this.f89d.mo635d("AppLovinAdView", "Asked to remove an overlay when none existed. Skipping...");
    }

    public void renderAd(AppLovinAd appLovinAd) {
        renderAd(appLovinAd, null);
    }

    public void renderAd(AppLovinAd appLovinAd, String str) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (!this.f103r) {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to render ad: AppLovinAdView is not initialized.");
        } else if (appLovinAd != this.f99n) {
            this.f89d.mo635d("AppLovinAdView", "Rendering ad #" + appLovinAd.getAdIdNumber() + " (" + appLovinAd.getSize() + ") over placement: " + str);
            m107a(new C0129h(this, this.f99n));
            this.f102q.set(null);
            this.f99n = appLovinAd;
            this.f91f = str;
            if (appLovinAd.getSize() == this.f90e) {
                m107a(this.f96k);
            } else if (appLovinAd.getSize() == AppLovinAdSize.INTERSTITIAL) {
                m107a(this.f98m);
                m107a(this.f97l);
            }
            new cj(this.f87b).m563a();
        } else {
            this.f89d.mo641w("AppLovinAdView", "Ad #" + appLovinAd.getAdIdNumber() + " is already showing, ignoring");
        }
    }

    public void resume() {
        if (this.f103r) {
            if (this.f106u) {
                this.f88c.addAdUpdateListener(this.f93h, this.f90e);
            }
            AppLovinAd appLovinAd = (AppLovinAd) this.f102q.getAndSet(null);
            if (appLovinAd != null) {
                renderAd(appLovinAd);
            }
            this.f105t = false;
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f110y = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f108w = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f107v = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f109x = appLovinAdVideoPlaybackListener;
    }

    public void setAutoDestroy(boolean z) {
        this.f104s = z;
    }

    public void setIsForegroundClickInvalidated(boolean z) {
        this.f111z = z;
    }

    public void setParentDialog(WeakReference weakReference) {
        this.f101p = weakReference;
    }
}
