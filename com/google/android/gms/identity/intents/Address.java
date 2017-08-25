package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznk;

public final class Address {
    public static final Api<AddressOptions> API = new Api("Address.API", zzNY, zzNX, new Scope[0]);
    static final ClientKey<zznk> zzNX = new ClientKey();
    private static final com.google.android.gms.common.api.Api.zza<zznk, AddressOptions> zzNY = new C08231();

    static class C08231 implements com.google.android.gms.common.api.Api.zza<zznk, AddressOptions> {
        C08231() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zznk zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzu.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zznk((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze.getAccountName(), addressOptions.theme);
        }
    }

    private static abstract class zza extends com.google.android.gms.common.api.zza.zza<Status, zznk> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzNX, googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.zza(new zza(googleApiClient) {
            protected void zza(zznk com_google_android_gms_internal_zznk) throws RemoteException {
                com_google_android_gms_internal_zznk.zza(request, requestCode);
                setResult(Status.zzXP);
            }
        });
    }
}
