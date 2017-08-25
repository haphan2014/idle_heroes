package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new zzl();
    final int zzCY;
    private final String zzaST;
    private final String zzaTK;
    private final String zzaTQ;

    static final class zza implements GetInputStreamResult {
        private final Status zzOt;
        private final InputStream zzaTV;

        zza(Status status, InputStream inputStream) {
            this.zzOt = (Status) zzu.zzu(status);
            this.zzaTV = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzaTV;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public void release() {
            if (this.zzaTV != null) {
                try {
                    this.zzaTV.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements GetOutputStreamResult {
        private final Status zzOt;
        private final OutputStream zzaTW;

        zzb(Status status, OutputStream outputStream) {
            this.zzOt = (Status) zzu.zzu(status);
            this.zzaTW = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzaTW;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public void release() {
            if (this.zzaTW != null) {
                try {
                    this.zzaTW.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.zzCY = versionCode;
        this.zzaTK = (String) zzu.zzu(token);
        this.zzaST = (String) zzu.zzu(nodeId);
        this.zzaTQ = (String) zzu.zzu(path);
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzu.zzb((Object) client, (Object) "client is null");
        zzu.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zza(client, listener, this.zzaTK));
    }

    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zzb(new zzf<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzaTR;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzt(this, this.zzaTR.zzaTK);
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> close(GoogleApiClient client, final int errorCode) {
        return client.zzb(new zzf<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzaTR;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzh(this, this.zzaTR.zzaTK, errorCode);
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzaTK.equals(channelImpl.zzaTK) && zzt.equal(channelImpl.zzaST, this.zzaST) && zzt.equal(channelImpl.zzaTQ, this.zzaTQ) && channelImpl.zzCY == this.zzCY;
    }

    public PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zzb(new zzf<GetInputStreamResult>(this, client) {
            final /* synthetic */ ChannelImpl zzaTR;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzbb(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzu(this, this.zzaTR.zzaTK);
            }

            public GetInputStreamResult zzbb(Status status) {
                return new zza(status, null);
            }
        });
    }

    public String getNodeId() {
        return this.zzaST;
    }

    public PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zzb(new zzf<GetOutputStreamResult>(this, client) {
            final /* synthetic */ ChannelImpl zzaTR;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzbc(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzv(this, this.zzaTR.zzaTK);
            }

            public GetOutputStreamResult zzbc(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public String getPath() {
        return this.zzaTQ;
    }

    public String getToken() {
        return this.zzaTK;
    }

    public int hashCode() {
        return this.zzaTK.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient client, final Uri uri, final boolean append) {
        zzu.zzb((Object) client, (Object) "client is null");
        zzu.zzb((Object) uri, (Object) "uri is null");
        return client.zzb(new zzf<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzaTR;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaTR.zzaTK, uri, append);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzu.zzb((Object) client, (Object) "client is null");
        zzu.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzc(client, listener, this.zzaTK));
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri, long startOffset, long length) {
        zzu.zzb((Object) client, (Object) "client is null");
        zzu.zzb(this.zzaTK, (Object) "token is null");
        zzu.zzb((Object) uri, (Object) "uri is null");
        zzu.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        boolean z = length >= 0 || length == -1;
        zzu.zzb(z, "invalid length: %s", Long.valueOf(length));
        final Uri uri2 = uri;
        final long j = startOffset;
        final long j2 = length;
        return client.zzb(new zzf<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzaTR;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza(this, this.zzaTR.zzaTK, uri2, j, j2);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.zzCY + ", token='" + this.zzaTK + '\'' + ", nodeId='" + this.zzaST + '\'' + ", path='" + this.zzaTQ + '\'' + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
