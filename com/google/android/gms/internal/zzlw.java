package com.google.android.gms.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.fitness.zza;
import java.util.Set;

public abstract class zzlw<T extends IInterface> extends zzi<T> {
    protected zzlw(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zze com_google_android_gms_common_internal_zze) {
        super(context, looper, i, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
    }

    public boolean requiresAccount() {
        return true;
    }

    public boolean requiresSignIn() {
        return !zzlv.zzam(getContext());
    }

    protected Set<Scope> zza(Set<Scope> set) {
        return zza.zzd(set);
    }
}
