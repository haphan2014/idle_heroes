package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzpi.zza;

public class zzpk extends zzi<zzpi> {
    public zzpk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, connectionCallbacks, onConnectionFailedListener);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.safetynet.service.START";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzdy(iBinder);
    }

    public void zza(zzph com_google_android_gms_internal_zzph, byte[] bArr) throws RemoteException {
        ((zzpi) zznM()).zza(com_google_android_gms_internal_zzph, bArr);
    }

    protected zzpi zzdy(IBinder iBinder) {
        return zza.zzdx(iBinder);
    }
}
