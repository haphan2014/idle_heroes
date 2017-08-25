package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhl;
import java.lang.ref.WeakReference;

@zzgd
public class zzn {
    private final zza zzpg;
    private AdRequestParcel zzph;
    private boolean zzpi;
    private boolean zzpj;
    private long zzpk;
    private final Runnable zzx;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzn(zza com_google_android_gms_ads_internal_zza) {
        this(com_google_android_gms_ads_internal_zza, new zza(zzhl.zzGk));
    }

    zzn(zza com_google_android_gms_ads_internal_zza, zza com_google_android_gms_ads_internal_zzn_zza) {
        this.zzpi = false;
        this.zzpj = false;
        this.zzpk = 0;
        this.zzpg = com_google_android_gms_ads_internal_zzn_zza;
        final WeakReference weakReference = new WeakReference(com_google_android_gms_ads_internal_zza);
        this.zzx = new Runnable(this) {
            final /* synthetic */ zzn zzpm;

            public void run() {
                this.zzpm.zzpi = false;
                zza com_google_android_gms_ads_internal_zza = (zza) weakReference.get();
                if (com_google_android_gms_ads_internal_zza != null) {
                    com_google_android_gms_ads_internal_zza.zzd(this.zzpm.zzph);
                }
            }
        };
    }

    public void cancel() {
        this.zzpi = false;
        this.zzpg.removeCallbacks(this.zzx);
    }

    public void pause() {
        this.zzpj = true;
        if (this.zzpi) {
            this.zzpg.removeCallbacks(this.zzx);
        }
    }

    public void resume() {
        this.zzpj = false;
        if (this.zzpi) {
            this.zzpi = false;
            zza(this.zzph, this.zzpk);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        if (this.zzpi) {
            zzb.zzaC("An ad refresh is already scheduled.");
            return;
        }
        this.zzph = adRequestParcel;
        this.zzpi = true;
        this.zzpk = j;
        if (!this.zzpj) {
            zzb.zzaA("Scheduling ad refresh " + j + " milliseconds from now.");
            this.zzpg.postDelayed(this.zzx, j);
        }
    }

    public boolean zzbp() {
        return this.zzpi;
    }

    public void zzf(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000);
    }
}
