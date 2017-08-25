package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzi implements ChannelApi {

    static final class zza extends zzf<Status> {
        private final String zzaTK;
        private ChannelListener zzaTL;

        zza(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaTL = (ChannelListener) zzu.zzu(channelListener);
            this.zzaTK = str;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaTL, this.zzaTK);
            this.zzaTL = null;
        }

        public Status zzb(Status status) {
            this.zzaTL = null;
            return status;
        }
    }

    static final class zzb implements OpenChannelResult {
        private final Status zzOt;
        private final Channel zzaTM;

        zzb(Status status, Channel channel) {
            this.zzOt = (Status) zzu.zzu(status);
            this.zzaTM = channel;
        }

        public Channel getChannel() {
            return this.zzaTM;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    static final class zzc extends zzf<Status> {
        private final String zzaTK;
        private ChannelListener zzaTL;

        zzc(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaTL = (ChannelListener) zzu.zzu(channelListener);
            this.zzaTK = str;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbk.zzb((com.google.android.gms.common.api.zza.zzb) this, this.zzaTL, this.zzaTK);
            this.zzaTL = null;
        }

        public Status zzb(Status status) {
            this.zzaTL = null;
            return status;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzu.zzb((Object) client, (Object) "client is null");
        zzu.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zza(client, listener, null));
    }

    public PendingResult<OpenChannelResult> openChannel(GoogleApiClient client, final String nodeId, final String path) {
        zzu.zzb((Object) client, (Object) "client is null");
        zzu.zzb((Object) nodeId, (Object) "nodeId is null");
        zzu.zzb((Object) path, (Object) "path is null");
        return client.zzb(new zzf<OpenChannelResult>(this, client) {
            final /* synthetic */ zzi zzaTJ;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzba(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zze(this, nodeId, path);
            }

            public OpenChannelResult zzba(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzu.zzb((Object) client, (Object) "client is null");
        zzu.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzc(client, listener, null));
    }
}
