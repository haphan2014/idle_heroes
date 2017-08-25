package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class zzw extends zzz implements DriveFolder {

    static abstract class zzd extends zzr<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzx(x0);
        }

        public DriveFileResult zzx(Status status) {
            return new zzc(status, null);
        }
    }

    static abstract class zzf extends zzr<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzy(x0);
        }

        public DriveFolderResult zzy(Status status) {
            return new zze(status, null);
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.zza.zzb<DriveFileResult> zzOs;

        public zza(com.google.android.gms.common.api.zza.zzb<DriveFileResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzOs.zzm(new zzc(Status.zzXP, new zzu(onDriveIdResponse.getDriveId())));
        }

        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzc(status, null));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.zza.zzb<DriveFolderResult> zzOs;

        public zzb(com.google.android.gms.common.api.zza.zzb<DriveFolderResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzOs.zzm(new zze(Status.zzXP, new zzw(onDriveIdResponse.getDriveId())));
        }

        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zze(status, null));
        }
    }

    private static class zzc implements DriveFileResult {
        private final Status zzOt;
        private final DriveFile zzafr;

        public zzc(Status status, DriveFile driveFile) {
            this.zzOt = status;
            this.zzafr = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzafr;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static class zze implements DriveFolderResult {
        private final Status zzOt;
        private final DriveFolder zzafs;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzOt = status;
            this.zzafs = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzafs;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.zza(googleApiClient, executionOptions);
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final int i4 = i2;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.zzb(new zzd(this, googleApiClient) {
            final /* synthetic */ zzw zzafq;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                metadataChangeSet2.zzpm().setContext(com_google_android_gms_drive_internal_zzs.getContext());
                com_google_android_gms_drive_internal_zzs.zzpB().zza(new CreateFileRequest(this.zzafq.getDriveId(), metadataChangeSet2.zzpm(), i3, i4, executionOptions2), new zza(this));
            }
        });
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof zzt)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzpg()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.zzpe().getRequestId();
            driveContents.zzpf();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return zza(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.zzpk() == 0) {
            return zza(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.zzb(new zzf(this, apiClient) {
                final /* synthetic */ zzw zzafq;

                protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                    changeSet.zzpm().setContext(com_google_android_gms_drive_internal_zzs.getContext());
                    com_google_android_gms_drive_internal_zzs.zzpB().zza(new CreateFolderRequest(this.zzafq.getDriveId(), changeSet.zzpm()), new zzb(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        return new zzq().query(apiClient, zza(query));
    }
}
