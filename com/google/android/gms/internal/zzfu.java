package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzha.zza;
import com.heyzap.http.AsyncHttpResponseHandler;

@zzgd
public class zzfu extends zzfp {

    class C09151 implements Runnable {
        final /* synthetic */ zzfu zzBw;

        C09151(zzfu com_google_android_gms_internal_zzfu) {
            this.zzBw = com_google_android_gms_internal_zzfu;
        }

        public void run() {
            synchronized (this.zzBw.zzqt) {
                if (this.zzBw.zzBt.errorCode != -2) {
                    return;
                }
                this.zzBw.zzoA.zzgF().zza(this.zzBw);
                this.zzBw.zzfn();
                zzb.zzaB("Loading HTML in WebView.");
                this.zzBw.zzoA.loadDataWithBaseURL(zzo.zzbv().zzat(this.zzBw.zzBt.zzzG), this.zzBw.zzBt.zzCI, "text/html", AsyncHttpResponseHandler.DEFAULT_CHARSET, null);
            }
        }
    }

    zzfu(Context context, zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid, zzft.zza com_google_android_gms_internal_zzft_zza) {
        super(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza);
    }

    protected void zzfn() {
    }

    protected void zzh(long j) throws zza {
        zzhl.zzGk.post(new C09151(this));
        zzg(j);
    }
}
