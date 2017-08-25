package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zziz.zza;

public class zzix extends zzi<zziz> {
    private final String zzOd;
    private final String zzOe;

    public zzix(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zze com_google_android_gms_common_internal_zze) {
        super(context, looper, 77, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        this.zzOd = com_google_android_gms_common_internal_zze.zznz();
        this.zzOe = com_google_android_gms_common_internal_zze.zzny();
    }

    private Bundle zzkS() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzOe);
        return bundle;
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.appinvite.service.START";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzag(iBinder);
    }

    public void zza(zziy com_google_android_gms_internal_zziy, String str) {
        try {
            ((zziz) zznM()).zza(com_google_android_gms_internal_zziy, str);
        } catch (RemoteException e) {
        }
    }

    protected zziz zzag(IBinder iBinder) {
        return zza.zzai(iBinder);
    }

    public void zzb(zziy com_google_android_gms_internal_zziy, String str) {
        try {
            ((zziz) zznM()).zzb(com_google_android_gms_internal_zziy, str);
        } catch (RemoteException e) {
        }
    }

    protected String zzkQ() {
        return this.zzOd;
    }

    protected Bundle zzkR() {
        return zzkS();
    }
}
