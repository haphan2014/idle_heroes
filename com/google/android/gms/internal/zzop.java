package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzop extends zzi<zzos> {
    private final long zzaoX = ((long) hashCode());

    private static class zzb extends zzoo {
        private final com.google.android.gms.common.api.zzi<MessageListener> zzaFr;

        zzb(com.google.android.gms.common.api.zzi<MessageListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            this.zzaFr = com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener;
        }

        public void onDisconnected(final String remoteEndpointId) throws RemoteException {
            this.zzaFr.zza(new com.google.android.gms.common.api.zzi.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzaFu;

                public void zza(MessageListener messageListener) {
                    messageListener.onDisconnected(remoteEndpointId);
                }

                public void zzmw() {
                }

                public /* synthetic */ void zzn(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }

        public void onMessageReceived(final String remoteEndpointId, final byte[] payload, final boolean isReliable) throws RemoteException {
            this.zzaFr.zza(new com.google.android.gms.common.api.zzi.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzaFu;

                public void zza(MessageListener messageListener) {
                    messageListener.onMessageReceived(remoteEndpointId, payload, isReliable);
                }

                public void zzmw() {
                }

                public /* synthetic */ void zzn(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }
    }

    private static final class zza extends zzb {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzOs;

        public zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com.google.android.gms.common.api.zzi<MessageListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzu(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzia(int i) throws RemoteException {
            this.zzOs.zzm(new Status(i));
        }
    }

    private static final class zzc extends zzb {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzOs;
        private final com.google.android.gms.common.api.zzi<ConnectionResponseCallback> zzaFv;

        public zzc(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com.google.android.gms.common.api.zzi<ConnectionResponseCallback> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com.google.android.gms.common.api.zzi<MessageListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzu(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzaFv = (com.google.android.gms.common.api.zzi) zzu.zzu(com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback);
        }

        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzaFv.zza(new com.google.android.gms.common.api.zzi.zzb<ConnectionResponseCallback>(this) {
                final /* synthetic */ zzc zzaFw;

                public void zza(ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public void zzmw() {
                }

                public /* synthetic */ void zzn(Object obj) {
                    zza((ConnectionResponseCallback) obj);
                }
            });
        }

        public void zzhZ(int i) throws RemoteException {
            this.zzOs.zzm(new Status(i));
        }
    }

    private static final class zzd extends zzoo {
        private final com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> zzOs;
        private final com.google.android.gms.common.api.zzi<ConnectionRequestListener> zzaFx;

        zzd(com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com.google.android.gms.common.api.zzi<ConnectionRequestListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzu(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult);
            this.zzaFx = (com.google.android.gms.common.api.zzi) zzu.zzu(com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener);
        }

        public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
            final String str = remoteEndpointId;
            final String str2 = remoteDeviceId;
            final String str3 = remoteEndpointName;
            final byte[] bArr = payload;
            this.zzaFx.zza(new com.google.android.gms.common.api.zzi.zzb<ConnectionRequestListener>(this) {
                final /* synthetic */ zzd zzaFA;

                public void zza(ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str, str2, str3, bArr);
                }

                public void zzmw() {
                }

                public /* synthetic */ void zzn(Object obj) {
                    zza((ConnectionRequestListener) obj);
                }
            });
        }

        public void zzj(int i, String str) throws RemoteException {
            this.zzOs.zzm(new zze(new Status(i), str));
        }
    }

    private static final class zze implements StartAdvertisingResult {
        private final Status zzOt;
        private final String zzaFB;

        zze(Status status, String str) {
            this.zzOt = status;
            this.zzaFB = str;
        }

        public String getLocalEndpointName() {
            return this.zzaFB;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class zzf extends zzoo {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzOs;
        private final com.google.android.gms.common.api.zzi<EndpointDiscoveryListener> zzaFx;

        zzf(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com.google.android.gms.common.api.zzi<EndpointDiscoveryListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzu(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzaFx = (com.google.android.gms.common.api.zzi) zzu.zzu(com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener);
        }

        public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
            final String str = endpointId;
            final String str2 = deviceId;
            final String str3 = serviceId;
            final String str4 = name;
            this.zzaFx.zza(new com.google.android.gms.common.api.zzi.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzf zzaFF;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str, str2, str3, str4);
                }

                public void zzmw() {
                }

                public /* synthetic */ void zzn(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }
            });
        }

        public void onEndpointLost(final String endpointId) throws RemoteException {
            this.zzaFx.zza(new com.google.android.gms.common.api.zzi.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzf zzaFF;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(endpointId);
                }

                public void zzmw() {
                }

                public /* synthetic */ void zzn(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }
            });
        }

        public void zzhX(int i) throws RemoteException {
            this.zzOs.zzm(new Status(i));
        }
    }

    public zzop(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzos) zznM()).zzE(this.zzaoX);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzda(iBinder);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str, long j, com.google.android.gms.common.api.zzi<EndpointDiscoveryListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) throws RemoteException {
        ((zzos) zznM()).zza(new zzf(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener), str, j, this.zzaoX);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, String str, AppMetadata appMetadata, long j, com.google.android.gms.common.api.zzi<ConnectionRequestListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) throws RemoteException {
        ((zzos) zznM()).zza(new zzd(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener), str, appMetadata, j, this.zzaoX);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str, String str2, byte[] bArr, com.google.android.gms.common.api.zzi<ConnectionResponseCallback> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com.google.android.gms.common.api.zzi<MessageListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzos) zznM()).zza(new zzc(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener), str, str2, bArr, this.zzaoX);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str, byte[] bArr, com.google.android.gms.common.api.zzi<MessageListener> com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzos) zznM()).zza(new zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zzi_com_google_android_gms_nearby_connection_Connections_MessageListener), str, bArr, this.zzaoX);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzos) zznM()).zza(strArr, bArr, this.zzaoX);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzos) zznM()).zzb(strArr, bArr, this.zzaoX);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    public void zzdQ(String str) {
        try {
            ((zzos) zznM()).zzf(str, this.zzaoX);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzdR(String str) {
        try {
            ((zzos) zznM()).zzg(str, this.zzaoX);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    protected zzos zzda(IBinder iBinder) {
        return com.google.android.gms.internal.zzos.zza.zzdc(iBinder);
    }

    public void zzp(final com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((zzos) zznM()).zza(new zzoo(this) {
            final /* synthetic */ zzop zzaFq;

            public void zzib(int i) throws RemoteException {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzm(new Status(i));
            }
        }, str, this.zzaoX);
    }

    public String zzwR() {
        try {
            return ((zzos) zznM()).zzQ(this.zzaoX);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzwS() {
        try {
            return ((zzos) zznM()).zzwS();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzwT() {
        try {
            ((zzos) zznM()).zzN(this.zzaoX);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzwU() {
        try {
            ((zzos) zznM()).zzP(this.zzaoX);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }
}
