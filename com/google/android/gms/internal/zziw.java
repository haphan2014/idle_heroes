package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zziw implements AppInviteApi {

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzix> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppInvite.zzNX, googleApiClient);
        }
    }

    final class zzb extends zza<Status> {
        private final String zzNZ;
        final /* synthetic */ zziw zzOa;

        class C09631 extends com.google.android.gms.internal.zziy.zza {
            final /* synthetic */ zzb zzOb;

            C09631(zzb com_google_android_gms_internal_zziw_zzb) {
                this.zzOb = com_google_android_gms_internal_zziw_zzb;
            }

            public void zzc(Status status) throws RemoteException {
                this.zzOb.setResult(status);
            }
        }

        public zzb(zziw com_google_android_gms_internal_zziw, GoogleApiClient googleApiClient, String str) {
            this.zzOa = com_google_android_gms_internal_zziw;
            super(googleApiClient);
            this.zzNZ = str;
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzix com_google_android_gms_internal_zzix) throws RemoteException {
            com_google_android_gms_internal_zzix.zzb(new C09631(this), this.zzNZ);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    final class zzc extends zza<Status> {
        private final String zzNZ;
        final /* synthetic */ zziw zzOa;

        class C09641 extends com.google.android.gms.internal.zziy.zza {
            final /* synthetic */ zzc zzOc;

            C09641(zzc com_google_android_gms_internal_zziw_zzc) {
                this.zzOc = com_google_android_gms_internal_zziw_zzc;
            }

            public void zzc(Status status) throws RemoteException {
                this.zzOc.setResult(status);
            }
        }

        public zzc(zziw com_google_android_gms_internal_zziw, GoogleApiClient googleApiClient, String str) {
            this.zzOa = com_google_android_gms_internal_zziw;
            super(googleApiClient);
            this.zzNZ = str;
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected void zza(zzix com_google_android_gms_internal_zzix) throws RemoteException {
            com_google_android_gms_internal_zzix.zza(new C09641(this), this.zzNZ);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient client, String invitationId) {
        return client.zza(new zzc(this, client, invitationId));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient client, String invitationId) {
        return client.zza(new zzb(this, client, invitationId));
    }
}
