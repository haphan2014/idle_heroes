package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;

public class zznb implements HistoryApi {

    private static class zza extends com.google.android.gms.internal.zzmf.zza {
        private final zzb<DataReadResult> zzOs;
        private int zzalm;
        private DataReadResult zzaln;

        private zza(zzb<DataReadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataReadResult) {
            this.zzalm = 0;
            this.zzaln = null;
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataReadResult;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.zzaln == null) {
                    this.zzaln = dataReadResult;
                } else {
                    this.zzaln.zzb(dataReadResult);
                }
                this.zzalm++;
                if (this.zzalm == this.zzaln.zzrt()) {
                    this.zzOs.zzm(this.zzaln);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzu.zzb((Object) dataSet, (Object) "Must set the data set");
        zzu.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzu.zzb(dataSet.getDataSource().zzqB(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zznb zzalh;

            protected void zza(zzlz com_google_android_gms_internal_zzlz) throws RemoteException {
                ((zzmk) com_google_android_gms_internal_zzlz.zznM()).zza(new DataInsertRequest(dataSet, new zzng(this), com_google_android_gms_internal_zzlz.getContext().getPackageName(), z));
            }
        });
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zznb zzalh;

            protected void zza(zzlz com_google_android_gms_internal_zzlz) throws RemoteException {
                ((zzmk) com_google_android_gms_internal_zzlz.zznM()).zza(new DataDeleteRequest(request, new zzng(this), com_google_android_gms_internal_zzlz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<DailyTotalResult>(this, client) {
            final /* synthetic */ zznb zzalh;

            class C10001 extends com.google.android.gms.internal.zzme.zza {
                final /* synthetic */ C10014 zzall;

                C10001(C10014 c10014) {
                    this.zzall = c10014;
                }

                public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                    this.zzall.setResult(dailyTotalResult);
                }
            }

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzE(x0);
            }

            protected DailyTotalResult zzE(Status status) {
                return DailyTotalResult.zzK(status);
            }

            protected void zza(zzlz com_google_android_gms_internal_zzlz) throws RemoteException {
                ((zzmk) com_google_android_gms_internal_zzlz.zznM()).zza(new DailyTotalRequest(new C10001(this), dataType, com_google_android_gms_internal_zzlz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.zza(new zza<DataReadResult>(this, client) {
            final /* synthetic */ zznb zzalh;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzD(x0);
            }

            protected DataReadResult zzD(Status status) {
                return DataReadResult.zza(status, request);
            }

            protected void zza(zzlz com_google_android_gms_internal_zzlz) throws RemoteException {
                ((zzmk) com_google_android_gms_internal_zzlz.zznM()).zza(new DataReadRequest(request, new zza(this), com_google_android_gms_internal_zzlz.getContext().getPackageName()));
            }
        });
    }
}
