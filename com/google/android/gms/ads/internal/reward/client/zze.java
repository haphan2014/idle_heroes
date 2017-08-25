package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;

public class zze implements RewardItem {
    private final zza zzER;

    public zze(zza com_google_android_gms_ads_internal_reward_client_zza) {
        this.zzER = com_google_android_gms_ads_internal_reward_client_zza;
    }

    public int getAmount() {
        int i = 0;
        if (this.zzER != null) {
            try {
                i = this.zzER.getAmount();
            } catch (Throwable e) {
                zzb.zzd("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }

    public String getType() {
        String str = null;
        if (this.zzER != null) {
            try {
                str = this.zzER.getType();
            } catch (Throwable e) {
                zzb.zzd("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }
}
