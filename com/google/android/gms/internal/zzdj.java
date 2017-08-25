package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.Map;

@zzgd
public class zzdj implements zzdg {
    private final zzdk zzwu;

    public zzdj(zzdk com_google_android_gms_internal_zzdk) {
        this.zzwu = com_google_android_gms_internal_zzdk;
    }

    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        this.zzwu.zzd(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground")));
    }
}
