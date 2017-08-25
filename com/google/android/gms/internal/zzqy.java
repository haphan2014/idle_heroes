package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzqt.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzqy extends zzg<zzqt> {
    private static zzqy zzaSv;

    protected zzqy() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzqy zzAM() {
        if (zzaSv == null) {
            zzaSv = new zzqy();
        }
        return zzaSv;
    }

    public static zzqq zza(Activity activity, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzqr com_google_android_gms_internal_zzqr) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzqt) zzAM().zzak(activity)).zza(zze.zzw(activity), com_google_android_gms_dynamic_zzc, walletFragmentOptions, com_google_android_gms_internal_zzqr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzdM(iBinder);
    }

    protected zzqt zzdM(IBinder iBinder) {
        return zza.zzdI(iBinder);
    }
}
