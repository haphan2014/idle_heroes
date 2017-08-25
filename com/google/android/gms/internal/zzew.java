package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

@zzgd
public final class zzew extends zzg<zzey> {
    private static final zzew zzAr = new zzew();

    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzew() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static zzex zzb(Activity activity) {
        try {
            if (!zzc(activity)) {
                return zzAr.zzd(activity);
            }
            zzb.zzay("Using AdOverlay from the client jar.");
            return new zzc(activity);
        } catch (zza e) {
            zzb.zzaC(e.getMessage());
            return null;
        }
    }

    private static boolean zzc(Activity activity) throws zza {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new zza("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private zzex zzd(Activity activity) {
        try {
            return com.google.android.gms.internal.zzex.zza.zzI(((zzey) zzak(activity)).zzc(zze.zzw(activity)));
        } catch (Throwable e) {
            zzb.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            zzb.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected zzey zzH(IBinder iBinder) {
        return com.google.android.gms.internal.zzey.zza.zzJ(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzH(iBinder);
    }
}
