package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp.zza;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzkw;

@zzgd
public class zzi extends zza {
    private final Context mContext;
    private zzn zzoE;
    private NativeAdOptionsParcel zzoJ;
    private final String zzoL;
    private final VersionInfoParcel zzoM;
    private zzcu zzoP;
    private zzcv zzoQ;
    private zzkw<String, zzcw> zzoR = new zzkw();
    private zzkw<String, zzcx> zzoS = new zzkw();
    private final zzef zzoq;

    public zzi(Context context, String str, zzef com_google_android_gms_internal_zzef, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzoL = str;
        this.zzoq = com_google_android_gms_internal_zzef;
        this.zzoM = versionInfoParcel;
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.zzoJ = nativeAdOptionsParcel;
    }

    public void zza(zzcu com_google_android_gms_internal_zzcu) {
        this.zzoP = com_google_android_gms_internal_zzcu;
    }

    public void zza(zzcv com_google_android_gms_internal_zzcv) {
        this.zzoQ = com_google_android_gms_internal_zzcv;
    }

    public void zza(String str, zzcx com_google_android_gms_internal_zzcx, zzcw com_google_android_gms_internal_zzcw) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzoS.put(str, com_google_android_gms_internal_zzcx);
        this.zzoR.put(str, com_google_android_gms_internal_zzcw);
    }

    public void zzb(zzn com_google_android_gms_ads_internal_client_zzn) {
        this.zzoE = com_google_android_gms_ads_internal_client_zzn;
    }

    public zzo zzbi() {
        return new zzh(this.mContext, this.zzoL, this.zzoq, this.zzoM, this.zzoE, this.zzoP, this.zzoQ, this.zzoS, this.zzoR, this.zzoJ);
    }
}
