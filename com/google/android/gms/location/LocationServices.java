package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.internal.zzd;
import com.google.android.gms.location.internal.zze;
import com.google.android.gms.location.internal.zzj;
import com.google.android.gms.location.internal.zzo;

public class LocationServices {
    public static final Api<NoOptions> API = new Api("LocationServices.API", zzNY, zzNX, new Scope[0]);
    public static final FusedLocationProviderApi FusedLocationApi = new zzd();
    public static final GeofencingApi GeofencingApi = new zze();
    public static final SettingsApi SettingsApi = new zzo();
    private static final ClientKey<zzj> zzNX = new ClientKey();
    private static final com.google.android.gms.common.api.Api.zza<zzj, NoOptions> zzNY = new C10751();

    static class C10751 implements com.google.android.gms.common.api.Api.zza<zzj, NoOptions> {
        C10751() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzo(context, looper, com_google_android_gms_common_internal_zze, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzj zzo(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", com_google_android_gms_common_internal_zze);
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzj> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.zzNX, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzj zze(GoogleApiClient googleApiClient) {
        boolean z = true;
        zzu.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzj com_google_android_gms_location_internal_zzj = (zzj) googleApiClient.zza(zzNX);
        if (com_google_android_gms_location_internal_zzj == null) {
            z = false;
        }
        zzu.zza(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return com_google_android_gms_location_internal_zzj;
    }
}
