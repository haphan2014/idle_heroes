package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzln;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api("Plus.API", zzNY, zzNX, new Scope[0]);
    public static final Account AccountApi = new zzpa();
    public static final Moments MomentsApi = new zzpd();
    public static final People PeopleApi = new zzpe();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final ClientKey<zze> zzNX = new ClientKey();
    static final com.google.android.gms.common.api.Api.zza<zze, PlusOptions> zzNY = new C11321();
    public static final zzb zzaGZ = new zzpc();
    public static final zza zzaHa = new zzpb();

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzNX, googleApiClient);
        }
    }

    static class C11321 implements com.google.android.gms.common.api.Api.zza<zze, PlusOptions> {
        C11321() {
        }

        public int getPriority() {
            return 2;
        }

        public zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new zze(context, looper, com_google_android_gms_common_internal_zze, new PlusSession(com_google_android_gms_common_internal_zze.zzns(), zzln.zzc(com_google_android_gms_common_internal_zze.zznw()), (String[]) plusOptions.zzaHc.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class PlusOptions implements Optional {
        final String zzaHb;
        final Set<String> zzaHc;

        public static final class Builder {
            String zzaHb;
            final Set<String> zzaHc = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                zzu.zzb((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.zzaHc.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.zzaHb = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.zzaHb = null;
            this.zzaHc = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzaHb = builder.zzaHb;
            this.zzaHc = builder.zzaHc;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzu.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzu.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzu.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zze) googleApiClient.zza(zzNX) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
