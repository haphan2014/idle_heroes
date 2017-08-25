package com.google.android.gms.appinvite;

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
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzix;

public final class AppInvite {
    public static final Api<NoOptions> API = new Api("AppInvite.API", zzNY, zzNX, new Scope[0]);
    public static final AppInviteApi AppInviteApi = new zziw();
    public static final ClientKey<zzix> zzNX = new ClientKey();
    private static final zza<zzix, NoOptions> zzNY = new C04071();

    static class C04071 implements zza<zzix, NoOptions> {
        C04071() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zze, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzix zzb(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzix(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        }
    }

    private AppInvite() {
    }
}
