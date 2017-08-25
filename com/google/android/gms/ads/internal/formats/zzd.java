package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzco.zza;
import com.google.android.gms.internal.zzgd;
import java.util.List;

@zzgd
public class zzd extends zza implements zzg.zza {
    private final Object zzqt = new Object();
    private final String zzvh;
    private final List<zzc> zzvi;
    private final String zzvj;
    private final zzc zzvk;
    private final String zzvl;
    private final double zzvm;
    private final String zzvn;
    private final String zzvo;
    private final zza zzvp;
    private zzg zzvq;

    public zzd(String str, List list, String str2, zzc com_google_android_gms_ads_internal_formats_zzc, String str3, double d, String str4, String str5, zza com_google_android_gms_ads_internal_formats_zza) {
        this.zzvh = str;
        this.zzvi = list;
        this.zzvj = str2;
        this.zzvk = com_google_android_gms_ads_internal_formats_zzc;
        this.zzvl = str3;
        this.zzvm = d;
        this.zzvn = str4;
        this.zzvo = str5;
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

    public double zzdA() {
        return this.zzvm;
    }

    public String zzdB() {
        return this.zzvn;
    }

    public String zzdC() {
        return this.zzvo;
    }

    public com.google.android.gms.dynamic.zzd zzdD() {
        return zze.zzw(this.zzvq);
    }

    public String zzdE() {
        return "2";
    }

    public zza zzdF() {
        return this.zzvp;
    }

    public String zzdx() {
        return this.zzvh;
    }

    public zzck zzdy() {
        return this.zzvk;
    }

    public String zzdz() {
        return this.zzvl;
    }
}
