package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import java.util.HashMap;
import java.util.Map;
import org.nexage.sourcekit.mraid.MRAIDNativeFeature;

@zzgd
public class zzdm implements zzdg {
    static final Map<String, Integer> zzwy = new HashMap();
    private final zzd zzww;
    private final zzep zzwx;

    static {
        zzwy.put("resize", Integer.valueOf(1));
        zzwy.put("playVideo", Integer.valueOf(2));
        zzwy.put(MRAIDNativeFeature.STORE_PICTURE, Integer.valueOf(3));
        zzwy.put("createCalendarEvent", Integer.valueOf(4));
        zzwy.put("setOrientationProperties", Integer.valueOf(5));
        zzwy.put("closeResizedAd", Integer.valueOf(6));
    }

    public zzdm(zzd com_google_android_gms_ads_internal_zzd, zzep com_google_android_gms_internal_zzep) {
        this.zzww = com_google_android_gms_ads_internal_zzd;
        this.zzwx = com_google_android_gms_internal_zzep;
    }

    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        int intValue = ((Integer) zzwy.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.zzww == null || this.zzww.zzbd()) {
            switch (intValue) {
                case 1:
                    this.zzwx.zzh(map);
                    return;
                case 3:
                    new zzer(com_google_android_gms_internal_zzid, map).execute();
                    return;
                case 4:
                    new zzeo(com_google_android_gms_internal_zzid, map).execute();
                    return;
                case 5:
                    new zzeq(com_google_android_gms_internal_zzid, map).execute();
                    return;
                case 6:
                    this.zzwx.zzn(true);
                    return;
                default:
                    zzb.zzaA("Unknown MRAID command called.");
                    return;
            }
        }
        this.zzww.zzo(null);
    }
}
