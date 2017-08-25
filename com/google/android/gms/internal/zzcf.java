package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzch.zza;

@zzgd
public final class zzcf extends zza {
    private final zzf zzuS;
    private final String zzuT;
    private final String zzuU;

    public zzcf(zzf com_google_android_gms_ads_internal_zzf, String str, String str2) {
        this.zzuS = com_google_android_gms_ads_internal_zzf;
        this.zzuT = str;
        this.zzuU = str2;
    }

    public String getContent() {
        return this.zzuU;
    }

    public void recordClick() {
        this.zzuS.recordClick();
    }

    public void recordImpression() {
        this.zzuS.recordImpression();
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd) {
        if (com_google_android_gms_dynamic_zzd != null) {
            this.zzuS.zzc((View) zze.zzn(com_google_android_gms_dynamic_zzd));
        }
    }

    public String zzdt() {
        return this.zzuT;
    }
}
