package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhx.zzc;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgd
public class zzhy<T> implements zzhx<T> {
    protected final BlockingQueue<zza> zzGU = new LinkedBlockingQueue();
    protected T zzGV;
    private final Object zzqt = new Object();
    protected int zzwS = 0;

    class zza {
        public final zzc<T> zzGW;
        public final com.google.android.gms.internal.zzhx.zza zzGX;
        final /* synthetic */ zzhy zzGY;

        public zza(zzhy com_google_android_gms_internal_zzhy, zzc<T> com_google_android_gms_internal_zzhx_zzc_T, com.google.android.gms.internal.zzhx.zza com_google_android_gms_internal_zzhx_zza) {
            this.zzGY = com_google_android_gms_internal_zzhy;
            this.zzGW = com_google_android_gms_internal_zzhx_zzc_T;
            this.zzGX = com_google_android_gms_internal_zzhx_zza;
        }
    }

    public int getStatus() {
        return this.zzwS;
    }

    public void reject() {
        synchronized (this.zzqt) {
            if (this.zzwS != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzwS = -1;
            for (zza com_google_android_gms_internal_zzhy_zza : this.zzGU) {
                com_google_android_gms_internal_zzhy_zza.zzGX.run();
            }
            this.zzGU.clear();
        }
    }

    public void zza(zzc<T> com_google_android_gms_internal_zzhx_zzc_T, com.google.android.gms.internal.zzhx.zza com_google_android_gms_internal_zzhx_zza) {
        synchronized (this.zzqt) {
            if (this.zzwS == 1) {
                com_google_android_gms_internal_zzhx_zzc_T.zzc(this.zzGV);
            } else if (this.zzwS == -1) {
                com_google_android_gms_internal_zzhx_zza.run();
            } else if (this.zzwS == 0) {
                this.zzGU.add(new zza(this, com_google_android_gms_internal_zzhx_zzc_T, com_google_android_gms_internal_zzhx_zza));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzqt) {
            if (this.zzwS != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzGV = t;
            this.zzwS = 1;
            for (zza com_google_android_gms_internal_zzhy_zza : this.zzGU) {
                com_google_android_gms_internal_zzhy_zza.zzGW.zzc(t);
            }
            this.zzGU.clear();
        }
    }
}
