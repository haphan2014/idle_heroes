package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.internal.zzcw.zza;

@zzgd
public class zzdb extends zza {
    private final OnCustomClickListener zzvS;

    public zzdb(OnCustomClickListener onCustomClickListener) {
        this.zzvS = onCustomClickListener;
    }

    public void zza(zzcs com_google_android_gms_internal_zzcs, String str) {
        this.zzvS.onCustomClick(new zzct(com_google_android_gms_internal_zzcs), str);
    }
}
