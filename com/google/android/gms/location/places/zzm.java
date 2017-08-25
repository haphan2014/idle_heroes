package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzlm;

public class zzm extends com.google.android.gms.location.places.internal.zzh.zza {
    private static final String TAG = zzm.class.getSimpleName();
    private final Context mContext;
    private final zzd zzazS;
    private final zza zzazT;
    private final zze zzazU;
    private final zzf zzazV;
    private final zzc zzazW;

    public static abstract class zzb<R extends Result, A extends Client> extends com.google.android.gms.common.api.zza.zza<R, A> {
        public zzb(ClientKey<A> clientKey, GoogleApiClient googleApiClient) {
            super(clientKey, googleApiClient);
        }
    }

    public static abstract class zzc<A extends Client> extends zzb<PlaceBuffer, A> {
        public zzc(ClientKey<A> clientKey, GoogleApiClient googleApiClient) {
            super(clientKey, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaH(x0);
        }

        protected PlaceBuffer zzaH(Status status) {
            return new PlaceBuffer(DataHolder.zzbi(status.getStatusCode()), null);
        }
    }

    public static abstract class zza<A extends Client> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(ClientKey<A> clientKey, GoogleApiClient googleApiClient) {
            super(clientKey, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaG(x0);
        }

        protected AutocompletePredictionBuffer zzaG(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbi(status.getStatusCode()));
        }
    }

    public static abstract class zzd<A extends Client> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(ClientKey<A> clientKey, GoogleApiClient googleApiClient) {
            super(clientKey, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaI(x0);
        }

        protected PlaceLikelihoodBuffer zzaI(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbi(status.getStatusCode()), 100, null);
        }
    }

    public static abstract class zzf<A extends Client> extends zzb<Status, A> {
        public zzf(ClientKey<A> clientKey, GoogleApiClient googleApiClient) {
            super(clientKey, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    public static abstract class zze<A extends Client> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaJ(x0);
        }

        protected com.google.android.gms.location.places.personalized.zzd zzaJ(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaK(status);
        }
    }

    public zzm(zza com_google_android_gms_location_places_zzm_zza) {
        this.zzazS = null;
        this.zzazT = com_google_android_gms_location_places_zzm_zza;
        this.zzazU = null;
        this.zzazV = null;
        this.zzazW = null;
        this.mContext = null;
    }

    public zzm(zzc com_google_android_gms_location_places_zzm_zzc, Context context) {
        this.zzazS = null;
        this.zzazT = null;
        this.zzazU = null;
        this.zzazV = null;
        this.zzazW = com_google_android_gms_location_places_zzm_zzc;
        this.mContext = context;
    }

    public zzm(zzd com_google_android_gms_location_places_zzm_zzd, Context context) {
        this.zzazS = com_google_android_gms_location_places_zzm_zzd;
        this.zzazT = null;
        this.zzazU = null;
        this.zzazV = null;
        this.zzazW = null;
        this.mContext = context;
    }

    public zzm(zzf com_google_android_gms_location_places_zzm_zzf) {
        this.zzazS = null;
        this.zzazT = null;
        this.zzazU = null;
        this.zzazV = com_google_android_gms_location_places_zzm_zzf;
        this.zzazW = null;
        this.mContext = null;
    }

    public void zzY(DataHolder dataHolder) throws RemoteException {
        zzu.zza(this.zzazS != null, (Object) "placeEstimator cannot be null");
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzlm.zzpa());
            }
            this.zzazS.zzr(Status.zzXR);
            return;
        }
        this.zzazS.setResult(new PlaceLikelihoodBuffer(dataHolder, 100, this.mContext));
    }

    public void zzZ(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzlm.zzpa());
            }
            this.zzazT.zzr(Status.zzXR);
            return;
        }
        this.zzazT.setResult(new AutocompletePredictionBuffer(dataHolder));
    }

    public void zzaF(Status status) throws RemoteException {
        this.zzazV.setResult(status);
    }

    public void zzaa(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzlm.zzpa());
            }
            this.zzazU.zzr(Status.zzXR);
            return;
        }
        this.zzazU.setResult(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
    }

    public void zzab(DataHolder dataHolder) throws RemoteException {
        this.zzazW.setResult(new PlaceBuffer(dataHolder, this.mContext));
    }
}
