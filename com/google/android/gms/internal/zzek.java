package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.zzu;

@zzgd
public final class zzek implements MediationBannerListener, MediationInterstitialListener {
    private final zzeh zzyg;

    public zzek(zzeh com_google_android_gms_internal_zzeh) {
        this.zzyg = com_google_android_gms_internal_zzeh;
    }

    public void onAdClicked(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdClicked must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClicked.");
        try {
            this.zzyg.onAdClicked();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdClicked must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClicked.");
        try {
            this.zzyg.onAdClicked();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdClosed must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClosed.");
        try {
            this.zzyg.onAdClosed();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdClosed must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdClosed.");
        try {
            this.zzyg.onAdClosed();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter adapter, int errorCode) {
        zzu.zzbY("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdFailedToLoad with error. " + errorCode);
        try {
            this.zzyg.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter adapter, int errorCode) {
        zzu.zzbY("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdFailedToLoad with error " + errorCode + ".");
        try {
            this.zzyg.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLeftApplication.");
        try {
            this.zzyg.onAdLeftApplication();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLeftApplication.");
        try {
            this.zzyg.onAdLeftApplication();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdLoaded must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLoaded.");
        try {
            this.zzyg.onAdLoaded();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdLoaded must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdLoaded.");
        try {
            this.zzyg.onAdLoaded();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter adapter) {
        zzu.zzbY("onAdOpened must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdOpened.");
        try {
            this.zzyg.onAdOpened();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter adapter) {
        zzu.zzbY("onAdOpened must be called on the main UI thread.");
        zzb.zzay("Adapter called onAdOpened.");
        try {
            this.zzyg.onAdOpened();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }
}
