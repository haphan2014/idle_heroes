package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.internal.zzir.zza;

public abstract class zzis<T> extends zza {
    protected zzb<T> zzNO;

    public zzis(zzb<T> com_google_android_gms_common_api_zza_zzb_T) {
        this.zzNO = com_google_android_gms_common_api_zza_zzb_T;
    }

    public void zza(Response response) {
    }

    public void zza(Status status) {
    }

    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    public void zza(Status status, boolean z) {
    }
}
