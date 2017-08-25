package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzgd
public class zzcg implements CustomRenderedAd {
    private final zzch zzuV;

    public zzcg(zzch com_google_android_gms_internal_zzch) {
        this.zzuV = com_google_android_gms_internal_zzch;
    }

    public String getBaseUrl() {
        try {
            return this.zzuV.zzdt();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzuV.getContent();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzuV.zza(view != null ? zze.zzw(view) : null);
        } catch (Throwable e) {
            zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzuV.recordClick();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzuV.recordImpression();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
