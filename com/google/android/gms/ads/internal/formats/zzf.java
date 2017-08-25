package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcs.zza;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzkw;
import java.util.Arrays;
import java.util.List;

@zzgd
public class zzf extends zza implements zzg.zza {
    private final Object zzqt = new Object();
    private final zza zzvp;
    private zzg zzvq;
    private final String zzvt;
    private final zzkw<String, zzc> zzvu;
    private final zzkw<String, String> zzvv;

    public zzf(String str, zzkw<String, zzc> com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_ads_internal_formats_zzc, zzkw<String, String> com_google_android_gms_internal_zzkw_java_lang_String__java_lang_String, zza com_google_android_gms_ads_internal_formats_zza) {
        this.zzvt = str;
        this.zzvu = com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_ads_internal_formats_zzc;
        this.zzvv = com_google_android_gms_internal_zzkw_java_lang_String__java_lang_String;
        this.zzvp = com_google_android_gms_ads_internal_formats_zza;
    }

    public List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[(this.zzvu.size() + this.zzvv.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzvu.size(); i3++) {
            strArr[i2] = (String) this.zzvu.keyAt(i3);
            i2++;
        }
        while (i < this.zzvv.size()) {
            strArr[i2] = (String) this.zzvv.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public String getCustomTemplateId() {
        return this.zzvt;
    }

    public void performClick(String assetName) {
        synchronized (this.zzqt) {
            if (this.zzvq == null) {
                zzb.zzaz("Attempt to call performClick before ad initialized.");
                return;
            }
            this.zzvq.performClick(assetName);
        }
    }

    public void recordImpression() {
        synchronized (this.zzqt) {
            if (this.zzvq == null) {
                zzb.zzaz("Attempt to perform recordImpression before ad initialized.");
                return;
            }
            this.zzvq.recordImpression();
        }
    }

    public String zzQ(String str) {
        return (String) this.zzvv.get(str);
    }

    public zzck zzR(String str) {
        return (zzck) this.zzvu.get(str);
    }

    public void zza(zzg com_google_android_gms_ads_internal_formats_zzg) {
        synchronized (this.zzqt) {
            this.zzvq = com_google_android_gms_ads_internal_formats_zzg;
        }
    }

    public String zzdE() {
        return "3";
    }

    public zza zzdF() {
        return this.zzvp;
    }
}
