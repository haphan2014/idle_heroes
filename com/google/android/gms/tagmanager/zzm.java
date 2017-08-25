package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzm<K, V> {
    final zza<K, V> zzaKw = new C11651(this);

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    class C11651 implements zza<K, V> {
        final /* synthetic */ zzm zzaKx;

        C11651(zzm com_google_android_gms_tagmanager_zzm) {
            this.zzaKx = com_google_android_gms_tagmanager_zzm;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public zzl<K, V> zza(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        if (i > 0) {
            return zzyj() < 12 ? new zzcw(i, com_google_android_gms_tagmanager_zzm_zza_K__V) : new zzba(i, com_google_android_gms_tagmanager_zzm_zza_K__V);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int zzyj() {
        return VERSION.SDK_INT;
    }
}
