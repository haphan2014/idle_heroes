package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;

public class zzpj implements SafetyNetApi {

    static abstract class zzb extends zzpg<AttestationResult> {
        protected zzph zzaJC = new C10511(this);

        class C10511 extends zzpf {
            final /* synthetic */ zzb zzaJD;

            C10511(zzb com_google_android_gms_internal_zzpj_zzb) {
                this.zzaJD = com_google_android_gms_internal_zzpj_zzb;
            }

            public void zza(Status status, AttestationData attestationData) {
                this.zzaJD.setResult(new zza(status, attestationData));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaR(x0);
        }

        protected AttestationResult zzaR(Status status) {
            return new zza(status, null);
        }
    }

    static class zza implements AttestationResult {
        private final Status zzOt;
        private final AttestationData zzaJB;

        public zza(Status status, AttestationData attestationData) {
            this.zzOt = status;
            this.zzaJB = attestationData;
        }

        public String getJwsResult() {
            return this.zzaJB == null ? null : this.zzaJB.getJwsResult();
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] nonce) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzpj zzaJA;

            protected void zza(zzpk com_google_android_gms_internal_zzpk) throws RemoteException {
                com_google_android_gms_internal_zzpk.zza(this.zzaJC, nonce);
            }
        });
    }
}
