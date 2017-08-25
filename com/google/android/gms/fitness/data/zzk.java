package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzk extends com.google.android.gms.fitness.data.zzj.zza {
    private final OnDataPointListener zzakC;

    public static class zza {
        private static final zza zzakD = new zza();
        private final Map<OnDataPointListener, zzk> zzakE = new HashMap();

        private zza() {
        }

        public static zza zzqH() {
            return zzakD;
        }

        public zzk zza(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzakE) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzakE.get(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzk == null) {
                    com_google_android_gms_fitness_data_zzk = new zzk(onDataPointListener);
                    this.zzakE.put(onDataPointListener, com_google_android_gms_fitness_data_zzk);
                }
            }
            return com_google_android_gms_fitness_data_zzk;
        }

        public zzk zzb(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzakE) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzakE.get(onDataPointListener);
            }
            return com_google_android_gms_fitness_data_zzk;
        }

        public zzk zzc(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzakE) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzakE.remove(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzk != null) {
                } else {
                    com_google_android_gms_fitness_data_zzk = new zzk(onDataPointListener);
                }
            }
            return com_google_android_gms_fitness_data_zzk;
        }
    }

    private zzk(OnDataPointListener onDataPointListener) {
        this.zzakC = (OnDataPointListener) zzu.zzu(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzakC.onDataPoint(dataPoint);
    }
}
