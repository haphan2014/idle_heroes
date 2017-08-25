package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.Map;

@zzgd
public class zzds implements zzdg {
    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        zzdq zzbH = zzo.zzbH();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                zzb.zzaC("Precache video action is missing the src parameter.");
            } else if (zzbH.zzb(com_google_android_gms_internal_zzid)) {
                zzb.zzaC("Precache task already running.");
            } else {
                new zzdp(com_google_android_gms_internal_zzid, str).zzgi();
            }
        } else if (!zzbH.zza(com_google_android_gms_internal_zzid)) {
            zzb.zzaC("Precache abort but no preload task running.");
        }
    }
}
