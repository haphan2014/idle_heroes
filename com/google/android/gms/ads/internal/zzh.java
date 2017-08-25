package com.google.android.gms.ads.internal;

import android.content.Context;
import com.facebook.AppEventsConstants;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo.zza;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzkw;
import java.util.ArrayList;
import java.util.List;

@zzgd
public class zzh extends zza {
    private final Context mContext;
    private final zzn zzoE;
    private final zzcu zzoF;
    private final zzcv zzoG;
    private final zzkw<String, zzcx> zzoH;
    private final zzkw<String, zzcw> zzoI;
    private final NativeAdOptionsParcel zzoJ;
    private final List<String> zzoK = zzbg();
    private final String zzoL;
    private final VersionInfoParcel zzoM;
    private final zzef zzoq;

    zzh(Context context, String str, zzef com_google_android_gms_internal_zzef, VersionInfoParcel versionInfoParcel, zzn com_google_android_gms_ads_internal_client_zzn, zzcu com_google_android_gms_internal_zzcu, zzcv com_google_android_gms_internal_zzcv, zzkw<String, zzcx> com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcx, zzkw<String, zzcw> com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcw, NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.mContext = context;
        this.zzoL = str;
        this.zzoq = com_google_android_gms_internal_zzef;
        this.zzoM = versionInfoParcel;
        this.zzoE = com_google_android_gms_ads_internal_client_zzn;
        this.zzoG = com_google_android_gms_internal_zzcv;
        this.zzoF = com_google_android_gms_internal_zzcu;
        this.zzoH = com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcx;
        this.zzoI = com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcw;
        this.zzoJ = nativeAdOptionsParcel;
    }

    private List<String> zzbg() {
        List<String> arrayList = new ArrayList();
        if (this.zzoG != null) {
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.zzoF != null) {
            arrayList.add("2");
        }
        if (this.zzoH.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    protected void runOnUiThread(Runnable runnable) {
        zzhl.zzGk.post(runnable);
    }

    protected zzm zzbh() {
        return new zzm(this.mContext, AdSizeParcel.zzs(this.mContext), this.zzoL, this.zzoq, this.zzoM);
    }

    public void zze(final AdRequestParcel adRequestParcel) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzh zzoO;

            public void run() {
                zzm zzbh = this.zzoO.zzbh();
                zzbh.zzb(this.zzoO.zzoF);
                zzbh.zzb(this.zzoO.zzoG);
                zzbh.zza(this.zzoO.zzoH);
                zzbh.zza(this.zzoO.zzoE);
                zzbh.zzb(this.zzoO.zzoI);
                zzbh.zza(this.zzoO.zzbg());
                zzbh.zzb(this.zzoO.zzoJ);
                zzbh.zza(adRequestParcel);
            }
        });
    }
}
