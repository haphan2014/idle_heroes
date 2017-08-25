package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.location.places.zzm.zzd;
import com.google.android.gms.location.places.zzm.zzf;

public class zzi implements PlaceDetectionApi {
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient client, final PlaceFilter filter) {
        return client.zza(new zzd<zzj>(this, Places.zzazR, client) {
            final /* synthetic */ zzi zzaAq;

            protected void zza(zzj com_google_android_gms_location_places_internal_zzj) throws RemoteException {
                com_google_android_gms_location_places_internal_zzj.zza(new zzm((zzd) this, com_google_android_gms_location_places_internal_zzj.getContext()), filter);
            }
        });
    }

    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient client, final PlaceReport report) {
        return client.zzb(new zzf<zzj>(this, Places.zzazR, client) {
            final /* synthetic */ zzi zzaAq;

            protected void zza(zzj com_google_android_gms_location_places_internal_zzj) throws RemoteException {
                com_google_android_gms_location_places_internal_zzj.zza(new zzm((zzf) this), report);
            }
        });
    }
}
