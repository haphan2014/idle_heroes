package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzt.zza;
import com.google.android.gms.internal.zzgd;

@zzgd
public final class zzi extends zza {
    private final AppEventListener zzsq;

    public zzi(AppEventListener appEventListener) {
        this.zzsq = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.zzsq.onAppEvent(name, info);
    }
}
