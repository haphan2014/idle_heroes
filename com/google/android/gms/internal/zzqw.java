package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzqw implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        final String str = googleTransactionId;
        final String str2 = merchantTransactionId;
        final int i = requestCode;
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzqw zzaSo;

            protected void zza(zzqx com_google_android_gms_internal_zzqx) {
                com_google_android_gms_internal_zzqx.zze(str, str2, i);
                setResult(Status.zzXP);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzqw zzaSo;

            protected void zza(zzqx com_google_android_gms_internal_zzqx) {
                com_google_android_gms_internal_zzqx.zzjB(requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzqw zzaSo;

            protected void zza(zzqx com_google_android_gms_internal_zzqx) {
                com_google_android_gms_internal_zzqx.zzjC(requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzqw zzaSo;

            protected void zza(zzqx com_google_android_gms_internal_zzqx) {
                com_google_android_gms_internal_zzqx.zza(request, requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzqw zzaSo;

            protected void zza(zzqx com_google_android_gms_internal_zzqx) {
                com_google_android_gms_internal_zzqx.zza(request, requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzqw zzaSo;

            protected void zza(zzqx com_google_android_gms_internal_zzqx) {
                com_google_android_gms_internal_zzqx.zza(request);
                setResult(Status.zzXP);
            }
        });
    }
}
