package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzj;
import java.util.List;

class zzb implements SensorEventDispatcher {
    private final zzj zzamr;

    zzb(zzj com_google_android_gms_fitness_data_zzj) {
        this.zzamr = (zzj) zzu.zzu(com_google_android_gms_fitness_data_zzj);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        dataPoint.zzqx();
        this.zzamr.zzc(dataPoint);
    }

    public void publish(List<DataPoint> dataPoints) throws RemoteException {
        for (DataPoint publish : dataPoints) {
            publish(publish);
        }
    }
}
