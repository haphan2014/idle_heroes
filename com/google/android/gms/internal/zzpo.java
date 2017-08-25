package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzpn.zza;

public class zzpo extends zzi<zzpn> {
    public zzpo(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zze com_google_android_gms_common_internal_zze) {
        super(context, context.getMainLooper(), 73, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzdB(iBinder);
    }

    protected zzpn zzdB(IBinder iBinder) {
        return zza.zzdA(iBinder);
    }
}
