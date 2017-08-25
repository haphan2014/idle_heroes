package com.heyzap.sdk.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.heyzap.internal.Constants;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationManager;
import com.heyzap.sdk.ads.HeyzapAds.BannerError;
import com.heyzap.sdk.ads.HeyzapAds.BannerListener;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public final class BannerAd {
    private static final AtomicReference<BannerAd> instance = new AtomicReference();
    private static BannerListener instanceListener;
    public static boolean usePopupView = false;
    protected final BannerAdView bannerAdView;
    private final BannerOptions bannerOptions;
    private int bannerPosition;
    private final AtomicReference<Boolean> isShowing = new AtomicReference(Boolean.valueOf(false));
    private final PopupContainer popupContainer;
    private final String tag;

    class C14551 implements BannerListener {
        C14551() {
        }

        public void onAdError(BannerAdView bannerView, BannerError error) {
            if (BannerAd.instanceListener != null) {
                BannerAd.instanceListener.onAdError(bannerView, error);
            }
        }

        public void onAdLoaded(BannerAdView bannerView) {
            if (BannerAd.instanceListener != null) {
                BannerAd.instanceListener.onAdLoaded(bannerView);
            }
            Logger.debug("BannerAd - onAdLoaded - container: " + BannerAd.this.popupContainer);
            BannerAd.this.popupContainer.onAdLoaded();
        }

        public void onAdClicked(BannerAdView bannerView) {
            if (BannerAd.instanceListener != null) {
                BannerAd.instanceListener.onAdClicked(bannerView);
            }
        }
    }

    interface PopupContainer {
        void hide();

        void onAdLoaded();

        void show(Activity activity);
    }

    class DirectPopupContainer implements PopupContainer {
        DirectPopupContainer() {
        }

        public void show(Activity activity) {
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.gravity = BannerAd.this.bannerPosition | 1;
            activity.addContentView(BannerAd.this.bannerAdView, layoutParams);
        }

        public void hide() {
            ViewParent parent = BannerAd.this.bannerAdView.getParent();
            if (parent != null) {
                ViewGroup group = (ViewGroup) parent;
                if (group != null) {
                    group.removeView(BannerAd.this.bannerAdView);
                }
            }
        }

        public void onAdLoaded() {
        }
    }

    class PopupViewPopupContainer implements PopupContainer {
        private Activity activity;
        private PopupWindow popUpWindow;
        private boolean showOnLoad = false;

        PopupViewPopupContainer() {
        }

        public void show(Activity activity) {
            this.activity = activity;
            if (this.popUpWindow != null) {
                showPopupWindow();
            } else {
                this.showOnLoad = true;
            }
        }

        public void hide() {
            this.showOnLoad = false;
            if (this.popUpWindow != null) {
                this.popUpWindow.dismiss();
            }
        }

        public void onAdLoaded() {
            if (this.showOnLoad && BannerAd.this.bannerAdView.bannerWrapper != null) {
                if (BannerAd.this.bannerOptions.getContainerViewSize() != null) {
                    this.popUpWindow = new PopupWindow(BannerAd.this.bannerAdView, BannerAd.this.bannerOptions.getContainerViewSize().getWidth(), BannerAd.this.bannerOptions.getContainerViewSize().getHeight());
                } else {
                    this.popUpWindow = new PopupWindow(BannerAd.this.bannerAdView, BannerAd.this.bannerAdView.bannerWrapper.getAdWidth(), BannerAd.this.bannerAdView.bannerWrapper.getAdHeight());
                }
                this.popUpWindow.getContentView().setSystemUiVisibility(this.activity.getWindow().getAttributes().flags);
                setPopUpWindowLayoutType(this.popUpWindow, 1002);
                showPopupWindow();
                this.showOnLoad = false;
            }
        }

        private void showPopupWindow() {
            this.popUpWindow.showAtLocation(this.activity.getWindow().getDecorView().getRootView(), BannerAd.this.bannerOptions.getPosition() | 1, 0, 0);
        }

        private void setPopUpWindowLayoutType(PopupWindow popupWindow, int layoutType) {
            try {
                Method method = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                method.setAccessible(true);
                method.invoke(popupWindow, new Object[]{Integer.valueOf(layoutType)});
            } catch (Exception exception) {
                Logger.warn(exception.getLocalizedMessage());
            }
        }
    }

    private BannerAd(Activity activity, String tag, BannerOptions options) {
        this.bannerAdView = new BannerAdView(activity, tag);
        this.tag = tag;
        if (usePopupView) {
            this.popupContainer = new PopupViewPopupContainer();
        } else {
            this.popupContainer = new DirectPopupContainer();
        }
        if (options == null) {
            options = new BannerOptions();
        }
        this.bannerOptions = options;
        this.bannerAdView.setBannerOptions(this.bannerOptions);
        this.bannerAdView.setBannerListener(new C14551());
    }

    private void internalHide(final boolean destroy) {
        if (this.bannerAdView != null && this.bannerAdView.getContext() != null) {
            ((Activity) this.bannerAdView.getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (BannerAd.this.isShowing.compareAndSet(Boolean.valueOf(true), Boolean.valueOf(false))) {
                        Logger.debug("BannerAd - internalHide - container: " + BannerAd.this.popupContainer);
                        BannerAd.this.popupContainer.hide();
                    }
                    if (destroy) {
                        BannerAd.this.bannerAdView.destroy();
                    }
                }
            });
        }
    }

    private void show(final Activity activity, int position) {
        this.bannerPosition = position;
        this.bannerOptions.setPosition(position);
        activity.runOnUiThread(new Runnable() {
            public void run() {
                if (BannerAd.this.isShowing.compareAndSet(Boolean.valueOf(false), Boolean.valueOf(true))) {
                    Logger.debug("BannerAd - show - container: " + BannerAd.this.popupContainer);
                    BannerAd.this.popupContainer.show(activity);
                    BannerAd.this.bannerAdView.load();
                }
            }
        });
    }

    public static synchronized void display(Activity activity, int position) {
        synchronized (BannerAd.class) {
            display(activity, position, Constants.DEFAULT_TAG, new BannerOptions());
        }
    }

    public static synchronized void display(Activity activity, int position, String tag) {
        synchronized (BannerAd.class) {
            display(activity, position, tag, new BannerOptions());
        }
    }

    public static synchronized void display(Activity activity, int position, String tag, BannerOptions options) {
        synchronized (BannerAd.class) {
            options.setPosition(position);
            BannerAd banner = (BannerAd) instance.get();
            if (!(banner != null && banner.bannerOptions.equals(options) && banner.tag.equals(tag))) {
                if (banner != null) {
                    banner.internalHide(true);
                }
                Logger.info("Creating new banner ad");
                banner = new BannerAd(activity, tag, options);
                instance.set(banner);
            }
            if (MediationManager.getInstance().adsTimedOut()) {
                DevLogger.info("Ads disabled because of an IAP");
            } else {
                banner.show(activity, position);
            }
        }
    }

    public static synchronized void hide() {
        synchronized (BannerAd.class) {
            BannerAd bannerAd = (BannerAd) instance.get();
            if (bannerAd != null) {
                bannerAd.internalHide(false);
            }
        }
    }

    public static synchronized void destroy() {
        synchronized (BannerAd.class) {
            BannerAd bannerAd = (BannerAd) instance.get();
            if (bannerAd != null && instance.compareAndSet(bannerAd, null)) {
                bannerAd.internalHide(true);
            }
        }
    }

    public static void setBannerListener(BannerListener bannerListener) {
        instanceListener = bannerListener;
    }

    public static BannerAdView getCurrentBannerAdView() {
        BannerAd banner = (BannerAd) instance.get();
        if (banner != null) {
            return banner.bannerAdView;
        }
        return null;
    }
}
