package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgd
public abstract class zzfs extends zzhh {
    protected final Context mContext;
    protected final com.google.android.gms.internal.zzft.zza zzBq;
    protected final Object zzBr = new Object();
    protected final com.google.android.gms.internal.zzha.zza zzBs;
    protected AdResponseParcel zzBt;
    protected final zzid zzoA;
    protected final Object zzqt = new Object();

    class C09131 implements Runnable {
        final /* synthetic */ zzfs zzBu;

        C09131(zzfs com_google_android_gms_internal_zzfs) {
            this.zzBu = com_google_android_gms_internal_zzfs;
        }

        public void run() {
            this.zzBu.onStop();
        }
    }

    protected static final class zza extends Exception {
        private final int zzBv;

        public zza(String str, int i) {
            super(str);
            this.zzBv = i;
        }

        public int getErrorCode() {
            return this.zzBv;
        }
    }

    protected zzfs(Context context, com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid, com.google.android.gms.internal.zzft.zza com_google_android_gms_internal_zzft_zza) {
        this.mContext = context;
        this.zzBs = com_google_android_gms_internal_zzha_zza;
        this.zzBt = com_google_android_gms_internal_zzha_zza.zzFs;
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzBq = com_google_android_gms_internal_zzft_zza;
    }

    public void onStop() {
    }

    public void zzdP() {
        int errorCode;
        synchronized (this.zzqt) {
            zzb.zzay("AdRendererBackgroundTask started.");
            int i = this.zzBs.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzb.zzaA(e.getMessage());
                } else {
                    zzb.zzaC(e.getMessage());
                }
                if (this.zzBt == null) {
                    this.zzBt = new AdResponseParcel(errorCode);
                } else {
                    this.zzBt = new AdResponseParcel(errorCode, this.zzBt.zzxJ);
                }
                zzhl.zzGk.post(new C09131(this));
                i = errorCode;
            }
            final zzha zzz = zzz(i);
            zzhl.zzGk.post(new Runnable(this) {
                final /* synthetic */ zzfs zzBu;

                public void run() {
                    synchronized (this.zzBu.zzqt) {
                        this.zzBu.zzk(zzz);
                    }
                }
            });
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzk(zzha com_google_android_gms_internal_zzha) {
        this.zzBq.zzb(com_google_android_gms_internal_zzha);
    }

    protected zzha zzz(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzBs.zzFr;
        return new zzha(adRequestInfoParcel.zzCm, this.zzoA, this.zzBt.zzxF, i, this.zzBt.zzxG, this.zzBt.zzCM, this.zzBt.orientation, this.zzBt.zzxJ, adRequestInfoParcel.zzCp, this.zzBt.zzCK, null, null, null, null, null, this.zzBt.zzCL, this.zzBs.zzpN, this.zzBt.zzCJ, this.zzBs.zzFo, this.zzBt.zzCO, this.zzBt.zzCP, this.zzBs.zzFl, null, adRequestInfoParcel.zzCC);
    }
}
