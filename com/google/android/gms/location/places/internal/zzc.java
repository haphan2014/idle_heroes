package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.location.places.zzm.zza;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

public class zzc implements GeoDataApi {
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient client, final AddPlaceRequest addPlaceRequest) {
        return client.zzb(new com.google.android.gms.location.places.zzm.zzc<zzd>(this, Places.zzazQ, client) {
            final /* synthetic */ zzc zzaAh;

            protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
                com_google_android_gms_location_places_internal_zzd.zza(new zzm((com.google.android.gms.location.places.zzm.zzc) this, com_google_android_gms_location_places_internal_zzd.getContext()), addPlaceRequest);
            }
        });
    }

    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient client, String query, LatLngBounds bounds, AutocompleteFilter filter) {
        final String str = query;
        final LatLngBounds latLngBounds = bounds;
        final AutocompleteFilter autocompleteFilter = filter;
        return client.zza(new zza<zzd>(this, Places.zzazQ, client) {
            final /* synthetic */ zzc zzaAh;

            protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
                com_google_android_gms_location_places_internal_zzd.zza(new zzm((zza) this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient client, final String... placeIds) {
        boolean z = true;
        if (placeIds == null || placeIds.length < 1) {
            z = false;
        }
        zzu.zzV(z);
        return client.zza(new com.google.android.gms.location.places.zzm.zzc<zzd>(this, Places.zzazQ, client) {
            final /* synthetic */ zzc zzaAh;

            protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
                com_google_android_gms_location_places_internal_zzd.zza(new zzm((com.google.android.gms.location.places.zzm.zzc) this, com_google_android_gms_location_places_internal_zzd.getContext()), Arrays.asList(placeIds));
            }
        });
    }
}
