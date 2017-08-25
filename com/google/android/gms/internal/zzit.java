package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zziq.zza;

public class zzit extends zzi<zziq> {
    public zzit(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, connectionCallbacks, onConnectionFailedListener);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzaf(iBinder);
    }

    protected zziq zzaf(IBinder iBinder) {
        return zza.zzad(iBinder);
    }

    public zziq zzkO() throws DeadObjectException {
        return (zziq) zznM();
    }
}
