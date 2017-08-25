package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zzk {
    private static final Object zzoW = new Object();
    private static zzk zzss;
    private final zza zzst = new zza();
    private final zze zzsu = new zze();
    private final zzl zzsv = new zzl();
    private final zzac zzsw = new zzac();
    private final zzcy zzsx = new zzcy();
    private final zzf zzsy = new zzf();

    static {
        zza(new zzk());
    }

    protected zzk() {
    }

    protected static void zza(zzk com_google_android_gms_ads_internal_client_zzk) {
        synchronized (zzoW) {
            zzss = com_google_android_gms_ads_internal_client_zzk;
        }
    }

    public static zza zzcA() {
        return zzcz().zzst;
    }

    public static zze zzcB() {
        return zzcz().zzsu;
    }

    public static zzl zzcC() {
        return zzcz().zzsv;
    }

    public static zzac zzcD() {
        return zzcz().zzsw;
    }

    public static zzcy zzcE() {
        return zzcz().zzsx;
    }

    public static zzf zzcF() {
        return zzcz().zzsy;
    }

    private static zzk zzcz() {
        zzk com_google_android_gms_ads_internal_client_zzk;
        synchronized (zzoW) {
            com_google_android_gms_ads_internal_client_zzk = zzss;
        }
        return com_google_android_gms_ads_internal_client_zzk;
    }
}
