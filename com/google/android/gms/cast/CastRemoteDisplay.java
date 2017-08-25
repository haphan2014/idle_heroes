package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;

public final class CastRemoteDisplay {
    public static final Api<CastRemoteDisplayOptions> API = new Api("CastRemoteDisplay.API", zzNY, zzNX, new Scope[0]);
    public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzka(zzNX);
    private static final ClientKey<zzkb> zzNX = new ClientKey();
    private static final zza<zzkb, CastRemoteDisplayOptions> zzNY = new C04401();

    static class C04401 implements zza<zzkb, CastRemoteDisplayOptions> {
        C04401() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzkb zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, CastRemoteDisplayOptions castRemoteDisplayOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkb(context, looper, castRemoteDisplayOptions.zzQE, castRemoteDisplayOptions.zzQU, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class CastRemoteDisplayOptions implements HasOptions {
        final CastDevice zzQE;
        final CastRemoteDisplaySessionCallbacks zzQU;

        public static final class Builder {
            CastDevice zzQH;
            CastRemoteDisplaySessionCallbacks zzQV;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks callbacks) {
                zzu.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                this.zzQH = castDevice;
                this.zzQV = callbacks;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions();
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzQE = builder.zzQH;
            this.zzQU = builder.zzQV;
        }
    }

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    private CastRemoteDisplay() {
    }
}
