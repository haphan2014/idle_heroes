package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzau<T> {
    private final Map<T, zzbl<T>> zzakE = new HashMap();

    private static class zza<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbl<T>>> zzaUA;
        private WeakReference<T> zzaUB;

        zza(Map<T, zzbl<T>> map, T t, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzaUA = new WeakReference(map);
            this.zzaUB = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzaUA.get();
            Object obj = this.zzaUB.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzbl com_google_android_gms_wearable_internal_zzbl = (zzbl) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbl != null) {
                        com_google_android_gms_wearable_internal_zzbl.clear();
                    }
                }
            }
            zzP(status);
        }
    }

    private static class zzb<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbl<T>>> zzaUA;
        private WeakReference<T> zzaUB;

        zzb(Map<T, zzbl<T>> map, T t, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzaUA = new WeakReference(map);
            this.zzaUB = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzaUA.get();
            Object obj = this.zzaUB.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    zzbl com_google_android_gms_wearable_internal_zzbl = (zzbl) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbl != null) {
                        com_google_android_gms_wearable_internal_zzbl.clear();
                    }
                }
            }
            zzP(status);
        }
    }

    zzau() {
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.zzakE) {
            isEmpty = this.zzakE.isEmpty();
        }
        return isEmpty;
    }

    public void zza(zzbk com_google_android_gms_wearable_internal_zzbk, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, T t) throws RemoteException {
        synchronized (this.zzakE) {
            zzbl com_google_android_gms_wearable_internal_zzbl = (zzbl) this.zzakE.remove(t);
            if (com_google_android_gms_wearable_internal_zzbl == null) {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzm(new Status(4002));
                return;
            }
            com_google_android_gms_wearable_internal_zzbl.clear();
            ((zzat) com_google_android_gms_wearable_internal_zzbk.zznM()).zza(new zzb(this.zzakE, t, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), new RemoveListenerRequest(com_google_android_gms_wearable_internal_zzbl));
        }
    }

    public void zza(zzbk com_google_android_gms_wearable_internal_zzbk, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, T t, zzbl<T> com_google_android_gms_wearable_internal_zzbl_T) throws RemoteException {
        synchronized (this.zzakE) {
            if (this.zzakE.get(t) != null) {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzm(new Status(4001));
                return;
            }
            this.zzakE.put(t, com_google_android_gms_wearable_internal_zzbl_T);
            try {
                ((zzat) com_google_android_gms_wearable_internal_zzbk.zznM()).zza(new zza(this.zzakE, t, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), new AddListenerRequest(com_google_android_gms_wearable_internal_zzbl_T));
            } catch (RemoteException e) {
                this.zzakE.remove(t);
                throw e;
            }
        }
    }

    public void zzb(zzbk com_google_android_gms_wearable_internal_zzbk) {
        synchronized (this.zzakE) {
            zzar com_google_android_gms_wearable_internal_zzbj_zzo = new zzo();
            for (Entry entry : this.zzakE.entrySet()) {
                zzbl com_google_android_gms_wearable_internal_zzbl = (zzbl) entry.getValue();
                if (com_google_android_gms_wearable_internal_zzbl != null) {
                    com_google_android_gms_wearable_internal_zzbl.clear();
                    if (com_google_android_gms_wearable_internal_zzbk.isConnected()) {
                        try {
                            ((zzat) com_google_android_gms_wearable_internal_zzbk.zznM()).zza(com_google_android_gms_wearable_internal_zzbj_zzo, new RemoveListenerRequest(com_google_android_gms_wearable_internal_zzbl));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbl);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbl);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.zzakE.clear();
        }
    }

    public void zzdR(IBinder iBinder) {
        synchronized (this.zzakE) {
            zzat zzdQ = com.google.android.gms.wearable.internal.zzat.zza.zzdQ(iBinder);
            zzar com_google_android_gms_wearable_internal_zzbj_zzo = new zzo();
            for (Entry entry : this.zzakE.entrySet()) {
                zzbl com_google_android_gms_wearable_internal_zzbl = (zzbl) entry.getValue();
                try {
                    zzdQ.zza(com_google_android_gms_wearable_internal_zzbj_zzo, new AddListenerRequest(com_google_android_gms_wearable_internal_zzbl));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbl);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbl);
                }
            }
        }
    }
}
