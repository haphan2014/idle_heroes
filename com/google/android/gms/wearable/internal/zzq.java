package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.internal.zzaq.zza;

public final class zzq extends zza {
    private zzj zzaTY;
    private zzr zzaUc;
    private final Object zzqt = new Object();

    public void zza(zzr com_google_android_gms_wearable_internal_zzr) {
        synchronized (this.zzqt) {
            this.zzaUc = (zzr) zzu.zzu(com_google_android_gms_wearable_internal_zzr);
            zzj com_google_android_gms_wearable_internal_zzj = this.zzaTY;
        }
        if (com_google_android_gms_wearable_internal_zzj != null) {
            com_google_android_gms_wearable_internal_zzr.zzb(com_google_android_gms_wearable_internal_zzj);
        }
    }

    public void zzw(int i, int i2) {
        synchronized (this.zzqt) {
            zzr com_google_android_gms_wearable_internal_zzr = this.zzaUc;
            zzj com_google_android_gms_wearable_internal_zzj = new zzj(i, i2);
            this.zzaTY = com_google_android_gms_wearable_internal_zzj;
        }
        if (com_google_android_gms_wearable_internal_zzr != null) {
            com_google_android_gms_wearable_internal_zzr.zzb(com_google_android_gms_wearable_internal_zzj);
        }
    }
}
