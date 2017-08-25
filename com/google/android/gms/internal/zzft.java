package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzm;

@zzgd
public class zzft {

    public interface zza {
        void zzb(zzha com_google_android_gms_internal_zzha);
    }

    public zzhh zza(Context context, com.google.android.gms.ads.internal.zza com_google_android_gms_ads_internal_zza, com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza, zzan com_google_android_gms_internal_zzan, zzid com_google_android_gms_internal_zzid, zzef com_google_android_gms_internal_zzef, zza com_google_android_gms_internal_zzft_zza) {
        zzhh com_google_android_gms_internal_zzfw;
        AdResponseParcel adResponseParcel = com_google_android_gms_internal_zzha_zza.zzFs;
        if (!adResponseParcel.zzsp) {
            com_google_android_gms_internal_zzfw = adResponseParcel.zzCK ? new zzfw(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzef, com_google_android_gms_internal_zzft_zza) : adResponseParcel.zzCQ ? new zzfr(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza) : (((Boolean) zzbz.zzuj.get()).booleanValue() && zzlk.zzoX() && !zzlk.isAtLeastL() && com_google_android_gms_internal_zzid.zzaN().zzsn) ? new zzfv(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza) : new zzfu(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza);
        } else if (com_google_android_gms_ads_internal_zza instanceof zzm) {
            com_google_android_gms_internal_zzfw = new zzfx(context, (zzm) com_google_android_gms_ads_internal_zza, new zzbc(), com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzan, com_google_android_gms_internal_zzft_zza);
        } else {
            throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (com_google_android_gms_ads_internal_zza != null ? com_google_android_gms_ads_internal_zza.getClass().getName() : "null") + "; Required: NativeAdManager.");
        }
        com_google_android_gms_internal_zzfw.zzgj();
        return com_google_android_gms_internal_zzfw;
    }
}
