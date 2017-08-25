package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zziv;

public final class zza {
    public static final ClientKey<zzit> zzMO = new ClientKey();
    private static final com.google.android.gms.common.api.Api.zza<zzit, NoOptions> zzMP = new C04051();
    public static final Api<NoOptions> zzMQ = new Api("AppDataSearch.LIGHTWEIGHT_API", zzMP, zzMO, new Scope[0]);
    public static final zzk zzMR = new zziv();

    static class C04051 implements com.google.android.gms.common.api.Api.zza<zzit, NoOptions> {
        C04051() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzit zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzit(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }
}
