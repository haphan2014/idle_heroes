package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;

public class zzcc {
    private boolean zzuy = false;

    private zzcb zzb(zzca com_google_android_gms_internal_zzca, int i) {
        zzcb com_google_android_gms_internal_zzcb = new zzcb(com_google_android_gms_internal_zzca.getContext(), com_google_android_gms_internal_zzca.zzbR(), com_google_android_gms_internal_zzca.zzdd(), com_google_android_gms_internal_zzca.zzde(), com_google_android_gms_internal_zzca.zzdf(), com_google_android_gms_internal_zzca.zzdg(), com_google_android_gms_internal_zzca.zzdh(), com_google_android_gms_internal_zzca.zzdi(), i);
        this.zzuy = true;
        return com_google_android_gms_internal_zzcb;
    }

    public zzcb zza(zzca com_google_android_gms_internal_zzca) {
        return zza(com_google_android_gms_internal_zzca, 1);
    }

    public zzcb zza(zzca com_google_android_gms_internal_zzca, int i) {
        if (com_google_android_gms_internal_zzca == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!com_google_android_gms_internal_zzca.zzdc()) {
            zzb.zzaA("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (com_google_android_gms_internal_zzca.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(com_google_android_gms_internal_zzca.zzbR())) {
            return zzb(com_google_android_gms_internal_zzca, i);
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }

    public zzcb zzb(zzca com_google_android_gms_internal_zzca) {
        return zza(com_google_android_gms_internal_zzca, 2);
    }

    public boolean zzdc() {
        return this.zzuy;
    }
}
