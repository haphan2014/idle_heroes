package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.Map;

@zzgd
public class zzeq {
    private final zzid zzoA;
    private final boolean zzyJ;
    private final String zzyK;

    public zzeq(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzyK = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzyJ = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.zzyJ = true;
        }
    }

    public void execute() {
        if (this.zzoA == null) {
            zzb.zzaC("AdWebView is null");
            return;
        }
        int zzgr = "portrait".equalsIgnoreCase(this.zzyK) ? zzo.zzbx().zzgr() : "landscape".equalsIgnoreCase(this.zzyK) ? zzo.zzbx().zzgq() : this.zzyJ ? -1 : zzo.zzbx().zzgs();
        this.zzoA.setRequestedOrientation(zzgr);
    }
}
