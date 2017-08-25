package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha.zza;

@zzgd
public class zzfr extends zzfp {
    zzfr(Context context, zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid, zzft.zza com_google_android_gms_internal_zzft_zza) {
        super(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza);
    }

    protected void zzh(long j) throws zza {
        int i;
        int i2;
        AdSizeParcel zzaN = this.zzoA.zzaN();
        if (zzaN.zzsn) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = zzaN.widthPixels;
            i2 = zzaN.heightPixels;
        }
        final zzfq com_google_android_gms_internal_zzfq = new zzfq(this, this.zzoA, i, i2);
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzfr zzBp;

            public void run() {
                synchronized (this.zzBp.zzqt) {
                    if (this.zzBp.zzBt.errorCode != -2) {
                        return;
                    }
                    this.zzBp.zzoA.zzgF().zza(this.zzBp);
                    com_google_android_gms_internal_zzfq.zza(this.zzBp.zzBt);
                }
            }
        });
        zzg(j);
        if (com_google_android_gms_internal_zzfq.zzfl()) {
            zzb.zzay("Ad-Network indicated no fill with passback URL.");
            throw new zza("AdNetwork sent passback url", 3);
        } else if (!com_google_android_gms_internal_zzfq.zzfm()) {
            throw new zza("AdNetwork timed out", 2);
        }
    }
}
