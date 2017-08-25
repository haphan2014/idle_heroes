package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzha.zza;

@zzgd
public class zzgq extends zzhh implements zzgr, zzgu {
    private final Context mContext;
    private final zza zzBs;
    private int zzBv = 3;
    private final String zzEO;
    private final zzgp zzEV;
    private final zzgu zzEW;
    private final String zzEX;
    private int zzEY = 0;
    private final Object zzqt;
    private final String zzxQ;

    public zzgq(Context context, String str, String str2, String str3, zza com_google_android_gms_internal_zzha_zza, zzgp com_google_android_gms_internal_zzgp, zzgu com_google_android_gms_internal_zzgu) {
        this.mContext = context;
        this.zzxQ = str;
        this.zzEO = str2;
        this.zzEX = str3;
        this.zzBs = com_google_android_gms_internal_zzha_zza;
        this.zzEV = com_google_android_gms_internal_zzgp;
        this.zzqt = new Object();
        this.zzEW = com_google_android_gms_internal_zzgu;
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzqt) {
                if (this.zzEY != 0) {
                    return;
                } else if (!zze(j)) {
                    return;
                }
            }
        }
    }

    public void onStop() {
    }

    public void zzI(int i) {
        zzb(this.zzxQ, 0);
    }

    public void zzap(String str) {
        synchronized (this.zzqt) {
            this.zzEY = 1;
            this.zzqt.notify();
        }
    }

    public void zzb(String str, int i) {
        synchronized (this.zzqt) {
            this.zzEY = 2;
            this.zzBv = i;
            this.zzqt.notify();
        }
    }

    public void zzdP() {
        if (this.zzEV != null && this.zzEV.zzfN() != null && this.zzEV.zzfM() != null) {
            final zzgt zzfN = this.zzEV.zzfN();
            zzfN.zza((zzgu) this);
            zzfN.zza((zzgr) this);
            final AdRequestParcel adRequestParcel = this.zzBs.zzFr.zzCm;
            final zzeg zzfM = this.zzEV.zzfM();
            try {
                if (zzfM.isInitialized()) {
                    com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable(this) {
                        final /* synthetic */ zzgq zzFa;

                        public void run() {
                            try {
                                zzfM.zza(adRequestParcel, this.zzFa.zzEX);
                            } catch (Throwable e) {
                                zzb.zzd("Fail to load ad from adapter.", e);
                                this.zzFa.zzb(this.zzFa.zzxQ, 0);
                            }
                        }
                    });
                } else {
                    com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable(this) {
                        final /* synthetic */ zzgq zzFa;

                        public void run() {
                            try {
                                zzfM.zza(zze.zzw(this.zzFa.mContext), adRequestParcel, this.zzFa.zzEO, zzfN, this.zzFa.zzEX);
                            } catch (Throwable e) {
                                zzb.zzd("Fail to initialize adapter " + this.zzFa.zzxQ, e);
                                this.zzFa.zzb(this.zzFa.zzxQ, 0);
                            }
                        }
                    });
                }
            } catch (Throwable e) {
                zzb.zzd("Fail to check if adapter is initialized.", e);
                zzb(this.zzxQ, 0);
            }
            zzk(zzo.zzbz().elapsedRealtime());
            zzfN.zza(null);
            zzfN.zza(null);
            if (this.zzEY == 1) {
                this.zzEW.zzap(this.zzxQ);
            } else {
                this.zzEW.zzb(this.zzxQ, this.zzBv);
            }
        }
    }

    protected boolean zze(long j) {
        long elapsedRealtime = 20000 - (zzo.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void zzfO() {
        this.zzEV.zzfN();
        AdRequestParcel adRequestParcel = this.zzBs.zzFr.zzCm;
        try {
            this.zzEV.zzfM().zza(adRequestParcel, this.zzEX);
        } catch (Throwable e) {
            zzb.zzd("Fail to load ad from adapter.", e);
            zzb(this.zzxQ, 0);
        }
    }
}
