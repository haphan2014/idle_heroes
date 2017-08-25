package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzn.zza {
    private final BleScanCallback zzalI;

    public static class zza {
        private static final zza zzalJ = new zza();
        private final Map<BleScanCallback, zza> zzalK = new HashMap();

        private zza() {
        }

        public static zza zzqS() {
            return zzalJ;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzalK) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzalK.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza == null) {
                    com_google_android_gms_fitness_request_zza = new zza(bleScanCallback);
                    this.zzalK.put(bleScanCallback, com_google_android_gms_fitness_request_zza);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzalK) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzalK.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza != null) {
                } else {
                    com_google_android_gms_fitness_request_zza = new zza(bleScanCallback);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzalI = (BleScanCallback) zzu.zzu(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzalI.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.zzalI.onScanStopped();
    }
}
