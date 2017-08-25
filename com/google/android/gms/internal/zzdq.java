package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgd
public class zzdq implements Iterable<zzdp> {
    private final List<zzdp> zzwE = new LinkedList();

    private zzdp zzc(zzid com_google_android_gms_internal_zzid) {
        Iterator it = zzo.zzbH().iterator();
        while (it.hasNext()) {
            zzdp com_google_android_gms_internal_zzdp = (zzdp) it.next();
            if (com_google_android_gms_internal_zzdp.zzoA == com_google_android_gms_internal_zzid) {
                return com_google_android_gms_internal_zzdp;
            }
        }
        return null;
    }

    public Iterator<zzdp> iterator() {
        return this.zzwE.iterator();
    }

    public void zza(zzdp com_google_android_gms_internal_zzdp) {
        this.zzwE.add(com_google_android_gms_internal_zzdp);
    }

    public boolean zza(zzid com_google_android_gms_internal_zzid) {
        zzdp zzc = zzc(com_google_android_gms_internal_zzid);
        if (zzc == null) {
            return false;
        }
        zzc.zzwB.abort();
        return true;
    }

    public void zzb(zzdp com_google_android_gms_internal_zzdp) {
        this.zzwE.remove(com_google_android_gms_internal_zzdp);
    }

    public boolean zzb(zzid com_google_android_gms_internal_zzid) {
        return zzc(com_google_android_gms_internal_zzid) != null;
    }
}
