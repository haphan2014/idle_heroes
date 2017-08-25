package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzu implements DataApi {

    private static final class zza extends zzf<Status> {
        private DataListener zzaUj;
        private IntentFilter[] zzaUk;

        private zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaUj = dataListener;
            this.zzaUk = intentFilterArr;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaUj, this.zzaUk);
            this.zzaUj = null;
            this.zzaUk = null;
        }

        public Status zzb(Status status) {
            this.zzaUj = null;
            this.zzaUk = null;
            return status;
        }
    }

    public static class zzb implements DataItemResult {
        private final Status zzOt;
        private final DataItem zzaUl;

        public zzb(Status status, DataItem dataItem) {
            this.zzOt = status;
            this.zzaUl = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzaUl;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzc implements DeleteDataItemsResult {
        private final Status zzOt;
        private final int zzaUm;

        public zzc(Status status, int i) {
            this.zzOt = status;
            this.zzaUm = i;
        }

        public int getNumDeleted() {
            return this.zzaUm;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzd implements GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzOt;
        private volatile InputStream zzaTV;
        private volatile ParcelFileDescriptor zzaUn;

        public zzd(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzOt = status;
            this.zzaUn = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzaUn;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzaUn == null) {
                return null;
            } else {
                if (this.zzaTV == null) {
                    this.zzaTV = new AutoCloseInputStream(this.zzaUn);
                }
                return this.zzaTV;
            }
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public void release() {
            if (this.zzaUn != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzaTV != null) {
                        this.zzaTV.close();
                    } else {
                        this.zzaUn.close();
                    }
                    this.mClosed = true;
                    this.zzaUn = null;
                    this.zzaTV = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, dataListener, intentFilterArr));
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return zza(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        return client.zza(new zzf<DeleteDataItemsResult>(this, client) {
            final /* synthetic */ zzu zzaUe;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbf(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzb((com.google.android.gms.common.api.zza.zzb) this, uri, filterType);
            }

            protected DeleteDataItemsResult zzbf(Status status) {
                return new zzc(status, 0);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzf<DataItemResult>(this, client) {
            final /* synthetic */ zzu zzaUe;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbd(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, uri);
            }

            protected DataItemResult zzbd(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new zzf<DataItemBuffer>(this, client) {
            final /* synthetic */ zzu zzaUe;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbe(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzl(this);
            }

            protected DataItemBuffer zzbe(Status status) {
                return new DataItemBuffer(DataHolder.zzbi(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        return client.zza(new zzf<DataItemBuffer>(this, client) {
            final /* synthetic */ zzu zzaUe;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbe(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, uri, filterType);
            }

            protected DataItemBuffer zzbe(Status status) {
                return new DataItemBuffer(DataHolder.zzbi(status.getStatusCode()));
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        zza(asset);
        return client.zza(new zzf<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzu zzaUe;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbg(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, asset);
            }

            protected GetFdForAssetResult zzbg(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.zza(new zzf<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzu zzaUe;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbg(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, asset);
            }

            protected GetFdForAssetResult zzbg(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.zza(new zzf<DataItemResult>(this, client) {
            final /* synthetic */ zzu zzaUe;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzbd(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, request);
            }

            public DataItemResult zzbd(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.zza(new zzf<Status>(this, client) {
            final /* synthetic */ zzu zzaUe;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
