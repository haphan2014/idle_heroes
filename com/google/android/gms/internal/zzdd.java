package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzgd
public final class zzdd implements zzdg {
    private final zzde zzvU;

    public zzdd(zzde com_google_android_gms_internal_zzde) {
        this.zzvU = com_google_android_gms_internal_zzde;
    }

    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzb.zzaC("App event with no name parameter.");
        } else {
            this.zzvU.onAppEvent(str, (String) map.get("info"));
        }
    }
}
