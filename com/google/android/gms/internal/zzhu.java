package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class zzhu {

    public interface zza<D, R> {
        R zze(D d);
    }

    public static <A, B> zzhv<B> zza(final zzhv<A> com_google_android_gms_internal_zzhv_A, final zza<A, B> com_google_android_gms_internal_zzhu_zza_A__B) {
        final zzhv com_google_android_gms_internal_zzhs = new zzhs();
        com_google_android_gms_internal_zzhv_A.zzb(new Runnable() {
            public void run() {
                try {
                    com_google_android_gms_internal_zzhs.zzf(com_google_android_gms_internal_zzhu_zza_A__B.zze(com_google_android_gms_internal_zzhv_A.get()));
                    return;
                } catch (CancellationException e) {
                } catch (InterruptedException e2) {
                } catch (ExecutionException e3) {
                }
                com_google_android_gms_internal_zzhs.cancel(true);
            }
        });
        return com_google_android_gms_internal_zzhs;
    }
}
