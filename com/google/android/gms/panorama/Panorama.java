package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzow;

public final class Panorama {
    public static final Api<NoOptions> API = new Api("Panorama.API", zzNY, zzNX, new Scope[0]);
    public static final PanoramaApi PanoramaApi = new zzov();
    public static final ClientKey<zzow> zzNX = new ClientKey();
    static final zza<zzow, NoOptions> zzNY = new C11301();

    static class C11301 implements zza<zzow, NoOptions> {
        C11301() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzs(context, looper, com_google_android_gms_common_internal_zze, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzow zzs(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzow(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private Panorama() {
    }
}
