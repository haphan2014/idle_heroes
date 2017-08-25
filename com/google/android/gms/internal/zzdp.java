package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzo;

@zzgd
public class zzdp extends zzhh {
    final zzid zzoA;
    final zzdr zzwB;
    private final String zzwC;

    class C08701 implements Runnable {
        final /* synthetic */ zzdp zzwD;

        C08701(zzdp com_google_android_gms_internal_zzdp) {
            this.zzwD = com_google_android_gms_internal_zzdp;
        }

        public void run() {
            zzo.zzbH().zzb(this.zzwD);
        }
    }

    zzdp(zzid com_google_android_gms_internal_zzid, String str) {
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzwB = new zzdr(com_google_android_gms_internal_zzid);
        this.zzwC = str;
        zzo.zzbH().zza(this);
    }

    public void onStop() {
        this.zzwB.abort();
    }

    public void zzdP() {
        try {
            this.zzwB.zzW(this.zzwC);
        } finally {
            zzhl.zzGk.post(new C08701(this));
        }
    }
}
