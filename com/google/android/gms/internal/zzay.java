package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@zzgd
public class zzay implements zzba {
    private final VersionInfoParcel zzoM;
    private final Object zzqt = new Object();
    private final WeakHashMap<zzha, zzaz> zzqu = new WeakHashMap();
    private final ArrayList<zzaz> zzqv = new ArrayList();
    private final Context zzqw;
    private final zzdt zzqx;

    public zzay(Context context, VersionInfoParcel versionInfoParcel, zzdt com_google_android_gms_internal_zzdt) {
        this.zzqw = context.getApplicationContext();
        this.zzoM = versionInfoParcel;
        this.zzqx = com_google_android_gms_internal_zzdt;
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzha com_google_android_gms_internal_zzha) {
        return zza(adSizeParcel, com_google_android_gms_internal_zzha, com_google_android_gms_internal_zzha.zzzE.getWebView());
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzha com_google_android_gms_internal_zzha, View view) {
        zzaz com_google_android_gms_internal_zzaz;
        synchronized (this.zzqt) {
            if (zzf(com_google_android_gms_internal_zzha)) {
                com_google_android_gms_internal_zzaz = (zzaz) this.zzqu.get(com_google_android_gms_internal_zzha);
            } else {
                com_google_android_gms_internal_zzaz = new zzaz(adSizeParcel, com_google_android_gms_internal_zzha, this.zzoM, view, this.zzqx);
                com_google_android_gms_internal_zzaz.zza((zzba) this);
                this.zzqu.put(com_google_android_gms_internal_zzha, com_google_android_gms_internal_zzaz);
                this.zzqv.add(com_google_android_gms_internal_zzaz);
            }
        }
        return com_google_android_gms_internal_zzaz;
    }

    public void zza(zzaz com_google_android_gms_internal_zzaz) {
        synchronized (this.zzqt) {
            if (!com_google_android_gms_internal_zzaz.zzbZ()) {
                this.zzqv.remove(com_google_android_gms_internal_zzaz);
                Iterator it = this.zzqu.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == com_google_android_gms_internal_zzaz) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzf(zzha com_google_android_gms_internal_zzha) {
        boolean z;
        synchronized (this.zzqt) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzqu.get(com_google_android_gms_internal_zzha);
            z = com_google_android_gms_internal_zzaz != null && com_google_android_gms_internal_zzaz.zzbZ();
        }
        return z;
    }

    public void zzg(zzha com_google_android_gms_internal_zzha) {
        synchronized (this.zzqt) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzqu.get(com_google_android_gms_internal_zzha);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.zzbX();
            }
        }
    }

    public void zzh(zzha com_google_android_gms_internal_zzha) {
        synchronized (this.zzqt) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzqu.get(com_google_android_gms_internal_zzha);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.stop();
            }
        }
    }

    public void zzi(zzha com_google_android_gms_internal_zzha) {
        synchronized (this.zzqt) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzqu.get(com_google_android_gms_internal_zzha);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.pause();
            }
        }
    }

    public void zzj(zzha com_google_android_gms_internal_zzha) {
        synchronized (this.zzqt) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzqu.get(com_google_android_gms_internal_zzha);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.resume();
            }
        }
    }
}
