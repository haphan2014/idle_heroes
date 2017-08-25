package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    private static final zzl zzQW = new zzl("RequestTracker");
    public static final Object zzVr = new Object();
    private long zzTM = -1;
    private long zzVo;
    private long zzVp = 0;
    private zzo zzVq;

    public zzp(long j) {
        this.zzVo = j;
    }

    private void zzmd() {
        this.zzTM = -1;
        this.zzVq = null;
        this.zzVp = 0;
    }

    public void clear() {
        synchronized (zzVr) {
            if (this.zzTM != -1) {
                zzmd();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzVr) {
            z = this.zzTM != -1 && this.zzTM == j;
        }
        return z;
    }

    public void zza(long j, zzo com_google_android_gms_cast_internal_zzo) {
        synchronized (zzVr) {
            zzo com_google_android_gms_cast_internal_zzo2 = this.zzVq;
            long j2 = this.zzTM;
            this.zzTM = j;
            this.zzVq = com_google_android_gms_cast_internal_zzo;
            this.zzVp = SystemClock.elapsedRealtime();
        }
        if (com_google_android_gms_cast_internal_zzo2 != null) {
            com_google_android_gms_cast_internal_zzo2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo com_google_android_gms_cast_internal_zzo = null;
        synchronized (zzVr) {
            if (this.zzTM == -1 || this.zzTM != j) {
                z = false;
            } else {
                zzQW.zzb("request %d completed", Long.valueOf(this.zzTM));
                com_google_android_gms_cast_internal_zzo = this.zzVq;
                zzmd();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo com_google_android_gms_cast_internal_zzo;
        boolean z = true;
        long j2 = 0;
        synchronized (zzVr) {
            if (this.zzTM == -1 || j - this.zzVp < this.zzVo) {
                z = false;
                com_google_android_gms_cast_internal_zzo = null;
            } else {
                zzQW.zzb("request %d timed out", Long.valueOf(this.zzTM));
                j2 = this.zzTM;
                com_google_android_gms_cast_internal_zzo = this.zzVq;
                zzmd();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzme() {
        boolean z;
        synchronized (zzVr) {
            z = this.zzTM != -1;
        }
        return z;
    }
}
