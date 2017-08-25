package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgn;

@zzgd
public class zzf extends zzg<zzc> {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    private zzb zzb(Context context, zzee com_google_android_gms_internal_zzee) {
        Throwable e;
        try {
            return zza.zzX(((zzc) zzak(context)).zza(zze.zzw(context), com_google_android_gms_internal_zzee, 7571000));
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    public zzb zza(Context context, zzee com_google_android_gms_internal_zzee) {
        if (zzk.zzcA().zzP(context)) {
            zzb zzb = zzb(context, com_google_android_gms_internal_zzee);
            if (zzb != null) {
                return zzb;
            }
        }
        zzb.zzay("Using RewardedVideoAd from the client jar.");
        return new zzgn(context, com_google_android_gms_internal_zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    protected zzc zzaa(IBinder iBinder) {
        return zzc.zza.zzY(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzaa(iBinder);
    }
}
