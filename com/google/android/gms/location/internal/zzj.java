package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;
import java.util.List;

public class zzj extends zzb {
    private final zzi zzayR;
    private final com.google.android.gms.location.copresence.internal.zzb zzayS;

    private final class zza extends zzc<com.google.android.gms.location.zze.zza> {
        private final int zzTS;
        private final String[] zzayT;
        final /* synthetic */ zzj zzayU;

        public zza(zzj com_google_android_gms_location_internal_zzj, com.google.android.gms.location.zze.zza com_google_android_gms_location_zze_zza, int i, String[] strArr) {
            this.zzayU = com_google_android_gms_location_internal_zzj;
            super(com_google_android_gms_location_internal_zzj, com_google_android_gms_location_zze_zza);
            this.zzTS = LocationStatusCodes.zzgA(i);
            this.zzayT = strArr;
        }

        protected void zza(com.google.android.gms.location.zze.zza com_google_android_gms_location_zze_zza) {
            if (com_google_android_gms_location_zze_zza != null) {
                com_google_android_gms_location_zze_zza.zza(this.zzTS, this.zzayT);
            }
        }

        protected void zznP() {
        }

        protected /* synthetic */ void zzr(Object obj) {
            zza((com.google.android.gms.location.zze.zza) obj);
        }
    }

    private static final class zzb extends com.google.android.gms.location.internal.zzf.zza {
        private com.google.android.gms.location.zze.zza zzayV;
        private com.google.android.gms.location.zze.zzb zzayW;
        private zzj zzayX;

        public zzb(com.google.android.gms.location.zze.zza com_google_android_gms_location_zze_zza, zzj com_google_android_gms_location_internal_zzj) {
            this.zzayV = com_google_android_gms_location_zze_zza;
            this.zzayW = null;
            this.zzayX = com_google_android_gms_location_internal_zzj;
        }

        public zzb(com.google.android.gms.location.zze.zzb com_google_android_gms_location_zze_zzb, zzj com_google_android_gms_location_internal_zzj) {
            this.zzayW = com_google_android_gms_location_zze_zzb;
            this.zzayV = null;
            this.zzayX = com_google_android_gms_location_internal_zzj;
        }

        public void zza(int i, PendingIntent pendingIntent) {
            if (this.zzayX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            zzj com_google_android_gms_location_internal_zzj = this.zzayX;
            zzj com_google_android_gms_location_internal_zzj2 = this.zzayX;
            com_google_android_gms_location_internal_zzj2.getClass();
            com_google_android_gms_location_internal_zzj.zza(new zzc(com_google_android_gms_location_internal_zzj2, 1, this.zzayW, i, pendingIntent));
            this.zzayX = null;
            this.zzayV = null;
            this.zzayW = null;
        }

        public void zza(int i, String[] strArr) throws RemoteException {
            if (this.zzayX == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            zzj com_google_android_gms_location_internal_zzj = this.zzayX;
            zzj com_google_android_gms_location_internal_zzj2 = this.zzayX;
            com_google_android_gms_location_internal_zzj2.getClass();
            com_google_android_gms_location_internal_zzj.zza(new zza(com_google_android_gms_location_internal_zzj2, this.zzayV, i, strArr));
            this.zzayX = null;
            this.zzayV = null;
            this.zzayW = null;
        }

        public void zzb(int i, String[] strArr) {
            if (this.zzayX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            zzj com_google_android_gms_location_internal_zzj = this.zzayX;
            zzj com_google_android_gms_location_internal_zzj2 = this.zzayX;
            com_google_android_gms_location_internal_zzj2.getClass();
            com_google_android_gms_location_internal_zzj.zza(new zzc(com_google_android_gms_location_internal_zzj2, 2, this.zzayW, i, strArr));
            this.zzayX = null;
            this.zzayV = null;
            this.zzayW = null;
        }
    }

    private final class zzc extends zzc<com.google.android.gms.location.zze.zzb> {
        private final PendingIntent mPendingIntent;
        private final int zzTS;
        private final String[] zzayT;
        final /* synthetic */ zzj zzayU;
        private final int zzayY;

        public zzc(zzj com_google_android_gms_location_internal_zzj, int i, com.google.android.gms.location.zze.zzb com_google_android_gms_location_zze_zzb, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.zzayU = com_google_android_gms_location_internal_zzj;
            super(com_google_android_gms_location_internal_zzj, com_google_android_gms_location_zze_zzb);
            if (i != 1) {
                z = false;
            }
            com.google.android.gms.common.internal.zzb.zzU(z);
            this.zzayY = i;
            this.zzTS = LocationStatusCodes.zzgA(i2);
            this.mPendingIntent = pendingIntent;
            this.zzayT = null;
        }

        public zzc(zzj com_google_android_gms_location_internal_zzj, int i, com.google.android.gms.location.zze.zzb com_google_android_gms_location_zze_zzb, int i2, String[] strArr) {
            this.zzayU = com_google_android_gms_location_internal_zzj;
            super(com_google_android_gms_location_internal_zzj, com_google_android_gms_location_zze_zzb);
            com.google.android.gms.common.internal.zzb.zzU(i == 2);
            this.zzayY = i;
            this.zzTS = LocationStatusCodes.zzgA(i2);
            this.zzayT = strArr;
            this.mPendingIntent = null;
        }

        protected void zza(com.google.android.gms.location.zze.zzb com_google_android_gms_location_zze_zzb) {
            if (com_google_android_gms_location_zze_zzb != null) {
                switch (this.zzayY) {
                    case 1:
                        com_google_android_gms_location_zze_zzb.zza(this.zzTS, this.mPendingIntent);
                        return;
                    case 2:
                        com_google_android_gms_location_zze_zzb.zzb(this.zzTS, this.zzayT);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.zzayY);
                        return;
                }
            }
        }

        protected void zznP() {
        }

        protected /* synthetic */ void zzr(Object obj) {
            zza((com.google.android.gms.location.zze.zzb) obj);
        }
    }

    private static final class zzd extends com.google.android.gms.location.internal.zzh.zza {
        private com.google.android.gms.common.api.zza.zzb<LocationSettingsResult> zzayZ;

        public zzd(com.google.android.gms.common.api.zza.zzb<LocationSettingsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_location_LocationSettingsResult) {
            zzu.zzb(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_location_LocationSettingsResult != null, (Object) "listener can't be null.");
            this.zzayZ = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_location_LocationSettingsResult;
        }

        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.zzayZ.zzm(locationSettingsResult);
            this.zzayZ = null;
        }
    }

    public zzj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, new Builder(context).zzmx());
    }

    public zzj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zze com_google_android_gms_common_internal_zze) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zze, CopresenceApiOptions.zzayn);
    }

    public zzj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zze com_google_android_gms_common_internal_zze, CopresenceApiOptions copresenceApiOptions) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zze);
        this.zzayR = new zzi(context, this.zzayq);
        this.zzayS = com.google.android.gms.location.copresence.internal.zzb.zza(context, com_google_android_gms_common_internal_zze.getAccountName(), com_google_android_gms_common_internal_zze.zzny(), this.zzayq, copresenceApiOptions);
    }

    public void disconnect() {
        synchronized (this.zzayR) {
            if (isConnected()) {
                try {
                    this.zzayR.removeAllListeners();
                    this.zzayR.zzux();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.zzayR.getLastLocation();
    }

    public boolean requiresAccount() {
        return true;
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zznL();
        zzu.zzu(pendingIntent);
        zzu.zzb(j >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((zzg) zznM()).zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent) throws RemoteException {
        zznL();
        zzu.zzu(pendingIntent);
        ((zzg) zznM()).zza(pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, com.google.android.gms.location.zze.zzb com_google_android_gms_location_zze_zzb) throws RemoteException {
        zzf com_google_android_gms_location_internal_zzf;
        zznL();
        zzu.zzb((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzu.zzb((Object) com_google_android_gms_location_zze_zzb, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (com_google_android_gms_location_zze_zzb == null) {
            com_google_android_gms_location_internal_zzf = null;
        } else {
            Object com_google_android_gms_location_internal_zzj_zzb = new zzb(com_google_android_gms_location_zze_zzb, this);
        }
        ((zzg) zznM()).zza(pendingIntent, com_google_android_gms_location_internal_zzf, getContext().getPackageName());
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.location.zze.zza com_google_android_gms_location_zze_zza) throws RemoteException {
        zzf com_google_android_gms_location_internal_zzf;
        zznL();
        zzu.zzb((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        zzu.zzb((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzu.zzb((Object) com_google_android_gms_location_zze_zza, (Object) "OnAddGeofencesResultListener not provided.");
        if (com_google_android_gms_location_zze_zza == null) {
            com_google_android_gms_location_internal_zzf = null;
        } else {
            Object com_google_android_gms_location_internal_zzj_zzb = new zzb(com_google_android_gms_location_zze_zza, this);
        }
        ((zzg) zznM()).zza(geofencingRequest, pendingIntent, com_google_android_gms_location_internal_zzf);
    }

    public void zza(LocationCallback locationCallback) throws RemoteException {
        this.zzayR.zza(locationCallback);
    }

    public void zza(LocationListener locationListener) throws RemoteException {
        this.zzayR.zza(locationListener);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.zzayR) {
            this.zzayR.zza(locationRequest, locationListener, looper);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, com.google.android.gms.common.api.zza.zzb<LocationSettingsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_location_LocationSettingsResult, String str) throws RemoteException {
        boolean z = true;
        zznL();
        zzu.zzb(locationSettingsRequest != null, (Object) "locationSettingsRequest can't be null nor empty.");
        if (com_google_android_gms_common_api_zza_zzb_com_google_android_gms_location_LocationSettingsResult == null) {
            z = false;
        }
        zzu.zzb(z, (Object) "listener can't be null.");
        ((zzg) zznM()).zza(locationSettingsRequest, new zzd(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_location_LocationSettingsResult), str);
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper) throws RemoteException {
        synchronized (this.zzayR) {
            this.zzayR.zza(locationRequestInternal, locationCallback, looper);
        }
    }

    public void zza(List<String> list, com.google.android.gms.location.zze.zzb com_google_android_gms_location_zze_zzb) throws RemoteException {
        zzf com_google_android_gms_location_internal_zzf;
        zznL();
        boolean z = list != null && list.size() > 0;
        zzu.zzb(z, (Object) "geofenceRequestIds can't be null nor empty.");
        zzu.zzb((Object) com_google_android_gms_location_zze_zzb, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) list.toArray(new String[0]);
        if (com_google_android_gms_location_zze_zzb == null) {
            com_google_android_gms_location_internal_zzf = null;
        } else {
            Object com_google_android_gms_location_internal_zzj_zzb = new zzb(com_google_android_gms_location_zze_zzb, this);
        }
        ((zzg) zznM()).zza(strArr, com_google_android_gms_location_internal_zzf, getContext().getPackageName());
    }

    public void zzac(boolean z) throws RemoteException {
        this.zzayR.zzac(z);
    }

    public void zzb(Location location) throws RemoteException {
        this.zzayR.zzb(location);
    }

    public void zzb(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.zzayR.zzb(locationRequest, pendingIntent);
    }

    public void zzd(PendingIntent pendingIntent) throws RemoteException {
        this.zzayR.zzd(pendingIntent);
    }

    public LocationAvailability zzuw() {
        return this.zzayR.zzuw();
    }
}
