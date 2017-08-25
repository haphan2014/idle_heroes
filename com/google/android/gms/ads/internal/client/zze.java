package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzr.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zze extends zzg<zzs> {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzr zza(Context context, AdSizeParcel adSizeParcel, String str, zzee com_google_android_gms_internal_zzee, int i) {
        Throwable e;
        try {
            return zza.zzk(((zzs) zzak(context)).zza(com.google.android.gms.dynamic.zze.zzw(context), adSizeParcel, str, com_google_android_gms_internal_zzee, 7571000, i));
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Could not create remote AdManager.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzb.zzd("Could not create remote AdManager.", e);
            return null;
        }
    }

    public zzr zza(Context context, AdSizeParcel adSizeParcel, String str, zzee com_google_android_gms_internal_zzee) {
        if (zzk.zzcA().zzP(context)) {
            zzr zza = zza(context, adSizeParcel, str, com_google_android_gms_internal_zzee, 1);
            if (zza != null) {
                return zza;
            }
        }
        zzb.zzay("Using BannerAdManager from the client jar.");
        return new com.google.android.gms.ads.internal.zze(context, adSizeParcel, str, com_google_android_gms_internal_zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    public zzr zzb(Context context, AdSizeParcel adSizeParcel, String str, zzee com_google_android_gms_internal_zzee) {
        if (zzk.zzcA().zzP(context)) {
            zzr zza = zza(context, adSizeParcel, str, com_google_android_gms_internal_zzee, 2);
            if (zza != null) {
                return zza;
            }
        }
        zzb.zzaC("Using InterstitialAdManager from the client jar.");
        return new zzj(context, adSizeParcel, str, com_google_android_gms_internal_zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zze(iBinder);
    }

    protected zzs zze(IBinder iBinder) {
        return zzs.zza.zzl(iBinder);
    }
}
