package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgd
public final class zzem<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzeh zzyg;

    class C08941 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C08941(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    class C08952 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C08952(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C08963 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C08963(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C08974 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C08974(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    class C08996 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C08996(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdLeftApplication();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C09007 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C09007(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C09018 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C09018(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C09029 implements Runnable {
        final /* synthetic */ zzem zzyj;

        C09029(zzem com_google_android_gms_internal_zzem) {
            this.zzyj = com_google_android_gms_internal_zzem;
        }

        public void run() {
            try {
                this.zzyj.zzyg.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzem(zzeh com_google_android_gms_internal_zzeh) {
        this.zzyg = com_google_android_gms_internal_zzeh;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onClick.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdClicked();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzb.zzaC("onClick must be called on the main UI thread.");
        zza.zzGF.post(new C08941(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onDismissScreen.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaC("onDismissScreen must be called on the main UI thread.");
        zza.zzGF.post(new C08974(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onDismissScreen.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaC("onDismissScreen must be called on the main UI thread.");
        zza.zzGF.post(new C09029(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        zzb.zzay("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzem zzyj;

            public void run() {
                try {
                    this.zzyj.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        zzb.zzay("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaC("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzem zzyj;

            public void run() {
                try {
                    this.zzyj.zzyg.onAdFailedToLoad(zzen.zza(errorCode));
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
        zza.zzGF.post(new C08996(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onLeaveApplication.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaC("onLeaveApplication must be called on the main UI thread.");
        zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzem zzyj;

            {
                this.zzyj = r1;
            }

            public void run() {
                try {
                    this.zzyj.zzyg.onAdLeftApplication();
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onPresentScreen.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaC("onPresentScreen must be called on the main UI thread.");
        zza.zzGF.post(new C09007(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onPresentScreen.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaC("onPresentScreen must be called on the main UI thread.");
        zza.zzGF.post(new C08952(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzay("Adapter called onReceivedAd.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaC("onReceivedAd must be called on the main UI thread.");
        zza.zzGF.post(new C09018(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzay("Adapter called onReceivedAd.");
        if (zzk.zzcA().zzgw()) {
            try {
                this.zzyg.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaC("onReceivedAd must be called on the main UI thread.");
        zza.zzGF.post(new C08963(this));
    }
}
