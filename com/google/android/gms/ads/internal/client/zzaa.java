package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzee;

public class zzaa {
    private static final Object zzoW = new Object();
    private static zzaa zzta;
    private zzv zztb;
    private RewardedVideoAd zztc;

    private zzaa() {
    }

    public static zzaa zzcP() {
        zzaa com_google_android_gms_ads_internal_client_zzaa;
        synchronized (zzoW) {
            if (zzta == null) {
                zzta = new zzaa();
            }
            com_google_android_gms_ads_internal_client_zzaa = zzta;
        }
        return com_google_android_gms_ads_internal_client_zzaa;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzoW) {
            if (this.zztc != null) {
                rewardedVideoAd = this.zztc;
            } else {
                this.zztc = new zzi(context, zzk.zzcF().zza(context, new zzee()));
                rewardedVideoAd = this.zztc;
            }
        }
        return rewardedVideoAd;
    }

    public void zza(Context context, String str, zzab com_google_android_gms_ads_internal_client_zzab) {
        synchronized (zzoW) {
            if (this.zztb != null) {
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            } else if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("applicationCode cannot be empty.");
            } else {
                try {
                    this.zztb = zzk.zzcD().zzt(context);
                    this.zztb.zza(str, com_google_android_gms_ads_internal_client_zzab == null ? null : new MobileAdsSettingsParcel(com_google_android_gms_ads_internal_client_zzab));
                } catch (RemoteException e) {
                    zzb.zzaC("Fail to initialize mobile ads setting manager");
                }
            }
        }
    }
}
