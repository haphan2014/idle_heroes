package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.wearable.Wearable;

abstract class zzf<R extends Result> extends zza<R, zzbk> {
    public zzf(GoogleApiClient googleApiClient) {
        super(Wearable.zzNX, googleApiClient);
    }
}
