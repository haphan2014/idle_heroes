package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzpp implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzpm.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzb extends com.google.android.gms.common.api.zza.zza<GoogleNowAuthResult, zzpo> {
        private final GoogleApiClient zzRa;
        private final String zzaJI;
        private final boolean zzaJJ = Log.isLoggable("SearchAuth", 3);

        class C10521 extends zza {
            final /* synthetic */ zzb zzaJK;

            C10521(zzb com_google_android_gms_internal_zzpp_zzb) {
                this.zzaJK = com_google_android_gms_internal_zzpp_zzb;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                if (this.zzaJK.zzaJJ) {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                this.zzaJK.setResult(new zzc(status, googleNowAuthState));
            }
        }

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzNX, googleApiClient);
            this.zzRa = googleApiClient;
            this.zzaJI = str;
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaS(x0);
        }

        protected void zza(zzpo com_google_android_gms_internal_zzpo) throws RemoteException {
            if (this.zzaJJ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String packageName = this.zzRa.getContext().getPackageName();
            ((zzpn) com_google_android_gms_internal_zzpo.zznM()).zza(new C10521(this), packageName, this.zzaJI);
        }

        protected GoogleNowAuthResult zzaS(Status status) {
            if (this.zzaJJ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzc(status, null);
        }
    }

    static class zzc implements GoogleNowAuthResult {
        private final Status zzOt;
        private final GoogleNowAuthState zzaJL;

        zzc(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzOt = status;
            this.zzaJL = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzaJL;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient client, String webAppClientId) {
        return client.zza(new zzb(client, webAppClientId));
    }
}
