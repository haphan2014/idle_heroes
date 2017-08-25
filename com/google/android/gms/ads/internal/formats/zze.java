package com.google.android.gms.ads.internal.formats;

import com.facebook.AppEventsConstants;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcq.zza;
import com.google.android.gms.internal.zzgd;
import java.util.List;

@zzgd
public class zze extends zza implements zzg.zza {
    private final Object zzqt = new Object();
    private final String zzvh;
    private final List<zzc> zzvi;
    private final String zzvj;
    private final String zzvl;
    private final zza zzvp;
    private zzg zzvq;
    private final zzc zzvr;
    private final String zzvs;

    public zze(String str, List list, String str2, zzc com_google_android_gms_ads_internal_formats_zzc, String str3, String str4, zza com_google_android_gms_ads_internal_formats_zza) {
        this.zzvh = str;
        this.zzvi = list;
        this.zzvj = str2;
        this.zzvr = com_google_android_gms_ads_internal_formats_zzc;
        this.zzvl = str3;
        this.zzvs = str4;
        this.zzvp = com_google_android_gms_ads_internal_formats_zza;
    }

    public String getBody() {
        return this.zzvj;
    }

    public String getCustomTemplateId() {
        return "";
    }

    public List getImages() {
        return this.zzvi;
    }

    public void zza(zzg com_google_android_gms_ads_internal_formats_zzg) {
        synchronized (this.zzqt) {
            this.zzvq = com_google_android_gms_ads_internal_formats_zzg;
        }
    }

    public zzd zzdD() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzvq);
    }

    public String zzdE() {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    public zza zzdF() {
        return this.zzvp;
    }

    public zzck zzdG() {
        return this.zzvr;
    }

    public String zzdH() {
        return this.zzvs;
    }

    public String zzdx() {
        return this.zzvh;
    }

    public String zzdz() {
        return this.zzvl;
    }
}
