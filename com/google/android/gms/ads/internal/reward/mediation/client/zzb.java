package com.google.android.gms.ads.internal.reward.mediation.client;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zzb implements MediationRewardedVideoAdListener {
    private final zza zzFj;

    public zzb(zza com_google_android_gms_ads_internal_reward_mediation_client_zza) {
        this.zzFj = com_google_android_gms_ads_internal_reward_mediation_client_zza;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter adapter) {
        zzu.zzbY("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onAdClicked.");
        try {
            this.zzFj.zzj(zze.zzw(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter adapter) {
        zzu.zzbY("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onAdClosed.");
        try {
            this.zzFj.zzi(zze.zzw(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter adapter, int errorCode) {
        zzu.zzbY("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onAdFailedToLoad.");
        try {
            this.zzFj.zzc(zze.zzw(adapter), errorCode);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter adapter) {
        zzu.zzbY("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onAdLeftApplication.");
        try {
            this.zzFj.zzk(zze.zzw(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter adapter) {
        zzu.zzbY("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onAdLoaded.");
        try {
            this.zzFj.zzf(zze.zzw(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter adapter) {
        zzu.zzbY("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onAdOpened.");
        try {
            this.zzFj.zzg(zze.zzw(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter adapter, int errorCode) {
        zzu.zzbY("onInitializationFailed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onInitializationFailed.");
        try {
            this.zzFj.zzb(zze.zzw(adapter), errorCode);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationFailed.", e);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter adapter) {
        zzu.zzbY("onInitializationSucceeded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onInitializationSucceeded.");
        try {
            this.zzFj.zze(zze.zzw(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationSucceeded.", e);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter adapter, RewardItem rewardItem) {
        zzu.zzbY("onRewarded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.zzFj.zza(zze.zzw(adapter), new RewardItemParcel(rewardItem));
                return;
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onRewarded.", e);
                return;
            }
        }
        this.zzFj.zza(zze.zzw(adapter), new RewardItemParcel(adapter.getClass().getName(), 1));
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter adapter) {
        zzu.zzbY("onVideoStarted must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter called onVideoStarted.");
        try {
            this.zzFj.zzh(zze.zzw(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onVideoStarted.", e);
        }
    }
}
