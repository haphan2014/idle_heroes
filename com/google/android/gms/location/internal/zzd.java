package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzd implements FusedLocationProviderApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).zzuw();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zzd(callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationCallback callback) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(callback);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(listener);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zzb(request, callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationCallback callback, Looper looper) {
        final LocationRequest locationRequest = request;
        final LocationCallback locationCallback = callback;
        final Looper looper2 = looper;
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(LocationRequestInternal.zzb(locationRequest), locationCallback, looper2);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(request, listener, null);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        final LocationRequest locationRequest = request;
        final LocationListener locationListener = listener;
        final Looper looper2 = looper;
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(locationRequest, locationListener, looper2);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zzb(mockLocation);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzd zzayA;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zzac(isMockMode);
                setResult(Status.zzXP);
            }
        });
    }
}
