package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    CustomEventBanner zzHH;
    CustomEventInterstitial zzHI;
    private View zzaV;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzHJ;
        private final MediationBannerListener zzaO;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzHJ = customEventAdapter;
            this.zzaO = mediationBannerListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClicked.");
            this.zzaO.onAdClicked(this.zzHJ);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClosed.");
            this.zzaO.onAdClosed(this.zzHJ);
        }

        public void onAdFailedToLoad(int errorCode) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdFailedToLoad.");
            this.zzaO.onAdFailedToLoad(this.zzHJ, errorCode);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdLeftApplication.");
            this.zzaO.onAdLeftApplication(this.zzHJ);
        }

        public void onAdLoaded(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdLoaded.");
            this.zzHJ.zza(view);
            this.zzaO.onAdLoaded(this.zzHJ);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdOpened.");
            this.zzaO.onAdOpened(this.zzHJ);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzHJ;
        final /* synthetic */ CustomEventAdapter zzHK;
        private final MediationInterstitialListener zzaP;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzHK = customEventAdapter;
            this.zzHJ = customEventAdapter2;
            this.zzaP = mediationInterstitialListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClicked.");
            this.zzaP.onAdClicked(this.zzHJ);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClosed.");
            this.zzaP.onAdClosed(this.zzHJ);
        }

        public void onAdFailedToLoad(int errorCode) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzaP.onAdFailedToLoad(this.zzHJ, errorCode);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdLeftApplication.");
            this.zzaP.onAdLeftApplication(this.zzHJ);
        }

        public void onAdLoaded() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onReceivedAd.");
            this.zzaP.onAdLoaded(this.zzHK);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdOpened.");
            this.zzaP.onAdOpened(this.zzHJ);
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

    public View getBannerView() {
        return this.zzaV;
    }

    public void onDestroy() {
        if (this.zzHH != null) {
            this.zzHH.onDestroy();
        }
        if (this.zzHI != null) {
            this.zzHI.onDestroy();
        }
    }

    public void onPause() {
        if (this.zzHH != null) {
            this.zzHH.onPause();
        }
        if (this.zzHI != null) {
            this.zzHI.onPause();
        }
    }

    public void onResume() {
        if (this.zzHH != null) {
            this.zzHH.onResume();
        }
        if (this.zzHI != null) {
            this.zzHI.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.zzHH = (CustomEventBanner) zzj(serverParameters.getString("class_name"));
        if (this.zzHH == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzHH.requestBannerAd(context, new zza(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.zzHI = (CustomEventInterstitial) zzj(serverParameters.getString("class_name"));
        if (this.zzHI == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzHI.requestInterstitialAd(context, zza(listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void showInterstitial() {
        this.zzHI.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
