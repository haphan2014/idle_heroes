package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzff.zza;

@zzgd
public final class zzfk extends zza {
    private final InAppPurchaseListener zzsW;

    public zzfk(InAppPurchaseListener inAppPurchaseListener) {
        this.zzsW = inAppPurchaseListener;
    }

    public void zza(zzfe com_google_android_gms_internal_zzfe) {
        this.zzsW.onInAppPurchaseRequested(new zzfn(com_google_android_gms_internal_zzfe));
    }
}
