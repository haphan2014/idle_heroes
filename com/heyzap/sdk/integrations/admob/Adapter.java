package com.heyzap.sdk.integrations.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.Logger;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import com.heyzap.sdk.ads.InterstitialAd;
import org.json.JSONObject;

public class Adapter implements MediationInterstitialAdapter<AdapterExtras, ServerParameters>, CustomEventInterstitial {
    static int FLAGS = 9;
    static String LOG_LABEL = "AdMob";
    static String MEDIATOR_LABEL = Network.ADMOB;
    private Activity activity;
    private CustomEventInterstitialListener customEventInterstitialListener;
    private HeyzapOnStatusListener heyzapListener;
    private MediationInterstitialListener mediationInterstitialListener;

    private class HeyzapOnStatusListener implements OnStatusListener {

        class C15041 implements Runnable {
            C15041() {
            }

            public void run() {
                Adapter.this.mediationInterstitialListener.onReceivedAd(Adapter.this);
            }
        }

        class C15052 implements Runnable {
            C15052() {
            }

            public void run() {
                Adapter.this.customEventInterstitialListener.onReceivedAd();
            }
        }

        private HeyzapOnStatusListener() {
        }

        public void onShow(String tag) {
            if (Adapter.this.mediationInterstitialListener != null) {
                Adapter.this.mediationInterstitialListener.onPresentScreen(Adapter.this);
            }
            if (Adapter.this.customEventInterstitialListener != null) {
                Adapter.this.customEventInterstitialListener.onPresentScreen();
            }
        }

        public void onClick(String tag) {
            if (Adapter.this.mediationInterstitialListener != null) {
                Adapter.this.mediationInterstitialListener.onLeaveApplication(Adapter.this);
            }
            if (Adapter.this.customEventInterstitialListener != null) {
                Adapter.this.customEventInterstitialListener.onLeaveApplication();
            }
        }

        public void onHide(String tag) {
            if (Adapter.this.mediationInterstitialListener != null) {
                Adapter.this.mediationInterstitialListener.onDismissScreen(Adapter.this);
            }
            if (Adapter.this.customEventInterstitialListener != null) {
                Adapter.this.customEventInterstitialListener.onDismissScreen();
            }
        }

        public void onFailedToShow(String tag) {
            if (Adapter.this.mediationInterstitialListener != null) {
                Adapter.this.mediationInterstitialListener.onFailedToReceiveAd(Adapter.this, ErrorCode.INVALID_REQUEST);
            }
            if (Adapter.this.customEventInterstitialListener != null) {
                Adapter.this.customEventInterstitialListener.onFailedToReceiveAd();
            }
        }

        public void onAvailable(String tag) {
            if (Adapter.this.mediationInterstitialListener != null) {
                Adapter.this.activity.runOnUiThread(new C15041());
            }
            if (Adapter.this.customEventInterstitialListener != null) {
                Adapter.this.activity.runOnUiThread(new C15052());
            }
        }

        public void onFailedToFetch(String tag) {
            if (Adapter.this.mediationInterstitialListener != null) {
                Adapter.this.mediationInterstitialListener.onFailedToReceiveAd(Adapter.this, ErrorCode.NO_FILL);
            }
            if (Adapter.this.customEventInterstitialListener != null) {
                Adapter.this.customEventInterstitialListener.onFailedToReceiveAd();
            }
        }

        public void onAudioStarted() {
        }

        public void onAudioFinished() {
        }
    }

    public Class<AdapterExtras> getAdditionalParametersType() {
        return AdapterExtras.class;
    }

    public Class<ServerParameters> getServerParametersType() {
        return ServerParameters.class;
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, ServerParameters serverParams, MediationAdRequest mediationRequest, AdapterExtras extras) {
        this.mediationInterstitialListener = listener;
        this.activity = activity;
        if (startHeyzapIfNeeded(serverParams.publisherId).booleanValue()) {
            InterstitialAd.fetch();
        } else {
            this.mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INVALID_REQUEST);
        }
    }

    public void requestInterstitialAd(Context context, CustomEventInterstitialListener listener, String serverParameter, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.customEventInterstitialListener = listener;
        this.activity = (Activity) context;
        if (VERSION.SDK_INT < 9) {
            this.customEventInterstitialListener.onFailedToReceiveAd();
        }
        if (startHeyzapIfNeeded(customEventExtras.getString("publisher_id")).booleanValue()) {
            InterstitialAd.fetch();
        } else {
            this.customEventInterstitialListener.onFailedToReceiveAd();
        }
    }

    public void requestInterstitialAd(CustomEventInterstitialListener listener, Activity activity, String label, String serverParameter, MediationAdRequest mediationAdRequest, Object customEventExtra) {
        this.customEventInterstitialListener = listener;
        this.activity = activity;
        if (!HeyzapAds.hasStarted()) {
            try {
                serverParameter = new JSONObject(serverParameter).optString("publisher_id", serverParameter);
            } catch (Throwable e) {
                Logger.trace(e);
            }
            HeyzapAds.start(serverParameter, activity, FLAGS);
        }
        if (VERSION.SDK_INT >= 9) {
            HeyzapAds.mediator = MEDIATOR_LABEL;
            if (this.heyzapListener == null) {
                this.heyzapListener = new HeyzapOnStatusListener();
                InterstitialAd.setOnStatusListener(this.heyzapListener);
            }
            InterstitialAd.fetch();
            return;
        }
        this.customEventInterstitialListener.onFailedToReceiveAd();
    }

    public void showInterstitial() {
        if (this.activity != null) {
            InterstitialAd.display(this.activity);
            return;
        }
        if (this.mediationInterstitialListener != null) {
            this.mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INVALID_REQUEST);
        }
        if (this.customEventInterstitialListener != null) {
            this.customEventInterstitialListener.onFailedToReceiveAd();
        }
    }

    private Boolean startHeyzapIfNeeded(String publisherId) {
        if (VERSION.SDK_INT < 9) {
            return Boolean.valueOf(false);
        }
        if (publisherId == null || publisherId.equals("")) {
            DevLogger.error("WARNING: Heyzap does not have a publisher ID. The parameters need are 'publisher_id'.");
            return Boolean.valueOf(false);
        }
        if (this.heyzapListener == null) {
            this.heyzapListener = new HeyzapOnStatusListener();
        }
        if (HeyzapAds.hasStarted()) {
            InterstitialAd.setOnStatusListener(this.heyzapListener);
        } else {
            HeyzapAds.start(publisherId, this.activity, FLAGS);
            InterstitialAd.setOnStatusListener(this.heyzapListener);
            HeyzapAds.mediator = MEDIATOR_LABEL;
        }
        return Boolean.valueOf(true);
    }

    public void destroy() {
    }
}
