package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.nearby.sharing.internal.zzd.zza;

class zze extends zzi<zzd> {
    public zze(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze) {
        super(context, looper, 49, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzdl(iBinder);
    }

    protected zzd zzdl(IBinder iBinder) {
        return zza.zzdk(iBinder);
    }
}
