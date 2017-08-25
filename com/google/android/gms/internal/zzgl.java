package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzo;
import java.util.WeakHashMap;

@zzgd
public final class zzgl {
    private WeakHashMap<Context, zza> zzEH = new WeakHashMap();

    private class zza {
        public final long zzEI = zzo.zzbz().currentTimeMillis();
        public final zzgk zzEJ;
        final /* synthetic */ zzgl zzEK;

        public zza(zzgl com_google_android_gms_internal_zzgl, zzgk com_google_android_gms_internal_zzgk) {
            this.zzEK = com_google_android_gms_internal_zzgl;
            this.zzEJ = com_google_android_gms_internal_zzgk;
        }

        public boolean hasExpired() {
            return ((Long) zzbz.zzuw.get()).longValue() + this.zzEI < zzo.zzbz().currentTimeMillis();
        }
    }

    public zzgk zzC(Context context) {
        zza com_google_android_gms_internal_zzgl_zza = (zza) this.zzEH.get(context);
        zzgk zzfJ = (com_google_android_gms_internal_zzgl_zza == null || com_google_android_gms_internal_zzgl_zza.hasExpired() || !((Boolean) zzbz.zzuv.get()).booleanValue()) ? new com.google.android.gms.internal.zzgk.zza(context).zzfJ() : new com.google.android.gms.internal.zzgk.zza(context, com_google_android_gms_internal_zzgl_zza.zzEJ).zzfJ();
        this.zzEH.put(context, new zza(this, zzfJ));
        return zzfJ;
    }
}
