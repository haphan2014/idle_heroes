package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.internal.purchase.zze;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzg;

@zzgd
public final class zzfl extends zzg<zzfh> {
    private static final zzfl zzBb = new zzfl();

    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzfl() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean zzc(Activity activity) throws zza {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static zzfg zze(Activity activity) {
        try {
            if (!zzc(activity)) {
                return zzBb.zzf(activity);
            }
            zzb.zzay("Using AdOverlay from the client jar.");
            return new zze(activity);
        } catch (zza e) {
            zzb.zzaC(e.getMessage());
            return null;
        }
    }

    private zzfg zzf(Activity activity) {
        try {
            return com.google.android.gms.internal.zzfg.zza.zzN(((zzfh) zzak(activity)).zzd(com.google.android.gms.dynamic.zze.zzw(activity)));
        } catch (Throwable e) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected zzfh zzR(IBinder iBinder) {
        return com.google.android.gms.internal.zzfh.zza.zzO(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzR(iBinder);
    }
}
