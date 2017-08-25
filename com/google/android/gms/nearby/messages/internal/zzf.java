package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

class zzf extends zzi<zzc> {
    private String zzOe;
    private String zzaGa;

    zzf(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zze com_google_android_gms_common_internal_zze, com.google.android.gms.nearby.messages.zze com_google_android_gms_nearby_messages_zze) {
        super(context, looper, 62, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        this.zzOe = com_google_android_gms_common_internal_zze.zzny();
        if (com_google_android_gms_nearby_messages_zze != null) {
            this.zzaGa = com_google_android_gms_nearby_messages_zze.zzayp;
        }
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    public boolean requiresAccount() {
        return true;
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzdg(iBinder);
    }

    protected zzc zzdg(IBinder iBinder) {
        return zza.zzdf(iBinder);
    }
}
