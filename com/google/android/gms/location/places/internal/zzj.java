package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzm;
import java.util.Locale;

public class zzj extends zzi<zze> {
    private final PlacesParams zzaAl;
    private final Locale zzaAm = Locale.getDefault();

    public static class zza implements com.google.android.gms.common.api.Api.zza<zzj, PlacesOptions> {
        private final String zzaAn;
        private final String zzaAo;

        public zza(String str, String str2) {
            this.zzaAn = str;
            this.zzaAo = str2;
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public /* synthetic */ Client zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zze, (PlacesOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzj zzb(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, com_google_android_gms_common_internal_zze, connectionCallbacks, onConnectionFailedListener, this.zzaAn != null ? this.zzaAn : context.getPackageName(), this.zzaAo != null ? this.zzaAo : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzj(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 67, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        String str3 = null;
        if (com_google_android_gms_common_internal_zze.getAccount() != null) {
            str3 = com_google_android_gms_common_internal_zze.getAccount().name;
        }
        this.zzaAl = new PlacesParams(str, this.zzaAm, str3, placesOptions.zzazX, str2);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzcd(iBinder);
    }

    public void zza(zzm com_google_android_gms_location_places_zzm, PlaceFilter placeFilter) throws RemoteException {
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzuJ();
        }
        ((zze) zznM()).zza(placeFilter, this.zzaAl, (zzh) com_google_android_gms_location_places_zzm);
    }

    public void zza(zzm com_google_android_gms_location_places_zzm, PlaceReport placeReport) throws RemoteException {
        zzu.zzu(placeReport);
        ((zze) zznM()).zza(placeReport, this.zzaAl, (zzh) com_google_android_gms_location_places_zzm);
    }

    protected zze zzcd(IBinder iBinder) {
        return com.google.android.gms.location.places.internal.zze.zza.zzbZ(iBinder);
    }
}
