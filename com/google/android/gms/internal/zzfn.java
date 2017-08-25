package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzgd
public class zzfn implements InAppPurchase {
    private final zzfe zzAN;

    public zzfn(zzfe com_google_android_gms_internal_zzfe) {
        this.zzAN = com_google_android_gms_internal_zzfe;
    }

    public String getProductId() {
        try {
            return this.zzAN.getProductId();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.zzAN.recordPlayBillingResolution(billingResponseCode);
        } catch (Throwable e) {
            zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int resolution) {
        try {
            this.zzAN.recordResolution(resolution);
        } catch (Throwable e) {
            zzb.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
