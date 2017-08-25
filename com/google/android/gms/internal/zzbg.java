package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public class zzbg implements zzbf {
    private final zzbe zzrh;
    private final HashSet<SimpleEntry<String, zzdg>> zzri = new HashSet();

    public zzbg(zzbe com_google_android_gms_internal_zzbe) {
        this.zzrh = com_google_android_gms_internal_zzbe;
    }

    public void zza(String str, zzdg com_google_android_gms_internal_zzdg) {
        this.zzrh.zza(str, com_google_android_gms_internal_zzdg);
        this.zzri.add(new SimpleEntry(str, com_google_android_gms_internal_zzdg));
    }

    public void zza(String str, String str2) {
        this.zzrh.zza(str, str2);
    }

    public void zza(String str, JSONObject jSONObject) {
        this.zzrh.zza(str, jSONObject);
    }

    public void zzb(String str, zzdg com_google_android_gms_internal_zzdg) {
        this.zzrh.zzb(str, com_google_android_gms_internal_zzdg);
        this.zzri.remove(new SimpleEntry(str, com_google_android_gms_internal_zzdg));
    }

    public void zzcg() {
        Iterator it = this.zzri.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            zzb.zzaB("Unregistering eventhandler: " + ((zzdg) simpleEntry.getValue()).toString());
            this.zzrh.zzb((String) simpleEntry.getKey(), (zzdg) simpleEntry.getValue());
        }
        this.zzri.clear();
    }
}
