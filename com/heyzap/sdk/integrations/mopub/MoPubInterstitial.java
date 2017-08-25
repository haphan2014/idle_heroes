package com.heyzap.sdk.integrations.mopub;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.heyzap.house.Manager;
import com.heyzap.internal.DevLogger;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import com.heyzap.sdk.ads.InterstitialAd;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;

class MoPubInterstitial extends CustomEventInterstitial implements OnStatusListener {
    private Context context;
    private boolean mHasAlreadyRegisteredClick;
    private CustomEventInterstitialListener mInterstitialListener;
    private String publisherId = null;

    private static class UiWrappedCustomEventInterstitialListener implements CustomEventInterstitialListener {
        private final Handler handler;
        private final CustomEventInterstitialListener inner;

        class C15061 implements Runnable {
            C15061() {
            }

            public void run() {
                UiWrappedCustomEventInterstitialListener.this.inner.onInterstitialLoaded();
            }
        }

        class C15083 implements Runnable {
            C15083() {
            }

            public void run() {
                UiWrappedCustomEventInterstitialListener.this.inner.onInterstitialShown();
            }
        }

        class C15094 implements Runnable {
            C15094() {
            }

            public void run() {
                UiWrappedCustomEventInterstitialListener.this.inner.onInterstitialClicked();
            }
        }

        class C15105 implements Runnable {
            C15105() {
            }

            public void run() {
                UiWrappedCustomEventInterstitialListener.this.inner.onLeaveApplication();
            }
        }

        class C15116 implements Runnable {
            C15116() {
            }

            public void run() {
                UiWrappedCustomEventInterstitialListener.this.inner.onInterstitialDismissed();
            }
        }

        public UiWrappedCustomEventInterstitialListener(CustomEventInterstitialListener inner, Handler handler) {
            this.inner = inner;
            this.handler = handler;
        }

        public void onInterstitialLoaded() {
            this.handler.post(new C15061());
        }

        public void onInterstitialFailed(final MoPubErrorCode moPubErrorCode) {
            this.handler.post(new Runnable() {
                public void run() {
                    UiWrappedCustomEventInterstitialListener.this.inner.onInterstitialFailed(moPubErrorCode);
                }
            });
        }

        public void onInterstitialShown() {
            this.handler.post(new C15083());
        }

        public void onInterstitialClicked() {
            this.handler.post(new C15094());
        }

        public void onLeaveApplication() {
            this.handler.post(new C15105());
        }

        public void onInterstitialDismissed() {
            this.handler.post(new C15116());
        }
    }

    MoPubInterstitial() {
    }

    protected void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        this.mInterstitialListener = new UiWrappedCustomEventInterstitialListener(customEventInterstitialListener, Manager.handler);
        if (context instanceof Activity) {
            this.context = context;
            if (!HeyzapAds.hasStarted()) {
                HeyzapAds.mediator = "mopub";
                String localPublisherId = (String) localExtras.get("publisher_id");
                String serverPublisherId = (String) serverExtras.get("publisher_id");
                if (serverPublisherId != null) {
                    this.publisherId = serverPublisherId;
                } else if (localPublisherId != null) {
                    this.publisherId = localPublisherId;
                }
                if (this.publisherId != null) {
                    HeyzapAds.start(this.publisherId, (Activity) context, 9);
                } else {
                    DevLogger.error("Heyzap not enabled. Could not find publisher_id in either the local or server extras.");
                    this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                }
            }
            InterstitialAd.setOnStatusListener(this);
            InterstitialAd.fetch();
            return;
        }
        this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    protected void showInterstitial() {
        if (InterstitialAd.isAvailable().booleanValue()) {
            InterstitialAd.display((Activity) this.context);
        } else {
            DevLogger.debug("Tried to show a Heyzap interstitial ad before it finished loading. Please try again.");
        }
    }

    protected void onInvalidate() {
        InterstitialAd.setOnStatusListener(null);
    }

    public void onShow(String tag) {
        DevLogger.debug("Showing Heyzap interstitial ad.");
        this.mInterstitialListener.onInterstitialShown();
    }

    public void onClick(String tag) {
        DevLogger.debug("Heyzap interstitial ad clicked.");
        this.mInterstitialListener.onInterstitialClicked();
    }

    public void onHide(String tag) {
        DevLogger.debug("Heyzap interstitial ad dismissed.");
        this.mInterstitialListener.onInterstitialDismissed();
    }

    public void onFailedToShow(String tag) {
        DevLogger.debug("Heyzap interstitial ad failed to show.");
        this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
    }

    public void onAvailable(String tag) {
        DevLogger.debug("Heyzap interstitial ad loaded successfully.");
        this.mInterstitialListener.onInterstitialLoaded();
    }

    public void onFailedToFetch(String tag) {
        DevLogger.debug("Heyzap interstitial ad failed to load.");
        this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
    }

    public void onAudioStarted() {
    }

    public void onAudioFinished() {
    }
}
