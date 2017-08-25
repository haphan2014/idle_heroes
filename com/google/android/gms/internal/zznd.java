package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zznd implements RecordingApi {

    private static class zza extends com.google.android.gms.internal.zzmp.zza {
        private final zzb<ListSubscriptionsResult> zzOs;

        private zza(zzb<ListSubscriptionsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzOs.zzm(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zznd zzalo;

            protected void zza(zzmb com_google_android_gms_internal_zzmb) throws RemoteException {
                ((zzmm) com_google_android_gms_internal_zzmb.zznM()).zza(new SubscribeRequest(subscription, false, new zzng(this), com_google_android_gms_internal_zzmb.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zznd zzalo;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzF(x0);
            }

            protected ListSubscriptionsResult zzF(Status status) {
                return ListSubscriptionsResult.zzN(status);
            }

            protected void zza(zzmb com_google_android_gms_internal_zzmb) throws RemoteException {
                ((zzmm) com_google_android_gms_internal_zzmb.zznM()).zza(new ListSubscriptionsRequest(null, new zza(this), com_google_android_gms_internal_zzmb.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zznd zzalo;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzF(x0);
            }

            protected ListSubscriptionsResult zzF(Status status) {
                return ListSubscriptionsResult.zzN(status);
            }

            protected void zza(zzmb com_google_android_gms_internal_zzmb) throws RemoteException {
                ((zzmm) com_google_android_gms_internal_zzmb.zznM()).zza(new ListSubscriptionsRequest(dataType, new zza(this), com_google_android_gms_internal_zzmb.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzqN());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zzqN());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataSource dataSource) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zznd zzalo;

            protected void zza(zzmb com_google_android_gms_internal_zzmb) throws RemoteException {
                ((zzmm) com_google_android_gms_internal_zzmb.zznM()).zza(new UnsubscribeRequest(null, dataSource, new zzng(this), com_google_android_gms_internal_zzmb.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataType dataType) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zznd zzalo;

            protected void zza(zzmb com_google_android_gms_internal_zzmb) throws RemoteException {
                ((zzmm) com_google_android_gms_internal_zzmb.zznM()).zza(new UnsubscribeRequest(dataType, null, new zzng(this), com_google_android_gms_internal_zzmb.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
