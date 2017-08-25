package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhk;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzgd
class zzg implements zzaj, Runnable {
    private final List<Object[]> zzoB = new Vector();
    private final AtomicReference<zzaj> zzoC = new AtomicReference();
    CountDownLatch zzoD = new CountDownLatch(1);
    private zzp zzon;

    public zzg(zzp com_google_android_gms_ads_internal_zzp) {
        this.zzon = com_google_android_gms_ads_internal_zzp;
        if (zzk.zzcA().zzgw()) {
            zzhk.zza((Runnable) this);
        } else {
            run();
        }
    }

    private void zzbf() {
        if (!this.zzoB.isEmpty()) {
            for (Object[] objArr : this.zzoB) {
                if (objArr.length == 1) {
                    ((zzaj) this.zzoC.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzaj) this.zzoC.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzoB.clear();
        }
    }

    private Context zzp(Context context) {
        if (!((Boolean) zzbz.zztM.get()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public void run() {
        try {
            boolean z = !((Boolean) zzbz.zztU.get()).booleanValue() || this.zzon.zzpJ.zzGJ;
            zza(zzb(this.zzon.zzpJ.zzGG, zzp(this.zzon.zzpH), z));
        } finally {
            this.zzoD.countDown();
            this.zzon = null;
        }
    }

    public String zza(Context context, String str) {
        if (zzbe()) {
            zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzoC.get();
            if (com_google_android_gms_internal_zzaj != null) {
                zzbf();
                return com_google_android_gms_internal_zzaj.zza(zzp(context), str);
            }
        }
        return "";
    }

    public void zza(int i, int i2, int i3) {
        zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzoC.get();
        if (com_google_android_gms_internal_zzaj != null) {
            zzbf();
            com_google_android_gms_internal_zzaj.zza(i, i2, i3);
            return;
        }
        this.zzoB.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void zza(MotionEvent motionEvent) {
        zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzoC.get();
        if (com_google_android_gms_internal_zzaj != null) {
            zzbf();
            com_google_android_gms_internal_zzaj.zza(motionEvent);
            return;
        }
        this.zzoB.add(new Object[]{motionEvent});
    }

    protected void zza(zzaj com_google_android_gms_internal_zzaj) {
        this.zzoC.set(com_google_android_gms_internal_zzaj);
    }

    protected zzaj zzb(String str, Context context, boolean z) {
        return zzam.zza(str, context, z);
    }

    public String zzb(Context context) {
        if (zzbe()) {
            zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzoC.get();
            if (com_google_android_gms_internal_zzaj != null) {
                zzbf();
                return com_google_android_gms_internal_zzaj.zzb(zzp(context));
            }
        }
        return "";
    }

    protected boolean zzbe() {
        try {
            this.zzoD.await();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
