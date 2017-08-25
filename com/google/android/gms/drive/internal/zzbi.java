package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

class zzbi extends zzd {
    private final zzb<DriveContentsResult> zzOs;
    private final DownloadProgressListener zzags;

    zzbi(zzb<DriveContentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult, DownloadProgressListener downloadProgressListener) {
        this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        this.zzags = downloadProgressListener;
    }

    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzOs.zzm(new zza(onContentsResponse.zzpK() ? new Status(-1) : Status.zzXP, new zzt(onContentsResponse.zzpJ())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.zzags != null) {
            this.zzags.onProgress(onDownloadProgressResponse.zzpM(), onDownloadProgressResponse.zzpN());
        }
    }

    public void zzt(Status status) throws RemoteException {
        this.zzOs.zzm(new zza(status, null));
    }
}
