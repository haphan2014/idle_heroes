package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzz implements DriveResource {
    protected final DriveId zzacT;

    private abstract class zzd extends zzr<MetadataResult> {
        final /* synthetic */ zzz zzafy;

        private zzd(zzz com_google_android_gms_drive_internal_zzz, GoogleApiClient googleApiClient) {
            this.zzafy = com_google_android_gms_drive_internal_zzz;
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzA(x0);
        }

        public MetadataResult zzA(Status status) {
            return new zzc(status, null);
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> zzOs;

        public zza(com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzOs.zzm(new zzf(Status.zzXP, new MetadataBuffer(onListParentsResponse.zzpR()), false));
        }

        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzf(status, null, false));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.zza.zzb<MetadataResult> zzOs;

        public zzb(com.google.android.gms.common.api.zza.zzb<MetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzOs.zzm(new zzc(Status.zzXP, new zzn(onMetadataResponse.zzpS())));
        }

        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzc(status, null));
        }
    }

    private static class zzc implements MetadataResult {
        private final Status zzOt;
        private final Metadata zzafA;

        public zzc(Status status, Metadata metadata) {
            this.zzOt = status;
            this.zzafA = metadata;
        }

        public Metadata getMetadata() {
            return this.zzafA;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    protected zzz(DriveId driveId) {
        this.zzacT = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(this, googleApiClient) {
            final /* synthetic */ zzz zzafy;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                com_google_android_gms_drive_internal_zzs.zzpB().zza(new GetMetadataRequest(this.zzafy.zzacT, z), new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zza(apiClient, this.zzacT, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zza(apiClient, this.zzacT);
    }

    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzr.zza(this, apiClient) {
            final /* synthetic */ zzz zzafy;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                com_google_android_gms_drive_internal_zzs.zzpB().zza(new DeleteResourceRequest(this.zzafy.zzacT), new zzbq(this));
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzacT;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new zzg(this, apiClient) {
            final /* synthetic */ zzz zzafy;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                com_google_android_gms_drive_internal_zzs.zzpB().zza(new ListParentsRequest(this.zzafy.zzacT), new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zzb(apiClient, this.zzacT, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zzb(apiClient, this.zzacT);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (parentIds.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            final List arrayList = new ArrayList(parentIds);
            return apiClient.zzb(new com.google.android.gms.drive.internal.zzr.zza(this, apiClient) {
                final /* synthetic */ zzz zzafy;

                protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                    com_google_android_gms_drive_internal_zzs.zzpB().zza(new SetResourceParentsRequest(this.zzafy.zzacT, arrayList), new zzbq(this));
                }
            });
        }
    }

    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzr.zza(this, apiClient) {
            final /* synthetic */ zzz zzafy;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                com_google_android_gms_drive_internal_zzs.zzpB().zza(new TrashResourceRequest(this.zzafy.zzacT), new zzbq(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzr.zza(this, apiClient) {
            final /* synthetic */ zzz zzafy;

            protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                com_google_android_gms_drive_internal_zzs.zzpB().zza(new UntrashResourceRequest(this.zzafy.zzacT), new zzbq(this));
            }
        });
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new zzd(this, apiClient) {
                final /* synthetic */ zzz zzafy;

                protected void zza(zzs com_google_android_gms_drive_internal_zzs) throws RemoteException {
                    changeSet.zzpm().setContext(com_google_android_gms_drive_internal_zzs.getContext());
                    com_google_android_gms_drive_internal_zzs.zzpB().zza(new UpdateMetadataRequest(this.zzafy.zzacT, changeSet.zzpm()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
