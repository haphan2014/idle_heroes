package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zza implements ActivityRecognitionApi {

    private static abstract class zza extends com.google.android.gms.location.ActivityRecognition.zza<Status> {
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

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zza zzayv;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        final long j = detectionIntervalMillis;
        final PendingIntent pendingIntent = callbackIntent;
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zza zzayv;

            protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
                com_google_android_gms_location_internal_zzj.zza(j, pendingIntent);
                setResult(Status.zzXP);
            }
        });
    }
}
