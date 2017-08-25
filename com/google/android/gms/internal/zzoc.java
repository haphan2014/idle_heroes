package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class zzoc extends zznq<zzoc> {
    public boolean zzaEI;
    public String zzakM;

    public String getDescription() {
        return this.zzakM;
    }

    public void setDescription(String description) {
        this.zzakM = description;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.zzakM);
        hashMap.put("fatal", Boolean.valueOf(this.zzaEI));
        return zznq.zzy(hashMap);
    }

    public void zza(zzoc com_google_android_gms_internal_zzoc) {
        if (!TextUtils.isEmpty(this.zzakM)) {
            com_google_android_gms_internal_zzoc.setDescription(this.zzakM);
        }
        if (this.zzaEI) {
            com_google_android_gms_internal_zzoc.zzag(this.zzaEI);
        }
    }

    public void zzag(boolean z) {
        this.zzaEI = z;
    }

    public boolean zzwz() {
        return this.zzaEI;
    }
}
