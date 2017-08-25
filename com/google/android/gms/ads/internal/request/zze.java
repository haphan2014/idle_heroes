package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.internal.request.zzi.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zze extends zzi<zzi> {
    final int zzCk;

    public zze(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), 8, connectionCallbacks, onConnectionFailedListener);
        this.zzCk = i;
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    protected zzi zzS(IBinder iBinder) {
        return zza.zzU(iBinder);
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzS(iBinder);
    }

    public zzi zzfy() throws DeadObjectException {
        return (zzi) super.zznM();
    }
}
