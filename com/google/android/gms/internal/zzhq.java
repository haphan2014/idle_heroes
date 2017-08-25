package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzo;

public class zzhq {
    private long zzGC;
    private long zzGD = Long.MIN_VALUE;
    private Object zzqt = new Object();

    public zzhq(long j) {
        this.zzGC = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzqt) {
            long elapsedRealtime = zzo.zzbz().elapsedRealtime();
            if (this.zzGD + this.zzGC > elapsedRealtime) {
                z = false;
            } else {
                this.zzGD = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
