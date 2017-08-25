package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.common.api.zzi.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class zzu extends zzz implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zzi<DownloadProgressListener> zzafi;

        public zza(zzi<DownloadProgressListener> com_google_android_gms_common_api_zzi_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzafi = com_google_android_gms_common_api_zzi_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.zzafi.zza(new zzb<DownloadProgressListener>(this) {
                final /* synthetic */ zza zzafl;

                public void zza(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                public void zzmw() {
                }

                public /* synthetic */ void zzn(Object obj) {
                    zza((DownloadProgressListener) obj);
                }
            });
        }
    }

    public zzu(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzo(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener zza = zza(apiClient, listener);
            return apiClient.zza(new zzb(this, apiClient) {
                final /* synthetic */ zzu zzafh;

                protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                    setCancelToken(com_google_android_gms_drive_internal_zzs.zzpB().zza(new OpenContentsRequest(this.zzafh.getDriveId(), mode, 0), new zzbi(this, zza)).zzpF());
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
