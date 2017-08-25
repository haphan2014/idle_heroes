package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.internal.zzcx.zza;

@zzgd
public class zzdc extends zza {
    private final OnCustomTemplateAdLoadedListener zzvT;

    public zzdc(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzvT = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzcs com_google_android_gms_internal_zzcs) {
        this.zzvT.onCustomTemplateAdLoaded(new zzct(com_google_android_gms_internal_zzcs));
    }
}
