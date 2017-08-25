package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzfj.zza;

@zzgd
public final class zzfo extends zza {
    private final PlayStorePurchaseListener zzsX;

    public zzfo(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzsX = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String productId) {
        return this.zzsX.isValidPurchase(productId);
    }

    public void zza(zzfi com_google_android_gms_internal_zzfi) {
        this.zzsX.onInAppPurchaseFinished(new zzfm(com_google_android_gms_internal_zzfi));
    }
}
