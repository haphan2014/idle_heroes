package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzy implements DrivePreferencesApi {

    private abstract class zzc extends zzr<FileUploadPreferencesResult> {
        final /* synthetic */ zzy zzafu;

        public zzc(zzy com_google_android_gms_drive_internal_zzy, GoogleApiClient googleApiClient) {
            this.zzafu = com_google_android_gms_drive_internal_zzy;
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzz(x0);
        }

        protected FileUploadPreferencesResult zzz(Status status) {
            return new zzb(status, null);
        }
    }

    private class zza extends zzd {
        private final com.google.android.gms.common.api.zza.zzb<FileUploadPreferencesResult> zzOs;
        final /* synthetic */ zzy zzafu;

        private zza(zzy com_google_android_gms_drive_internal_zzy, com.google.android.gms.common.api.zza.zzb<FileUploadPreferencesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzafu = com_google_android_gms_drive_internal_zzy;
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzOs.zzm(new zzb(Status.zzXP, onDeviceUsagePreferenceResponse.zzpL()));
        }

        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzb(status, null));
        }
    }

    private class zzb implements FileUploadPreferencesResult {
        private final Status zzOt;
        final /* synthetic */ zzy zzafu;
        private final FileUploadPreferences zzafw;

        private zzb(zzy com_google_android_gms_drive_internal_zzy, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzafu = com_google_android_gms_drive_internal_zzy;
            this.zzOt = status;
            this.zzafw = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzafw;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(this, apiClient) {
            final /* synthetic */ zzy zzafu;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                com_google_android_gms_drive_internal_zzs.zzpB().zzd(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return apiClient.zzb(new com.google.android.gms.drive.internal.zzr.zza(this, apiClient) {
                final /* synthetic */ zzy zzafu;

                protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                    com_google_android_gms_drive_internal_zzs.zzpB().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbq(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
