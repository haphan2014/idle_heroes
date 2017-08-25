package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgd
public class zzgt extends zza {
    private zzgu zzEW;
    private zzgr zzFc;
    private zzgs zzFd;

    public zzgt(zzgs com_google_android_gms_internal_zzgs) {
        this.zzFd = com_google_android_gms_internal_zzgs;
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, RewardItemParcel rewardItemParcel) {
        if (this.zzFd != null) {
            this.zzFd.zza(rewardItemParcel);
        }
    }

    public void zza(zzgr com_google_android_gms_internal_zzgr) {
        this.zzFc = com_google_android_gms_internal_zzgr;
    }

    public void zza(zzgu com_google_android_gms_internal_zzgu) {
        this.zzEW = com_google_android_gms_internal_zzgu;
    }

    public void zzb(zzd com_google_android_gms_dynamic_zzd, int i) {
        if (this.zzFc != null) {
            this.zzFc.zzI(i);
        }
    }

    public void zzc(zzd com_google_android_gms_dynamic_zzd, int i) {
        if (this.zzEW != null) {
            this.zzEW.zzb(zze.zzn(com_google_android_gms_dynamic_zzd).getClass().getName(), i);
        }
    }

    public void zze(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzFc != null) {
            this.zzFc.zzfO();
        }
    }

    public void zzf(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzEW != null) {
            this.zzEW.zzap(zze.zzn(com_google_android_gms_dynamic_zzd).getClass().getName());
        }
    }

    public void zzg(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoAdOpened();
        }
    }

    public void zzh(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoStarted();
        }
    }

    public void zzi(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoAdClosed();
        }
    }

    public void zzj(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzFd != null) {
            this.zzFd.zzfL();
        }
    }

    public void zzk(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzFd != null) {
            this.zzFd.onRewardedVideoAdLeftApplication();
        }
    }
}
