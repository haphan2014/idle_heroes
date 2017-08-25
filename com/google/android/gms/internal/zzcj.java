package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzci.zza;

@zzgd
public final class zzcj extends zza {
    private final OnCustomRenderedAdLoadedListener zzsY;

    public zzcj(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzsY = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzch com_google_android_gms_internal_zzch) {
        this.zzsY.onCustomRenderedAdLoaded(new zzcg(com_google_android_gms_internal_zzch));
    }
}
