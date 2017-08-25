package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.internal.reward.client.zzd.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzg extends zza {
    private final RewardedVideoAdListener zzES;

    public zzg(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzES = rewardedVideoAdListener;
    }

    public void onRewardedVideoAdClosed() {
        if (this.zzES != null) {
            this.zzES.onRewardedVideoAdClosed();
        }
    }

    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        if (this.zzES != null) {
            this.zzES.onRewardedVideoAdFailedToLoad(errorCode);
        }
    }

    public void onRewardedVideoAdLeftApplication() {
        if (this.zzES != null) {
            this.zzES.onRewardedVideoAdLeftApplication();
        }
    }

    public void onRewardedVideoAdLoaded() {
        if (this.zzES != null) {
            this.zzES.onRewardedVideoAdLoaded();
        }
    }

    public void onRewardedVideoAdOpened() {
        if (this.zzES != null) {
            this.zzES.onRewardedVideoAdOpened();
        }
    }

    public void onRewardedVideoStarted() {
        if (this.zzES != null) {
            this.zzES.onRewardedVideoStarted();
        }
    }

    public void zza(zza com_google_android_gms_ads_internal_reward_client_zza) {
        if (this.zzES != null) {
            this.zzES.onRewarded(new zze(com_google_android_gms_ads_internal_reward_client_zza));
        }
    }
}
