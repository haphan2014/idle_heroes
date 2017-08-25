package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzou.zza;

public class zzow extends zzi<zzou> {
    public zzow(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 3, connectionCallbacks, onConnectionFailedListener);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.panorama.service.START";
    }

    public /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzdo(iBinder);
    }

    public zzou zzdo(IBinder iBinder) {
        return zza.zzdn(iBinder);
    }
}
