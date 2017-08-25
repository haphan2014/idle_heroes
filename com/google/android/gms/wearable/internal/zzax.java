package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzax implements NodeApi {

    private static final class zza extends zzf<Status> {
        private NodeListener zzaUI;

        private zza(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.zzaUI = nodeListener;
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbk.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaUI);
            this.zzaUI = null;
        }

        public Status zzb(Status status) {
            this.zzaUI = null;
            return status;
        }
    }

    public static class zzb implements GetConnectedNodesResult {
        private final Status zzOt;
        private final List<Node> zzaUJ;

        public zzb(Status status, List<Node> list) {
            this.zzOt = status;
            this.zzaUJ = list;
        }

        public List<Node> getNodes() {
            return this.zzaUJ;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzc implements GetLocalNodeResult {
        private final Status zzOt;
        private final Node zzaUK;

        public zzc(Status status, Node node) {
            this.zzOt = status;
            this.zzaUK = node;
        }

        public Node getNode() {
            return this.zzaUK;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return client.zza(new zza(client, listener));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new zzf<GetConnectedNodesResult>(this, client) {
            final /* synthetic */ zzax zzaUG;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbj(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzn(this);
            }

            protected GetConnectedNodesResult zzbj(Status status) {
                return new zzb(status, new ArrayList());
            }
        });
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new zzf<GetLocalNodeResult>(this, client) {
            final /* synthetic */ zzax zzaUG;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzbi(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzm(this);
            }

            protected GetLocalNodeResult zzbi(Status status) {
                return new zzc(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeListener listener) {
        return client.zza(new zzf<Status>(this, client) {
            final /* synthetic */ zzax zzaUG;

            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzbk com_google_android_gms_wearable_internal_zzbk) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbk.zzb(this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
