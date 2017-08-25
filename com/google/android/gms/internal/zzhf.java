package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzo;

@zzgd
public class zzhf {
    private int zzFV;
    private int zzFW;
    private final String zzFv;
    private final zzhc zzpv;
    private final Object zzqt;

    zzhf(zzhc com_google_android_gms_internal_zzhc, String str) {
        this.zzqt = new Object();
        this.zzpv = com_google_android_gms_internal_zzhc;
        this.zzFv = str;
    }

    public zzhf(String str) {
        this(zzo.zzby(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzqt) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzFV);
            bundle.putInt("pmnll", this.zzFW);
        }
        return bundle;
    }

    public void zzf(int i, int i2) {
        synchronized (this.zzqt) {
            this.zzFV = i;
            this.zzFW = i2;
            this.zzpv.zza(this.zzFv, this);
        }
    }
}
