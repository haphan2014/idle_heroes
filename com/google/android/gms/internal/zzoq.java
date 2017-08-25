package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzoq implements Connections {
    public static final ClientKey<zzop> zzNX = new ClientKey();
    public static final com.google.android.gms.common.api.Api.zza<zzop, NoOptions> zzNY = new C10281();

    static class C10281 implements com.google.android.gms.common.api.Api.zza<zzop, NoOptions> {
        C10281() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzq(context, looper, com_google_android_gms_common_internal_zze, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzop zzq(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzop(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzop> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzoq.zzNX, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzaM(x0);
        }

        public StartAdvertisingResult zzaM(final Status status) {
            return new StartAdvertisingResult(this) {
                final /* synthetic */ zzb zzaFN;

                public String getLocalEndpointName() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public static zzop zzd(GoogleApiClient googleApiClient, boolean z) {
        zzu.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzu.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzop zze(GoogleApiClient googleApiClient, boolean z) {
        zzu.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zzop) googleApiClient.zza(zzNX) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload, MessageListener messageListener) {
        final zzi zzo = apiClient.zzo(messageListener);
        final String str = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzoq zzaFJ;

            protected void zza(zzop com_google_android_gms_internal_zzop) throws RemoteException {
                com_google_android_gms_internal_zzop.zza((com.google.android.gms.common.api.zza.zzb) this, str, bArr, zzo);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient apiClient, String remoteEndpointId) {
        zzd(apiClient, false).zzdR(remoteEndpointId);
    }

    public String getLocalDeviceId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzwS();
    }

    public String getLocalEndpointId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzwR();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient apiClient, final String remoteEndpointId) {
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzoq zzaFJ;

            protected void zza(zzop com_google_android_gms_internal_zzop) throws RemoteException {
                com_google_android_gms_internal_zzop.zzp(this, remoteEndpointId);
            }
        });
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient apiClient, String name, String remoteEndpointId, byte[] payload, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        final zzi zzo = apiClient.zzo(connectionResponseCallback);
        final zzi zzo2 = apiClient.zzo(messageListener);
        final String str = name;
        final String str2 = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzoq zzaFJ;

            protected void zza(zzop com_google_android_gms_internal_zzop) throws RemoteException {
                com_google_android_gms_internal_zzop.zza(this, str, str2, bArr, zzo, zzo2);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zza(new String[]{remoteEndpointId}, payload);
    }

    public void sendReliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zza((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zzb(new String[]{remoteEndpointId}, payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zzb((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient apiClient, String name, AppMetadata appMetadata, long durationMillis, ConnectionRequestListener connectionRequestListener) {
        final zzi zzo = apiClient.zzo(connectionRequestListener);
        final String str = name;
        final AppMetadata appMetadata2 = appMetadata;
        final long j = durationMillis;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzoq zzaFJ;

            protected void zza(zzop com_google_android_gms_internal_zzop) throws RemoteException {
                com_google_android_gms_internal_zzop.zza(this, str, appMetadata2, j, zzo);
            }
        });
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient apiClient, String serviceId, long durationMillis, EndpointDiscoveryListener listener) {
        final zzi zzo = apiClient.zzo(listener);
        final String str = serviceId;
        final long j = durationMillis;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzoq zzaFJ;

            protected void zza(zzop com_google_android_gms_internal_zzop) throws RemoteException {
                com_google_android_gms_internal_zzop.zza((com.google.android.gms.common.api.zza.zzb) this, str, j, zzo);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzwT();
    }

    public void stopAllEndpoints(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzwU();
    }

    public void stopDiscovery(GoogleApiClient apiClient, String serviceId) {
        zzd(apiClient, false).zzdQ(serviceId);
    }
}
