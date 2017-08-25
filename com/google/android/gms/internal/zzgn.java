package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public class zzgn extends zza {
    private final Context mContext;
    private final zzgo zzEM;
    private final VersionInfoParcel zzoM;
    private final Object zzqt = new Object();

    public zzgn(Context context, zzef com_google_android_gms_internal_zzef, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzoM = versionInfoParcel;
        this.zzEM = new zzgo(context, AdSizeParcel.zzcx(), com_google_android_gms_internal_zzef, versionInfoParcel);
    }

    public void destroy() {
        synchronized (this.zzqt) {
            this.zzEM.destroy();
        }
    }

    public boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.zzqt) {
            isLoaded = this.zzEM.isLoaded();
        }
        return isLoaded;
    }

    public void pause() {
        synchronized (this.zzqt) {
            this.zzEM.pause();
        }
    }

    public void resume() {
        synchronized (this.zzqt) {
            this.zzEM.resume();
        }
    }

    public void setUserId(String userId) {
        synchronized (this.zzqt) {
            this.zzEM.setUserId(userId);
        }
    }

    public void show() {
        synchronized (this.zzqt) {
            this.zzEM.zzfK();
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.zzqt) {
            this.zzEM.zza(rewardedVideoAdRequestParcel);
        }
    }

    public void zza(zzd com_google_android_gms_ads_internal_reward_client_zzd) {
        synchronized (this.zzqt) {
            this.zzEM.zza(com_google_android_gms_ads_internal_reward_client_zzd);
        }
    }
}
