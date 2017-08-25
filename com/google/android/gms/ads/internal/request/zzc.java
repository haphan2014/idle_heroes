package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;

@zzgd
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zzd(AdRequestInfoParcel adRequestInfoParcel);
    }

    public static zzhh zza(final Context context, AdRequestInfoParcel adRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza) {
        return zza(context, adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza, new zzb() {
            public boolean zzd(AdRequestInfoParcel adRequestInfoParcel) {
                return adRequestInfoParcel.zzpJ.zzGJ || GooglePlayServicesUtil.zzae(context);
            }
        });
    }

    static zzhh zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza, zzb com_google_android_gms_ads_internal_request_zzc_zzb) {
        return com_google_android_gms_ads_internal_request_zzc_zzb.zzd(adRequestInfoParcel) ? zzb(context, adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza) : zzc(context, adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
    }

    private static zzhh zzb(Context context, AdRequestInfoParcel adRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Fetching ad response from local ad request service.");
        zzhh com_google_android_gms_ads_internal_request_zzd_zza = new com.google.android.gms.ads.internal.request.zzd.zza(context, adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
        com_google_android_gms_ads_internal_request_zzd_zza.zzgi();
        return com_google_android_gms_ads_internal_request_zzd_zza;
    }

    private static zzhh zzc(Context context, AdRequestInfoParcel adRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Fetching ad response from remote ad request service.");
        if (zzk.zzcA().zzP(context)) {
            return new com.google.android.gms.ads.internal.request.zzd.zzb(context, adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Failed to connect to remote ad request service.");
        return null;
    }
}
