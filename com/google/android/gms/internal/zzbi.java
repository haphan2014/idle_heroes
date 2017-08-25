package com.google.android.gms.internal;

import android.support.v4.widget.ExploreByTouchHelper;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgd
public class zzbi {
    private final Object zzqt = new Object();
    private int zzrt;
    private List<zzbh> zzru = new LinkedList();

    public boolean zza(zzbh com_google_android_gms_internal_zzbh) {
        boolean z;
        synchronized (this.zzqt) {
            if (this.zzru.contains(com_google_android_gms_internal_zzbh)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzb(zzbh com_google_android_gms_internal_zzbh) {
        boolean z;
        synchronized (this.zzqt) {
            Iterator it = this.zzru.iterator();
            while (it.hasNext()) {
                zzbh com_google_android_gms_internal_zzbh2 = (zzbh) it.next();
                if (com_google_android_gms_internal_zzbh != com_google_android_gms_internal_zzbh2 && com_google_android_gms_internal_zzbh2.zzci().equals(com_google_android_gms_internal_zzbh.zzci())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public void zzc(zzbh com_google_android_gms_internal_zzbh) {
        synchronized (this.zzqt) {
            if (this.zzru.size() >= 10) {
                zzb.zzay("Queue is full, current size = " + this.zzru.size());
                this.zzru.remove(0);
            }
            int i = this.zzrt;
            this.zzrt = i + 1;
            com_google_android_gms_internal_zzbh.zzg(i);
            this.zzru.add(com_google_android_gms_internal_zzbh);
        }
    }

    public zzbh zzco() {
        zzbh com_google_android_gms_internal_zzbh = null;
        synchronized (this.zzqt) {
            if (this.zzru.size() == 0) {
                zzb.zzay("Queue empty");
                return null;
            } else if (this.zzru.size() >= 2) {
                int i = ExploreByTouchHelper.INVALID_ID;
                for (zzbh com_google_android_gms_internal_zzbh2 : this.zzru) {
                    zzbh com_google_android_gms_internal_zzbh3;
                    int i2;
                    int score = com_google_android_gms_internal_zzbh2.getScore();
                    if (score > i) {
                        int i3 = score;
                        com_google_android_gms_internal_zzbh3 = com_google_android_gms_internal_zzbh2;
                        i2 = i3;
                    } else {
                        i2 = i;
                        com_google_android_gms_internal_zzbh3 = com_google_android_gms_internal_zzbh;
                    }
                    i = i2;
                    com_google_android_gms_internal_zzbh = com_google_android_gms_internal_zzbh3;
                }
                this.zzru.remove(com_google_android_gms_internal_zzbh);
                return com_google_android_gms_internal_zzbh;
            } else {
                com_google_android_gms_internal_zzbh2 = (zzbh) this.zzru.get(0);
                com_google_android_gms_internal_zzbh2.zzcj();
                return com_google_android_gms_internal_zzbh2;
            }
        }
    }
}
