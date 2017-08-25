package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.location.internal.zzg.zza;

public class zzb extends zzi<zzg> {
    protected final zzn<zzg> zzayq = new C10791(this);
    private final String zzayw;

    class C10791 implements zzn<zzg> {
        final /* synthetic */ zzb zzayx;

        C10791(zzb com_google_android_gms_location_internal_zzb) {
            this.zzayx = com_google_android_gms_location_internal_zzb;
        }

        public void zznL() {
            this.zzayx.zznL();
        }

        public /* synthetic */ IInterface zznM() throws DeadObjectException {
            return zzut();
        }

        public zzg zzut() throws DeadObjectException {
            return (zzg) this.zzayx.zznM();
        }
    }

    public zzb(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zze com_google_android_gms_common_internal_zze) {
        super(context, looper, 23, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        this.zzayw = str;
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzbU(iBinder);
    }

    protected zzg zzbU(IBinder iBinder) {
        return zza.zzbW(iBinder);
    }

    protected Bundle zzkR() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzayw);
        return bundle;
    }
}
