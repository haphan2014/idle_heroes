package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzr.zza;
import com.google.android.gms.internal.zzlg;
import java.io.InputStream;
import java.io.OutputStream;

public class zzt implements DriveContents {
    private boolean mClosed = false;
    private final Contents zzafa;
    private boolean zzafb = false;
    private boolean zzafc = false;

    class C06483 implements ResultCallback<Status> {
        final /* synthetic */ zzt zzafd;

        C06483(zzt com_google_android_gms_drive_internal_zzt) {
            this.zzafd = com_google_android_gms_drive_internal_zzt;
        }

        public /* synthetic */ void onResult(Result x0) {
            zzm((Status) x0);
        }

        public void zzm(Status status) {
            if (status.isSuccess()) {
                zzx.zzt("DriveContentsImpl", "Contents discarded");
            } else {
                zzx.zzv("DriveContentsImpl", "Error discarding contents");
            }
        }
    }

    public zzt(Contents contents) {
        this.zzafa = (Contents) zzu.zzu(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return commit(apiClient, changeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.zzafa.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzbX(executionOptions.zzpk()) || this.zzafa.zzpc()) {
            ExecutionOptions.zza(apiClient, executionOptions);
            if (zzpg()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (changeSet == null) {
                    changeSet = MetadataChangeSet.zzads;
                }
                zzpf();
                return apiClient.zzb(new zza(this, apiClient) {
                    final /* synthetic */ zzt zzafd;

                    protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                        changeSet.zzpm().setContext(com_google_android_gms_drive_internal_zzs.getContext());
                        com_google_android_gms_drive_internal_zzs.zzpB().zza(new CloseContentsAndUpdateMetadataRequest(this.zzafd.zzafa.getDriveId(), changeSet.zzpm(), this.zzafd.zzafa.getRequestId(), this.zzafd.zzafa.zzpc(), executionOptions), new zzbq(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient apiClient) {
        if (zzpg()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzpf();
        ((C06494) apiClient.zzb(new zza(this, apiClient) {
            final /* synthetic */ zzt zzafd;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                com_google_android_gms_drive_internal_zzs.zzpB().zza(new CloseContentsRequest(this.zzafd.zzafa.getRequestId(), false), new zzbq(this));
            }
        })).setResultCallback(new C06483(this));
    }

    public DriveId getDriveId() {
        return this.zzafa.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzpg()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzafa.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzafb) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzafb = true;
            return this.zzafa.getInputStream();
        }
    }

    public int getMode() {
        return this.zzafa.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzpg()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzafa.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzafc) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzafc = true;
            return this.zzafa.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzpg()) {
            return this.zzafa.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (zzpg()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzafa.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzpf();
            return apiClient.zza(new zzb(this, apiClient) {
                final /* synthetic */ zzt zzafd;

                protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                    com_google_android_gms_drive_internal_zzs.zzpB().zza(new OpenContentsRequest(this.zzafd.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzafd.zzafa.getRequestId()), new zzbi(this, null));
                }
            });
        }
    }

    public Contents zzpe() {
        return this.zzafa;
    }

    public void zzpf() {
        zzlg.zza(this.zzafa.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzpg() {
        return this.mClosed;
    }
}
