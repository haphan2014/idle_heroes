package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zznf implements SessionsApi {

    private static class zza extends com.google.android.gms.internal.zzms.zza {
        private final com.google.android.gms.common.api.zza.zzb<SessionReadResult> zzOs;

        private zza(com.google.android.gms.common.api.zza.zzb<SessionReadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzOs.zzm(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzmt.zza {
        private final com.google.android.gms.common.api.zza.zzb<SessionStopResult> zzOs;

        private zzb(com.google.android.gms.common.api.zza.zzb<SessionStopResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzOs.zzm(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zza<SessionStopResult>(this, googleApiClient) {
            final /* synthetic */ zznf zzalC;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzH(x0);
            }

            protected SessionStopResult zzH(Status status) {
                return SessionStopResult.zzP(status);
            }

            protected void zza(zzmd com_google_android_gms_internal_zzmd) throws RemoteException {
                ((zzmo) com_google_android_gms_internal_zzmd.zznM()).zza(new SessionStopRequest(str, str2, new zzb(this), com_google_android_gms_internal_zzmd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zznf zzalC;

            protected void zza(zzmd com_google_android_gms_internal_zzmd) throws RemoteException {
                ((zzmo) com_google_android_gms_internal_zzmd.zznM()).zza(new SessionInsertRequest(request, new zzng(this), com_google_android_gms_internal_zzmd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.zza(new zza<SessionReadResult>(this, client) {
            final /* synthetic */ zznf zzalC;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzI(x0);
            }

            protected SessionReadResult zzI(Status status) {
                return SessionReadResult.zzO(status);
            }

            protected void zza(zzmd com_google_android_gms_internal_zzmd) throws RemoteException {
                ((zzmo) com_google_android_gms_internal_zzmd.zznM()).zza(new SessionReadRequest(request, new zza(this), com_google_android_gms_internal_zzmd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        zzu.zzb((Object) session, (Object) "Session cannot be null");
        zzu.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zznf zzalC;

            protected void zza(zzmd com_google_android_gms_internal_zzmd) throws RemoteException {
                ((zzmo) com_google_android_gms_internal_zzmd.zznM()).zza(new SessionStartRequest(session, new zzng(this), com_google_android_gms_internal_zzmd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zznf zzalC;

            protected void zza(zzmd com_google_android_gms_internal_zzmd) throws RemoteException {
                ((zzmo) com_google_android_gms_internal_zzmd.zznM()).zza(new SessionUnregistrationRequest(intent, new zzng(this), com_google_android_gms_internal_zzmd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zznf zzalC;

            protected void zza(zzmd com_google_android_gms_internal_zzmd) throws RemoteException {
                ((zzmo) com_google_android_gms_internal_zzmd.zznM()).zza(new SessionRegistrationRequest(pendingIntent, new zzng(this), com_google_android_gms_internal_zzmd.getContext().getPackageName(), i));
            }
        });
    }
}
