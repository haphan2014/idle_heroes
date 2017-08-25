package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zzd extends zzi<zzf> {
    private final PlacesParams zzaAl;
    private final Locale zzaAm = Locale.getDefault();

    public static class zza implements com.google.android.gms.common.api.Api.zza<zzd, PlacesOptions> {
        private final String zzaAn;
        private final String zzaAo;

        public zza(String str, String str2) {
            this.zzaAn = str;
            this.zzaAo = str2;
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzd zza(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, com_google_android_gms_common_internal_zze, connectionCallbacks, onConnectionFailedListener, this.zzaAn != null ? this.zzaAn : context.getPackageName(), this.zzaAo != null ? this.zzaAo : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzd(Context context, Looper looper, zze com_google_android_gms_common_internal_zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 65, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        String str3 = null;
        if (com_google_android_gms_common_internal_zze.getAccount() != null) {
            str3 = com_google_android_gms_common_internal_zze.getAccount().name;
        }
        this.zzaAl = new PlacesParams(str, this.zzaAm, str3, placesOptions.zzazX, str2);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzbY(iBinder);
    }

    public void zza(zzm com_google_android_gms_location_places_zzm, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzu.zzb((Object) addPlaceRequest, (Object) "userAddedPlace == null");
        ((zzf) zznM()).zza(addPlaceRequest, this.zzaAl, (zzh) com_google_android_gms_location_places_zzm);
    }

    public void zza(zzm com_google_android_gms_location_places_zzm, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzu.zzb((Object) str, (Object) "query == null");
        zzu.zzb((Object) latLngBounds, (Object) "bounds == null");
        zzu.zzb((Object) com_google_android_gms_location_places_zzm, (Object) "callback == null");
        ((zzf) zznM()).zza(str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create(null) : autocompleteFilter, this.zzaAl, (zzh) com_google_android_gms_location_places_zzm);
    }

    public void zza(zzm com_google_android_gms_location_places_zzm, List<String> list) throws RemoteException {
        ((zzf) zznM()).zzb((List) list, this.zzaAl, (zzh) com_google_android_gms_location_places_zzm);
    }

    protected zzf zzbY(IBinder iBinder) {
        return com.google.android.gms.location.places.internal.zzf.zza.zzca(iBinder);
    }
}
