package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zze.zzb;
import java.util.List;

public class zze implements GeofencingApi {

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

    public PendingResult<Status> addGeofences(GoogleApiClient client, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zze zzayG;

            class C10891 implements com.google.android.gms.location.zze.zza {
                final /* synthetic */ C10901 zzayH;

                C10891(C10901 c10901) {
                    this.zzayH = c10901;
                }

                public void zza(int i, String[] strArr) {
                    this.zzayH.setResult(LocationStatusCodes.zzgB(i));
                }
            }

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(geofencingRequest, pendingIntent, new C10891(this));
            }
        });
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(geofences);
        builder.setInitialTrigger(5);
        return addGeofences(client, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zze zzayG;

            class C10911 implements zzb {
                final /* synthetic */ C10922 zzayI;

                C10911(C10922 c10922) {
                    this.zzayI = c10922;
                }

                public void zza(int i, PendingIntent pendingIntent) {
                    this.zzayI.setResult(LocationStatusCodes.zzgB(i));
                }

                public void zzb(int i, String[] strArr) {
                    Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                }
            }

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(pendingIntent, new C10911(this));
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zze zzayG;

            class C10931 implements zzb {
                final /* synthetic */ C10943 zzayK;

                C10931(C10943 c10943) {
                    this.zzayK = c10943;
                }

                public void zza(int i, PendingIntent pendingIntent) {
                    Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                }

                public void zzb(int i, String[] strArr) {
                    this.zzayK.setResult(LocationStatusCodes.zzgB(i));
                }
            }

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(geofenceRequestIds, new C10931(this));
            }
        });
    }
}
