package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzov implements PanoramaApi {

    private static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzow> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzNX, googleApiClient);
        }

        protected abstract void zza(Context context, zzou com_google_android_gms_internal_zzou) throws RemoteException;

        protected final void zza(zzow com_google_android_gms_internal_zzow) throws RemoteException {
            zza(com_google_android_gms_internal_zzow.getContext(), (zzou) com_google_android_gms_internal_zzow.zznM());
        }
    }

    private static abstract class zza extends zzc<PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzaN(x0);
        }

        protected PanoramaResult zzaN(Status status) {
            return new zzox(status, null);
        }
    }

    private static final class zzb extends com.google.android.gms.internal.zzot.zza {
        private final com.google.android.gms.common.api.zza.zzb<PanoramaResult> zzOs;

        public zzb(com.google.android.gms.common.api.zza.zzb<PanoramaResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzOs.zzm(new zzox(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void zza(final Context context, zzou com_google_android_gms_internal_zzou, final zzot com_google_android_gms_internal_zzot, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            com_google_android_gms_internal_zzou.zza(new com.google.android.gms.internal.zzot.zza() {
                public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    zzov.zza(context, uri);
                    com_google_android_gms_internal_zzot.zza(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzov zzaGy;

            protected void zza(Context context, zzou com_google_android_gms_internal_zzou) throws RemoteException {
                com_google_android_gms_internal_zzou.zza(new zzb(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzov zzaGy;

            protected void zza(Context context, zzou com_google_android_gms_internal_zzou) throws RemoteException {
                zzov.zza(context, com_google_android_gms_internal_zzou, new zzb(this), uri, null);
            }
        });
    }
}
