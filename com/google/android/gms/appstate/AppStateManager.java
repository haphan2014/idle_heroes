package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzjb;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API = new Api("AppStateManager.API", zzNY, zzNX, SCOPE_APP_STATE);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    static final ClientKey<zzjb> zzNX = new ClientKey();
    private static final com.google.android.gms.common.api.Api.zza<zzjb, NoOptions> zzNY = new C04081();

    static class C04081 implements com.google.android.gms.common.api.Api.zza<zzjb, NoOptions> {
        C04081() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzc(context, looper, com_google_android_gms_common_internal_zze, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzjb zzc(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjb(context, looper, com_google_android_gms_common_internal_zze, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzjb> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppStateManager.zzNX, googleApiClient);
        }
    }

    private static abstract class zze extends zza<StateResult> {
        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzh(x0);
        }

        public StateResult zzh(Status status) {
            return AppStateManager.zzd(status);
        }
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    private static abstract class zzb extends zza<StateDeletedResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    private static abstract class zzc extends zza<StateListResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzg(x0);
        }

        public StateListResult zzg(final Status status) {
            return new StateListResult(this) {
                final /* synthetic */ zzc zzOr;

                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzd extends zza<Status> {
        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    private AppStateManager() {
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            public /* synthetic */ Result createFailedResult(Status x0) {
                return zzf(x0);
            }

            protected void zza(zzjb com_google_android_gms_internal_zzjb) throws RemoteException {
                com_google_android_gms_internal_zzjb.zza(this, stateKey);
            }

            public StateDeletedResult zzf(final Status status) {
                return new StateDeletedResult(this) {
                    final /* synthetic */ C04135 zzOo;

                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzkW();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzkV();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzc(googleApiClient) {
            protected void zza(zzjb com_google_android_gms_internal_zzjb) throws RemoteException {
                com_google_android_gms_internal_zzjb.zza((com.google.android.gms.common.api.zza.zzb) this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.zza(new zze(googleApiClient) {
            protected void zza(zzjb com_google_android_gms_internal_zzjb) throws RemoteException {
                com_google_android_gms_internal_zzjb.zzb(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.zzb(new zze(googleApiClient) {
            protected void zza(zzjb com_google_android_gms_internal_zzjb) throws RemoteException {
                com_google_android_gms_internal_zzjb.zza(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzd(googleApiClient) {
            protected void zza(zzjb com_google_android_gms_internal_zzjb) throws RemoteException {
                com_google_android_gms_internal_zzjb.zzb(this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.zzb(new zze(googleApiClient) {
            protected void zza(zzjb com_google_android_gms_internal_zzjb) throws RemoteException {
                com_google_android_gms_internal_zzjb.zza(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.zzb(new zze(googleApiClient) {
            protected void zza(zzjb com_google_android_gms_internal_zzjb) throws RemoteException {
                com_google_android_gms_internal_zzjb.zza(this, stateKey, data);
            }
        });
    }

    public static zzjb zza(GoogleApiClient googleApiClient) {
        zzu.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzu.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzu.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjb) googleApiClient.zza(zzNX);
    }

    private static StateResult zzd(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
