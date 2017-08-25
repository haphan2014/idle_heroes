package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzck.zza;
import java.util.ArrayList;
import java.util.List;

@zzgd
public class zzcp extends NativeAppInstallAd {
    private final zzco zzvK;
    private final List<Image> zzvL = new ArrayList();
    private final zzcl zzvM;

    public zzcp(zzco com_google_android_gms_internal_zzco) {
        zzcl com_google_android_gms_internal_zzcl;
        this.zzvK = com_google_android_gms_internal_zzco;
        try {
            for (Object zzd : this.zzvK.getImages()) {
                zzck zzd2 = zzd(zzd);
                if (zzd2 != null) {
                    this.zzvL.add(new zzcl(zzd2));
                }
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzck zzdy = this.zzvK.zzdy();
            if (zzdy != null) {
                com_google_android_gms_internal_zzcl = new zzcl(zzdy);
                this.zzvM = com_google_android_gms_internal_zzcl;
            }
        } catch (Throwable e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        com_google_android_gms_internal_zzcl = null;
        this.zzvM = com_google_android_gms_internal_zzcl;
    }

    public CharSequence getBody() {
        try {
            return this.zzvK.getBody();
        } catch (Throwable e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzvK.zzdz();
        } catch (Throwable e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzvK.zzdx();
        } catch (Throwable e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public Image getIcon() {
        return this.zzvM;
    }

    public List<Image> getImages() {
        return this.zzvL;
    }

    public CharSequence getPrice() {
        try {
            return this.zzvK.zzdC();
        } catch (Throwable e) {
            zzb.zzb("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        Double d = null;
        try {
            double zzdA = this.zzvK.zzdA();
            if (zzdA != -1.0d) {
                d = Double.valueOf(zzdA);
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence getStore() {
        try {
            return this.zzvK.zzdB();
        } catch (Throwable e) {
            zzb.zzb("Failed to get store", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzaH() {
        return zzdD();
    }

    zzck zzd(Object obj) {
        return obj instanceof IBinder ? zza.zzt((IBinder) obj) : null;
    }

    protected zzd zzdD() {
        try {
            return this.zzvK.zzdD();
        } catch (Throwable e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
