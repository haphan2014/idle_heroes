package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzn.zza;
import com.google.android.gms.internal.zzgd;

@zzgd
public final class zzc extends zza {
    private final AdListener zzrV;

    public zzc(AdListener adListener) {
        this.zzrV = adListener;
    }

    public void onAdClosed() {
        this.zzrV.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.zzrV.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.zzrV.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.zzrV.onAdLoaded();
    }

    public void onAdOpened() {
        this.zzrV.onAdOpened();
    }
}
