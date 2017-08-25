package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzne implements SensorsApi {

    private interface zza {
        void zzqR();
    }

    private static class zzb extends com.google.android.gms.internal.zzmg.zza {
        private final com.google.android.gms.common.api.zza.zzb<DataSourcesResult> zzOs;

        private zzb(com.google.android.gms.common.api.zza.zzb<DataSourcesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzOs.zzm(dataSourcesResult);
        }
    }

    private static class zzc extends com.google.android.gms.internal.zzmu.zza {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzOs;
        private final zza zzalA;

        private zzc(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zzne_zza) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
            this.zzalA = com_google_android_gms_internal_zzne_zza;
        }

        public void zzm(Status status) {
            if (this.zzalA != null && status.isSuccess()) {
                this.zzalA.zzqR();
            }
            this.zzOs.zzm(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent, zza com_google_android_gms_internal_zzne_zza) {
        final zza com_google_android_gms_internal_zzne_zza2 = com_google_android_gms_internal_zzne_zza;
        final zzj com_google_android_gms_fitness_data_zzj2 = com_google_android_gms_fitness_data_zzj;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzne zzals;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzmc com_google_android_gms_internal_zzmc) throws RemoteException {
                ((zzmn) com_google_android_gms_internal_zzmc.zznM()).zza(new SensorUnregistrationRequest(com_google_android_gms_fitness_data_zzj2, pendingIntent2, new zzc(this, com_google_android_gms_internal_zzne_zza2), com_google_android_gms_internal_zzmc.getContext().getPackageName()));
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent) {
        final SensorRequest sensorRequest2 = sensorRequest;
        final zzj com_google_android_gms_fitness_data_zzj2 = com_google_android_gms_fitness_data_zzj;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzne zzals;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzb(x0);
            }

            protected void zza(zzmc com_google_android_gms_internal_zzmc) throws RemoteException {
                ((zzmn) com_google_android_gms_internal_zzmc.zznM()).zza(new SensorRegistrationRequest(sensorRequest2, com_google_android_gms_fitness_data_zzj2, pendingIntent2, new zzng(this), com_google_android_gms_internal_zzmc.getContext().getPackageName()));
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, null, intent);
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, com.google.android.gms.fitness.data.zzk.zza.zzqH().zza(listener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.zza(new zza<DataSourcesResult>(this, client) {
            final /* synthetic */ zzne zzals;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzG(x0);
            }

            protected DataSourcesResult zzG(Status status) {
                return DataSourcesResult.zzL(status);
            }

            protected void zza(zzmc com_google_android_gms_internal_zzmc) throws RemoteException {
                ((zzmn) com_google_android_gms_internal_zzmc.zznM()).zza(new DataSourcesRequest(request, new zzb(this), com_google_android_gms_internal_zzmc.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        zzj zzb = com.google.android.gms.fitness.data.zzk.zza.zzqH().zzb(listener);
        return zzb == null ? new zzmw(Status.zzXP) : zza(client, zzb, null, new zza(this) {
            final /* synthetic */ zzne zzals;

            public void zzqR() {
                com.google.android.gms.fitness.data.zzk.zza.zzqH().zzc(listener);
            }
        });
    }
}
