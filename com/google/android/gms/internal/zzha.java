package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzgd
public class zzha {
    public final int errorCode;
    public final int orientation;
    public final String zzCC;
    public final long zzCJ;
    public final boolean zzCK;
    public final long zzCL;
    public final List<String> zzCM;
    public final String zzCP;
    public final AdRequestParcel zzCm;
    public final String zzCp;
    public final JSONObject zzFl;
    public final zzdy zzFm;
    public final AdSizeParcel zzFn;
    public final long zzFo;
    public final long zzFp;
    public final com.google.android.gms.ads.internal.formats.zzg.zza zzFq;
    public final List<String> zzxF;
    public final List<String> zzxG;
    public final long zzxJ;
    public final zzdx zzxZ;
    public final zzeg zzya;
    public final String zzyb;
    public final zzea zzyc;
    public final zzid zzzE;

    @zzgd
    public static final class zza {
        public final int errorCode;
        public final JSONObject zzFl;
        public final zzdy zzFm;
        public final long zzFo;
        public final long zzFp;
        public final AdRequestInfoParcel zzFr;
        public final AdResponseParcel zzFs;
        public final AdSizeParcel zzpN;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzdy com_google_android_gms_internal_zzdy, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzFr = adRequestInfoParcel;
            this.zzFs = adResponseParcel;
            this.zzFm = com_google_android_gms_internal_zzdy;
            this.zzpN = adSizeParcel;
            this.errorCode = i;
            this.zzFo = j;
            this.zzFp = j2;
            this.zzFl = jSONObject;
        }
    }

    public zzha(AdRequestParcel adRequestParcel, zzid com_google_android_gms_internal_zzid, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzdx com_google_android_gms_internal_zzdx, zzeg com_google_android_gms_internal_zzeg, String str2, zzdy com_google_android_gms_internal_zzdy, zzea com_google_android_gms_internal_zzea, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, com.google.android.gms.ads.internal.formats.zzg.zza com_google_android_gms_ads_internal_formats_zzg_zza, String str4) {
        this.zzCm = adRequestParcel;
        this.zzzE = com_google_android_gms_internal_zzid;
        this.zzxF = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.zzxG = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzCM = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.zzxJ = j;
        this.zzCp = str;
        this.zzCK = z;
        this.zzxZ = com_google_android_gms_internal_zzdx;
        this.zzya = com_google_android_gms_internal_zzeg;
        this.zzyb = str2;
        this.zzFm = com_google_android_gms_internal_zzdy;
        this.zzyc = com_google_android_gms_internal_zzea;
        this.zzCL = j2;
        this.zzFn = adSizeParcel;
        this.zzCJ = j3;
        this.zzFo = j4;
        this.zzFp = j5;
        this.zzCP = str3;
        this.zzFl = jSONObject;
        this.zzFq = com_google_android_gms_ads_internal_formats_zzg_zza;
        this.zzCC = str4;
    }

    public zzha(zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid, zzdx com_google_android_gms_internal_zzdx, zzeg com_google_android_gms_internal_zzeg, String str, zzea com_google_android_gms_internal_zzea, com.google.android.gms.ads.internal.formats.zzg.zza com_google_android_gms_ads_internal_formats_zzg_zza) {
        this(com_google_android_gms_internal_zzha_zza.zzFr.zzCm, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzha_zza.zzFs.zzxF, com_google_android_gms_internal_zzha_zza.errorCode, com_google_android_gms_internal_zzha_zza.zzFs.zzxG, com_google_android_gms_internal_zzha_zza.zzFs.zzCM, com_google_android_gms_internal_zzha_zza.zzFs.orientation, com_google_android_gms_internal_zzha_zza.zzFs.zzxJ, com_google_android_gms_internal_zzha_zza.zzFr.zzCp, com_google_android_gms_internal_zzha_zza.zzFs.zzCK, com_google_android_gms_internal_zzdx, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzha_zza.zzFm, com_google_android_gms_internal_zzea, com_google_android_gms_internal_zzha_zza.zzFs.zzCL, com_google_android_gms_internal_zzha_zza.zzpN, com_google_android_gms_internal_zzha_zza.zzFs.zzCJ, com_google_android_gms_internal_zzha_zza.zzFo, com_google_android_gms_internal_zzha_zza.zzFp, com_google_android_gms_internal_zzha_zza.zzFs.zzCP, com_google_android_gms_internal_zzha_zza.zzFl, com_google_android_gms_ads_internal_formats_zzg_zza, com_google_android_gms_internal_zzha_zza.zzFr.zzCC);
    }

    public boolean zzbU() {
        return (this.zzzE == null || this.zzzE.zzgF() == null) ? false : this.zzzE.zzgF().zzbU();
    }
}
