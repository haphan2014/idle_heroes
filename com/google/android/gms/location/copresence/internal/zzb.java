package com.google.android.gms.location.copresence.internal;

import android.content.Context;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzn;

public class zzb {
    private final Context mContext;
    private final String zzOe;
    private final String zzOx;
    private final zzn<zzg> zzayq;
    private final CopresenceApiOptions zzayr;
    private zzc zzays = null;

    private zzb(Context context, String str, String str2, zzn<zzg> com_google_android_gms_location_internal_zzn_com_google_android_gms_location_internal_zzg, CopresenceApiOptions copresenceApiOptions) {
        this.mContext = context;
        this.zzOx = str;
        this.zzayq = com_google_android_gms_location_internal_zzn_com_google_android_gms_location_internal_zzg;
        this.zzOe = str2;
        this.zzayr = copresenceApiOptions;
    }

    public static zzb zza(Context context, String str, String str2, zzn<zzg> com_google_android_gms_location_internal_zzn_com_google_android_gms_location_internal_zzg, CopresenceApiOptions copresenceApiOptions) {
        return new zzb(context, str, str2, com_google_android_gms_location_internal_zzn_com_google_android_gms_location_internal_zzg, copresenceApiOptions);
    }
}
