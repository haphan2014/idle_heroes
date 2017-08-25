package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.wearable.internal.zzav;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.internal.zzbi;
import com.google.android.gms.wearable.internal.zzbk;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzd;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzt;
import com.google.android.gms.wearable.internal.zzu;

public class Wearable {
    public static final Api<WearableOptions> API = new Api("Wearable.API", zzNY, zzNX, new Scope[0]);
    public static final CapabilityApi CapabilityApi = new zzg();
    public static final ChannelApi ChannelApi = new zzi();
    public static final DataApi DataApi = new zzu();
    public static final MessageApi MessageApi = new zzav();
    public static final NodeApi NodeApi = new zzax();
    public static final ClientKey<zzbk> zzNX = new ClientKey();
    private static final zza<zzbk, WearableOptions> zzNY = new C11861();
    public static final zza zzaSZ = new zzd();
    public static final zzd zzaTa = new zzt();
    public static final zzg zzaTb = new zzbi();
    public static final zzi zzaTc = new zzbm();

    static class C11861 implements zza<zzbk, WearableOptions> {
        C11861() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzbk zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder());
            }
            return new zzbk(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
