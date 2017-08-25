package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.internal.zzcv.zza;

@zzgd
public class zzda extends zza {
    private final OnContentAdLoadedListener zzvR;

    public zzda(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzvR = onContentAdLoadedListener;
    }

    public void zza(zzcq com_google_android_gms_internal_zzcq) {
        this.zzvR.onContentAdLoaded(zzb(com_google_android_gms_internal_zzcq));
    }

    zzcr zzb(zzcq com_google_android_gms_internal_zzcq) {
        return new zzcr(com_google_android_gms_internal_zzcq);
    }
}
