package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzgd
public final class zzhk {
    private static final ExecutorService zzGe = Executors.newFixedThreadPool(10, zzas("Default"));
    private static final ExecutorService zzGf = Executors.newFixedThreadPool(5, zzas("Loader"));

    public static zzhv<Void> zza(int i, final Runnable runnable) {
        return i == 1 ? zza(zzGf, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzgk();
            }

            public Void zzgk() {
                runnable.run();
                return null;
            }
        }) : zza(zzGe, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzgk();
            }

            public Void zzgk() {
                runnable.run();
                return null;
            }
        });
    }

    public static zzhv<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzhv<T> zza(Callable<T> callable) {
        return zza(zzGe, (Callable) callable);
    }

    public static <T> zzhv<T> zza(ExecutorService executorService, final Callable<T> callable) {
        final Object com_google_android_gms_internal_zzhs = new zzhs();
        try {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        com_google_android_gms_internal_zzhs.zzf(callable.call());
                    } catch (Throwable e) {
                        zzo.zzby().zzc(e, true);
                        com_google_android_gms_internal_zzhs.cancel(true);
                    }
                }
            });
        } catch (Throwable e) {
            zzb.zzd("Thread execution is rejected.", e);
            com_google_android_gms_internal_zzhs.cancel(true);
        }
        return com_google_android_gms_internal_zzhs;
    }

    private static ThreadFactory zzas(final String str) {
        return new ThreadFactory() {
            private final AtomicInteger zzGi = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AdWorker(" + str + ") #" + this.zzGi.getAndIncrement());
            }
        };
    }
}
