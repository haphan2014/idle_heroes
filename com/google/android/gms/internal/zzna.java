package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zzna implements ConfigApi {

    private static class zza extends com.google.android.gms.internal.zzmh.zza {
        private final zzb<DataTypeResult> zzOs;

        private zza(zzb<DataTypeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzOs.zzm(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.zzb(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzna zzald;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzC(x0);
            }

            protected DataTypeResult zzC(Status status) {
                return DataTypeResult.zzM(status);
            }

            protected void zza(zzly com_google_android_gms_internal_zzly) throws RemoteException {
                ((zzmj) com_google_android_gms_internal_zzly.zznM()).zza(new DataTypeCreateRequest(request, new zza(this), com_google_android_gms_internal_zzly.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzna zzald;

            protected void zza(zzly com_google_android_gms_internal_zzly) throws RemoteException {
                ((zzmj) com_google_android_gms_internal_zzly.zznM()).zza(new DisableFitRequest(new zzng(this), com_google_android_gms_internal_zzly.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, final String dataTypeName) {
        return client.zza(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzna zzald;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzC(x0);
            }

            protected DataTypeResult zzC(Status status) {
                return DataTypeResult.zzM(status);
            }

            protected void zza(zzly com_google_android_gms_internal_zzly) throws RemoteException {
                ((zzmj) com_google_android_gms_internal_zzly.zznM()).zza(new DataTypeReadRequest(dataTypeName, new zza(this), com_google_android_gms_internal_zzly.getContext().getPackageName()));
            }
        });
    }
}
