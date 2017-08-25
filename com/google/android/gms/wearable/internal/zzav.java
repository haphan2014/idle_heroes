package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzav implements MessageApi {

    private static final class zza extends zzf<Status> {
        private MessageListener zzaUF;
        private IntentFilter[] zzaUk;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaUF = messageListener;
            this.zzaUk = intentFilterArr;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaUF, this.zzaUk);
            this.zzaUF = null;
            this.zzaUk = null;
        }

        public Status zzb(Status status) {
            this.zzaUF = null;
            this.zzaUk = null;
            return status;
        }
    }

    public static class zzb implements SendMessageResult {
        private final Status zzOt;
        private final int zzacR;

        public zzb(Status status, int i) {
            this.zzOt = status;
            this.zzacR = i;
        }

        public int getRequestId() {
            return this.zzacR;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return zza(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.zza(new zzf<Status>(this, client) {
            final /* synthetic */ zzav zzaUD;

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

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        final String str = nodeId;
        final String str2 = action;
        final byte[] bArr = data;
        return client.zza(new zzf<SendMessageResult>(this, client) {
            final /* synthetic */ zzav zzaUD;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbh(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, str, str2, bArr);
            }

            protected SendMessageResult zzbh(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
