package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzhj.zzb;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;

@zzgd
public class zzhc implements zzb {
    private Context mContext;
    private boolean zzEd = true;
    private boolean zzEe = true;
    private final String zzFE;
    private final zzhd zzFF;
    private BigInteger zzFG = BigInteger.ONE;
    private final HashSet<zzhb> zzFH = new HashSet();
    private final HashMap<String, zzhf> zzFI = new HashMap();
    private boolean zzFJ = false;
    private int zzFK = 0;
    private zzcb zzFL = null;
    private zzbk zzFM = null;
    private final LinkedList<Thread> zzFN = new LinkedList();
    private Boolean zzFO = null;
    private String zzFP;
    private VersionInfoParcel zzoM;
    private zzay zzop;
    private boolean zzpb = false;
    private final Object zzqt = new Object();
    private zzbj zzrw = null;
    private zzbi zzrx = null;
    private final zzgc zzry = null;

    public zzhc(zzhl com_google_android_gms_internal_zzhl) {
        this.zzFE = com_google_android_gms_internal_zzhl.zzgn();
        this.zzFF = new zzhd(this.zzFE);
    }

    public String getSessionId() {
        return this.zzFE;
    }

    public void zzA(boolean z) {
        synchronized (this.zzqt) {
            this.zzEe = z;
        }
    }

    public zzbk zzD(Context context) {
        if (!((Boolean) zzbz.zzuc.get()).booleanValue() || !zzlk.zzoU() || zzfV()) {
            return null;
        }
        synchronized (this.zzqt) {
            if (this.zzrw == null) {
                if (context instanceof Activity) {
                    this.zzrw = new zzbj((Application) context.getApplicationContext(), (Activity) context);
                } else {
                    return null;
                }
            }
            if (this.zzrx == null) {
                this.zzrx = new zzbi();
            }
            if (this.zzFM == null) {
                this.zzFM = new zzbk(this.zzrw, this.zzrx, new zzgc(this.mContext, this.zzoM, null, null));
            }
            this.zzFM.zzcp();
            zzbk com_google_android_gms_internal_zzbk = this.zzFM;
            return com_google_android_gms_internal_zzbk;
        }
    }

    public Bundle zza(Context context, zzhe com_google_android_gms_internal_zzhe, String str) {
        Bundle bundle;
        synchronized (this.zzqt) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzFF.zzd(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzFI.keySet()) {
                bundle2.putBundle(str2, ((zzhf) this.zzFI.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzFH.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzhb) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            com_google_android_gms_internal_zzhe.zza(this.zzFH);
            this.zzFH.clear();
        }
        return bundle;
    }

    public Future zza(Context context, boolean z) {
        Future zza;
        synchronized (this.zzqt) {
            if (z != this.zzEd) {
                this.zzEd = z;
                zza = zzhj.zza(context, z);
            } else {
                zza = null;
            }
        }
        return zza;
    }

    public void zza(zzhb com_google_android_gms_internal_zzhb) {
        synchronized (this.zzqt) {
            this.zzFH.add(com_google_android_gms_internal_zzhb);
        }
    }

    public void zza(String str, zzhf com_google_android_gms_internal_zzhf) {
        synchronized (this.zzqt) {
            this.zzFI.put(str, com_google_android_gms_internal_zzhf);
        }
    }

    public void zza(Thread thread) {
        zzgc.zza(this.mContext, thread, this.zzoM);
    }

    public void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.zzqt) {
            if (!this.zzpb) {
                this.mContext = context.getApplicationContext();
                this.zzoM = versionInfoParcel;
                zzhj.zza(context, (zzb) this);
                zzhj.zzb(context, this);
                zza(Thread.currentThread());
                this.zzFP = zzo.zzbv().zzf(context, versionInfoParcel.zzGG);
                this.zzop = new zzay(context.getApplicationContext(), this.zzoM, new zzdt(context.getApplicationContext(), this.zzoM, (String) zzbz.zztD.get()));
                zzgf();
                this.zzpb = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.zzqt) {
            this.zzFO = bool;
        }
    }

    public void zzb(HashSet<zzhb> hashSet) {
        synchronized (this.zzqt) {
            this.zzFH.addAll(hashSet);
        }
    }

    public String zzc(int i, String str) {
        Resources resources = this.zzoM.zzGJ ? this.mContext.getResources() : GooglePlayServicesUtil.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    public void zzc(Bundle bundle) {
        synchronized (this.zzqt) {
            this.zzEd = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.zzEd;
            this.zzFK = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.zzFK;
        }
    }

    public void zzc(Throwable th, boolean z) {
        new zzgc(this.mContext, this.zzoM, null, null).zza(th, z);
    }

    public boolean zzfV() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzEe;
        }
        return z;
    }

    public String zzfW() {
        String bigInteger;
        synchronized (this.zzqt) {
            bigInteger = this.zzFG.toString();
            this.zzFG = this.zzFG.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public zzhd zzfX() {
        zzhd com_google_android_gms_internal_zzhd;
        synchronized (this.zzqt) {
            com_google_android_gms_internal_zzhd = this.zzFF;
        }
        return com_google_android_gms_internal_zzhd;
    }

    public zzcb zzfY() {
        zzcb com_google_android_gms_internal_zzcb;
        synchronized (this.zzqt) {
            com_google_android_gms_internal_zzcb = this.zzFL;
        }
        return com_google_android_gms_internal_zzcb;
    }

    public boolean zzfZ() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzFJ;
            this.zzFJ = true;
        }
        return z;
    }

    public boolean zzga() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzEd;
        }
        return z;
    }

    public String zzgb() {
        String str;
        synchronized (this.zzqt) {
            str = this.zzFP;
        }
        return str;
    }

    public Boolean zzgc() {
        Boolean bool;
        synchronized (this.zzqt) {
            bool = this.zzFO;
        }
        return bool;
    }

    public zzay zzgd() {
        return this.zzop;
    }

    public boolean zzge() {
        boolean z;
        synchronized (this.zzqt) {
            if (this.zzFK < ((Integer) zzbz.zzup.get()).intValue()) {
                this.zzFK = ((Integer) zzbz.zzup.get()).intValue();
                zzhj.zza(this.mContext, this.zzFK);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    void zzgf() {
        zzca com_google_android_gms_internal_zzca = new zzca();
        com_google_android_gms_internal_zzca.zzb(this.mContext, this.zzoM.zzGG);
        try {
            this.zzFL = zzo.zzbA().zza(com_google_android_gms_internal_zzca);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot initialize CSI reporter.", e);
        }
    }
}
