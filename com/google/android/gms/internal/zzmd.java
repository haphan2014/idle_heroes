package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.Fitness;

public class zzmd extends zzlw<zzmo> {

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzmd> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzajC, googleApiClient);
        }
    }

    public static class zzb implements com.google.android.gms.common.api.Api.zza<zzmd, NoOptions> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzn(context, looper, com_google_android_gms_common_internal_zze, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzmd zzn(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmd(context, looper, com_google_android_gms_common_internal_zze, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected Status zzb(Status status) {
            zzu.zzV(!status.isSuccess());
            return status;
        }
    }

    public zzmd(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 58, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.fitness.SessionsApi";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzbo(iBinder);
    }

    protected zzmo zzbo(IBinder iBinder) {
        return com.google.android.gms.internal.zzmo.zza.zzbz(iBinder);
    }
}
