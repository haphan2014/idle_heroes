package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;

public class zzma extends zzlw<zzml> {

    public static class zza implements com.google.android.gms.common.api.Api.zza<zzma, NoOptions> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzk(context, looper, com_google_android_gms_common_internal_zze, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzma zzk(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzma(context, looper, com_google_android_gms_common_internal_zze, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zzma(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 61, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzbl(iBinder);
    }

    protected zzml zzbl(IBinder iBinder) {
        return com.google.android.gms.internal.zzml.zza.zzbw(iBinder);
    }
}
