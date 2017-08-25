package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzgd
public class zzfm implements InAppPurchaseResult {
    private final zzfi zzBc;

    public zzfm(zzfi com_google_android_gms_internal_zzfi) {
        this.zzBc = com_google_android_gms_internal_zzfi;
    }

    public void finishPurchase() {
        try {
            this.zzBc.finishPurchase();
        } catch (Throwable e) {
            zzb.zzd("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.zzBc.getProductId();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.zzBc.getPurchaseData();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.zzBc.getResultCode();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.zzBc.isVerified();
        } catch (Throwable e) {
            zzb.zzd("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
