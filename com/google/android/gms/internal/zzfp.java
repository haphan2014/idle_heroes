package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzie.zza;

@zzgd
public abstract class zzfp extends zzfs implements zza {
    private final zzie zzBd;
    protected boolean zzBe = false;
    private boolean zzxo = false;

    protected zzfp(Context context, zzha.zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid, zzft.zza com_google_android_gms_internal_zzft_zza) {
        super(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza);
        this.zzBd = com_google_android_gms_internal_zzid.zzgF();
    }

    private boolean zze(long j) throws zza {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 1) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zza("Ad request cancelled.", -1);
        }
    }

    public void onStop() {
        synchronized (this.zzBr) {
            this.zzoA.stopLoading();
            zzo.zzbx().zza(this.zzoA.getWebView());
        }
    }

    public void zza(zzid com_google_android_gms_internal_zzid, boolean z) {
        boolean z2 = true;
        synchronized (this.zzqt) {
            zzb.zzay("WebView finished loading.");
            this.zzBe = true;
            if (z) {
                z2 = false;
            }
            this.zzxo = z2;
            this.zzqt.notify();
        }
    }

    protected void zzg(long j) throws zza {
        while (zze(j)) {
            if (this.zzxo) {
                throw new zza("Received cancellation request from creative.", 0);
            } else if (this.zzBe) {
                return;
            }
        }
        throw new zza("Timed out waiting for WebView to finish loading.", 2);
    }
}
