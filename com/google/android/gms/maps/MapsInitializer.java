package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        zzu.zzu(context);
        try {
            zza(zzy.zzay(context));
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return e.errorCode;
        }
    }

    public static void zza(zzc com_google_android_gms_maps_internal_zzc) {
        try {
            CameraUpdateFactory.zza(com_google_android_gms_maps_internal_zzc.zzvC());
            BitmapDescriptorFactory.zza(com_google_android_gms_maps_internal_zzc.zzvD());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
