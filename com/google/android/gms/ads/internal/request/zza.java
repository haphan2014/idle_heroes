package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;

@zzgd
public class zza {

    public interface zza {
        void zza(com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza);
    }

    public zzhh zza(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, zzan com_google_android_gms_internal_zzan, zza com_google_android_gms_ads_internal_request_zza_zza) {
        zzhh com_google_android_gms_ads_internal_request_zzb = (!((Boolean) zzbz.zzuu.get()).booleanValue() || com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzCm.extras.getBundle("sdk_less_server_data") == null) ? new zzb(context, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, com_google_android_gms_internal_zzan, com_google_android_gms_ads_internal_request_zza_zza) : new zzl(context, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, com_google_android_gms_ads_internal_request_zza_zza);
        com_google_android_gms_ads_internal_request_zzb.zzgj();
        return com_google_android_gms_ads_internal_request_zzb;
    }
}
