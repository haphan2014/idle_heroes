package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzcm.zza;

public class zzcy extends zzg<zzcn> {
    public zzcy() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private zzcm zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return zza.zzu(((zzcn) zzak(context)).zza(zze.zzw(context), zze.zzw(frameLayout), zze.zzw(frameLayout2), 7571000));
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected zzcn zzD(IBinder iBinder) {
        return zzcn.zza.zzv(iBinder);
    }

    public zzcm zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        if (zzk.zzcA().zzP(context)) {
            zzcm zzb = zzb(context, frameLayout, frameLayout2);
            if (zzb != null) {
                return zzb;
            }
        }
        zzb.zzay("Using NativeAdViewDelegate from the client jar.");
        return new zzi(frameLayout, frameLayout2);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzD(iBinder);
    }
}
