package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.internal.zzcu.zza;

@zzgd
public class zzcz extends zza {
    private final OnAppInstallAdLoadedListener zzvQ;

    public zzcz(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzvQ = onAppInstallAdLoadedListener;
    }

    public void zza(zzco com_google_android_gms_internal_zzco) {
        this.zzvQ.onAppInstallAdLoaded(zzb(com_google_android_gms_internal_zzco));
    }

    zzcp zzb(zzco com_google_android_gms_internal_zzco) {
        return new zzcp(com_google_android_gms_internal_zzco);
    }
}
