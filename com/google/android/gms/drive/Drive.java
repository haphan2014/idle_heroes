package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzq;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzv;
import com.google.android.gms.drive.internal.zzy;

public final class Drive {
    public static final Api<NoOptions> API = new Api("Drive.API", new C06321(), zzNX, new Scope[0]);
    public static final DriveApi DriveApi = new zzq();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzy();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final ClientKey<zzs> zzNX = new ClientKey();
    public static final Scope zzacY = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzacZ = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzada = new Api("Drive.INTERNAL_API", new C06332(), zzNX, new Scope[0]);
    public static final zzc zzadb = new zzv();
    public static final zzf zzadc = new zzaa();

    public static abstract class zza<O extends ApiOptions> implements com.google.android.gms.common.api.Api.zza<zzs, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        protected abstract Bundle zza(O o);

        public zzs zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzs(context, looper, com_google_android_gms_common_internal_zze, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    static class C06321 extends zza<NoOptions> {
        C06321() {
        }

        protected Bundle zza(NoOptions noOptions) {
            return new Bundle();
        }
    }

    static class C06332 extends zza<zzb> {
        C06332() {
        }

        protected Bundle zza(zzb com_google_android_gms_drive_Drive_zzb) {
            return com_google_android_gms_drive_Drive_zzb == null ? new Bundle() : com_google_android_gms_drive_Drive_zzb.zzpd();
        }
    }

    public static class zzb implements Optional {
        private final Bundle zzNW;

        private zzb() {
            this(new Bundle());
        }

        private zzb(Bundle bundle) {
            this.zzNW = bundle;
        }

        public Bundle zzpd() {
            return this.zzNW;
        }
    }

    private Drive() {
    }
}
