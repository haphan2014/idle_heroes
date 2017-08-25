package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zzp.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgd;

@zzgd
public final class zzd extends zzg<zzq> {
    private static final zzd zzrW = new zzd();

    private zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzp zza(Context context, String str, zzee com_google_android_gms_internal_zzee) {
        if (zzk.zzcA().zzP(context)) {
            zzp zzb = zzrW.zzb(context, str, com_google_android_gms_internal_zzee);
            if (zzb != null) {
                return zzb;
            }
        }
        zzb.zzay("Using AdLoader from the client jar.");
        return new zzi(context, str, com_google_android_gms_internal_zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    private zzp zzb(Context context, String str, zzee com_google_android_gms_internal_zzee) {
        try {
            return zza.zzi(((zzq) zzak(context)).zza(zze.zzw(context), str, com_google_android_gms_internal_zzee, 7571000));
        } catch (Throwable e) {
            zzb.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            zzb.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected zzq zzc(IBinder iBinder) {
        return zzq.zza.zzj(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzc(iBinder);
    }
}
