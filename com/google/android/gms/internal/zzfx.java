package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.internal.zzft.zza;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgd
public class zzfx extends zzhh {
    private final zzfy zzBC;
    private Future<zzha> zzBD;
    private final zza zzBq;
    private final zzha.zza zzBs;
    private final AdResponseParcel zzBt;
    private final Object zzqt;

    public zzfx(Context context, zzm com_google_android_gms_ads_internal_zzm, zzbc com_google_android_gms_internal_zzbc, zzha.zza com_google_android_gms_internal_zzha_zza, zzan com_google_android_gms_internal_zzan, zza com_google_android_gms_internal_zzft_zza) {
        this(com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzft_zza, new zzfy(context, com_google_android_gms_ads_internal_zzm, com_google_android_gms_internal_zzbc, new zzho(context), com_google_android_gms_internal_zzan, com_google_android_gms_internal_zzha_zza));
    }

    zzfx(zzha.zza com_google_android_gms_internal_zzha_zza, zza com_google_android_gms_internal_zzft_zza, zzfy com_google_android_gms_internal_zzfy) {
        this.zzqt = new Object();
        this.zzBs = com_google_android_gms_internal_zzha_zza;
        this.zzBt = com_google_android_gms_internal_zzha_zza.zzFs;
        this.zzBq = com_google_android_gms_internal_zzft_zza;
        this.zzBC = com_google_android_gms_internal_zzfy;
    }

    private zzha zzA(int i) {
        return new zzha(this.zzBs.zzFr.zzCm, null, null, i, null, null, this.zzBt.orientation, this.zzBt.zzxJ, this.zzBs.zzFr.zzCp, false, null, null, null, null, null, this.zzBt.zzCL, this.zzBs.zzpN, this.zzBt.zzCJ, this.zzBs.zzFo, this.zzBt.zzCO, this.zzBt.zzCP, this.zzBs.zzFl, null, this.zzBs.zzFr.zzCC);
    }

    public void onStop() {
        synchronized (this.zzqt) {
            if (this.zzBD != null) {
                this.zzBD.cancel(true);
            }
        }
    }

    public void zzdP() {
        zzha com_google_android_gms_internal_zzha;
        int i;
        try {
            synchronized (this.zzqt) {
                this.zzBD = zzhk.zza(this.zzBC);
            }
            com_google_android_gms_internal_zzha = (zzha) this.zzBD.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzb.zzaC("Timed out waiting for native ad.");
            this.zzBD.cancel(true);
            i = 2;
            com_google_android_gms_internal_zzha = null;
        } catch (ExecutionException e2) {
            i = 0;
            com_google_android_gms_internal_zzha = null;
        } catch (InterruptedException e3) {
            com_google_android_gms_internal_zzha = null;
            i = -1;
        } catch (CancellationException e4) {
            com_google_android_gms_internal_zzha = null;
            i = -1;
        }
        if (com_google_android_gms_internal_zzha == null) {
            com_google_android_gms_internal_zzha = zzA(i);
        }
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzfx zzBE;

            public void run() {
                this.zzBE.zzBq.zzb(com_google_android_gms_internal_zzha);
            }
        });
    }
}
