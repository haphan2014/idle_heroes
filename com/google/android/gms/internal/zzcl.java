package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgd
public class zzcl implements Image {
    private final Uri mUri;
    private final zzck zzvI;
    private final Drawable zzvJ;

    public zzcl(zzck com_google_android_gms_internal_zzck) {
        Drawable drawable;
        Uri uri = null;
        this.zzvI = com_google_android_gms_internal_zzck;
        try {
            zzd zzdw = this.zzvI.zzdw();
            if (zzdw != null) {
                drawable = (Drawable) zze.zzn(zzdw);
                this.zzvJ = drawable;
                uri = this.zzvI.getUri();
                this.mUri = uri;
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.zzvJ = drawable;
        try {
            uri = this.zzvI.getUri();
        } catch (Throwable e2) {
            zzb.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
    }

    public Drawable getDrawable() {
        return this.zzvJ;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
