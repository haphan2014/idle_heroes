package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzaV;
    CustomEventBanner zzaW;
    CustomEventInterstitial zzaX;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzaY;
        private final MediationBannerListener zzaZ;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzaY = customEventAdapter;
            this.zzaZ = mediationBannerListener;
        }

        public void onClick() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzaZ.onClick(this.zzaY);
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzaZ.onDismissScreen(this.zzaY);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzaZ.onFailedToReceiveAd(this.zzaY, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzaZ.onLeaveApplication(this.zzaY);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzaZ.onPresentScreen(this.zzaY);
        }

        public void onReceivedAd(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onReceivedAd.");
            this.zzaY.zza(view);
            this.zzaZ.onReceivedAd(this.zzaY);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzaY;
        private final MediationInterstitialListener zzba;
        final /* synthetic */ CustomEventAdapter zzbb;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzbb = customEventAdapter;
            this.zzaY = customEventAdapter2;
            this.zzba = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onDismissScreen.");
            this.zzba.onDismissScreen(this.zzaY);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzba.onFailedToReceiveAd(this.zzaY, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onLeaveApplication.");
            this.zzba.onLeaveApplication(this.zzaY);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onPresentScreen.");
            this.zzba.onPresentScreen(this.zzaY);
        }

        public void onReceivedAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onReceivedAd.");
            this.zzba.onReceivedAd(this.zzbb);
        }
    }

    private void zza(View view) {
        this.zzaV = view;
    }

    private static <T> T zzj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    public void destroy() {
        if (this.zzaW != null) {
            this.zzaW.destroy();
        }
        if (this.zzaX != null) {
            this.zzaX.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzaV;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzaW = (CustomEventBanner) zzj(serverParameters.className);
        if (this.zzaW == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzaW.requestBannerAd(new zza(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzaX = (CustomEventInterstitial) zzj(serverParameters.className);
        if (this.zzaX == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzaX.requestInterstitialAd(zza(listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.zzaX.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
