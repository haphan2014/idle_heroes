package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzck.zza;
import java.util.ArrayList;
import java.util.List;

@zzgd
public class zzcr extends NativeContentAd {
    private final List<Image> zzvL = new ArrayList();
    private final zzcq zzvN;
    private final zzcl zzvO;

    public zzcr(zzcq com_google_android_gms_internal_zzcq) {
        zzcl com_google_android_gms_internal_zzcl;
        this.zzvN = com_google_android_gms_internal_zzcq;
        try {
            for (Object zzd : this.zzvN.getImages()) {
                zzck zzd2 = zzd(zzd);
                if (zzd2 != null) {
                    this.zzvL.add(new zzcl(zzd2));
                }
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzck zzdG = this.zzvN.zzdG();
            if (zzdG != null) {
                com_google_android_gms_internal_zzcl = new zzcl(zzdG);
                this.zzvO = com_google_android_gms_internal_zzcl;
            }
        } catch (Throwable e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        com_google_android_gms_internal_zzcl = null;
        this.zzvO = com_google_android_gms_internal_zzcl;
    }

    public CharSequence getAdvertiser() {
        try {
            return this.zzvN.zzdH();
        } catch (Throwable e) {
            zzb.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzvN.getBody();
        } catch (Throwable e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzvN.zzdz();
        } catch (Throwable e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzvN.zzdx();
        } catch (Throwable e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public List<Image> getImages() {
        return this.zzvL;
    }

    public Image getLogo() {
        return this.zzvO;
    }

    protected /* synthetic */ Object zzaH() {
        return zzdD();
    }

    zzck zzd(Object obj) {
        return obj instanceof IBinder ? zza.zzt((IBinder) obj) : null;
    }

    protected zzd zzdD() {
        try {
            return this.zzvN.zzdD();
        } catch (Throwable e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
