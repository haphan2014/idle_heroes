package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzha.zza;

@zzgd
public class zzfw extends zzfs {
    private zzdw zzBA;
    protected zzec zzBB;
    private zzef zzoq;
    private zzdy zzxn;

    zzfw(Context context, zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid, zzef com_google_android_gms_internal_zzef, zzft.zza com_google_android_gms_internal_zzft_zza) {
        super(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza);
        this.zzoq = com_google_android_gms_internal_zzef;
        this.zzxn = com_google_android_gms_internal_zzha_zza.zzFm;
    }

    public void onStop() {
        synchronized (this.zzBr) {
            super.onStop();
            if (this.zzBA != null) {
                this.zzBA.cancel();
            }
        }
    }

    protected void zzh(long j) throws zza {
        synchronized (this.zzBr) {
            this.zzBA = new zzdw(this.mContext, this.zzBs.zzFr, this.zzoq, this.zzxn);
        }
        this.zzBB = this.zzBA.zza(j, 60000);
        switch (this.zzBB.zzxY) {
            case 0:
                return;
            case 1:
                throw new zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zza("Unexpected mediation result: " + this.zzBB.zzxY, 0);
        }
    }

    protected zzha zzz(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzBs.zzFr;
        return new zzha(adRequestInfoParcel.zzCm, this.zzoA, this.zzBt.zzxF, i, this.zzBt.zzxG, this.zzBt.zzCM, this.zzBt.orientation, this.zzBt.zzxJ, adRequestInfoParcel.zzCp, this.zzBt.zzCK, this.zzBB != null ? this.zzBB.zzxZ : null, this.zzBB != null ? this.zzBB.zzya : null, this.zzBB != null ? this.zzBB.zzyb : AdMobAdapter.class.getName(), this.zzxn, this.zzBB != null ? this.zzBB.zzyc : null, this.zzBt.zzCL, this.zzBs.zzpN, this.zzBt.zzCJ, this.zzBs.zzFo, this.zzBt.zzCO, this.zzBt.zzCP, this.zzBs.zzFl, null, adRequestInfoParcel.zzCC);
    }
}
