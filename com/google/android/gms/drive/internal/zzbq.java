package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

public class zzbq extends zzd {
    private final zzb<Status> zzOs;

    public zzbq(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
    }

    public void onSuccess() throws RemoteException {
        this.zzOs.zzm(Status.zzXP);
    }

    public void zzt(Status status) throws RemoteException {
        this.zzOs.zzm(status);
    }
}
