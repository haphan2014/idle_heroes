package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@zzgd
public final class zzdn implements zzdg {
    private final zzd zzww;
    private final zzep zzwx;
    private final zzdi zzwz;

    public zzdn(zzdi com_google_android_gms_internal_zzdi, zzd com_google_android_gms_ads_internal_zzd, zzep com_google_android_gms_internal_zzep) {
        this.zzwz = com_google_android_gms_internal_zzdi;
        this.zzww = com_google_android_gms_ads_internal_zzd;
        this.zzwx = com_google_android_gms_internal_zzep;
    }

    private static boolean zzd(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    private static int zze(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzo.zzbx().zzgr();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzo.zzbx().zzgq();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzo.zzbx().zzgs();
            }
        }
        return -1;
    }

    private void zzm(boolean z) {
        if (this.zzwx != null) {
            this.zzwx.zzn(z);
        }
    }

    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            zzb.zzaC("Action missing from an open GMSG.");
        } else if (this.zzww == null || this.zzww.zzbd()) {
            zzie zzgF = com_google_android_gms_internal_zzid.zzgF();
            if ("expand".equalsIgnoreCase(str)) {
                if (com_google_android_gms_internal_zzid.zzgJ()) {
                    zzb.zzaC("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzm(false);
                zzgF.zza(zzd(map), zze(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                zzm(false);
                if (str != null) {
                    zzgF.zza(zzd(map), zze(map), str);
                } else {
                    zzgF.zza(zzd(map), zze(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.zzwz == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.zzwz.zza(str, new ArrayList());
                } else {
                    this.zzwz.zza(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else {
                zzm(true);
                com_google_android_gms_internal_zzid.zzgH();
                str = (String) map.get("u");
                zzgF.zza(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str) ? zzo.zzbv().zza(com_google_android_gms_internal_zzid, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.zzww.zzo((String) map.get("u"));
        }
    }
}
