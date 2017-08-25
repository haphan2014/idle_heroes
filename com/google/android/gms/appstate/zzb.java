package com.google.android.gms.appstate;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class zzb extends zzc implements AppState {
    zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return zza.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzkT();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !zzbX("conflict_version");
    }

    public int hashCode() {
        return zza.zza(this);
    }

    public String toString() {
        return zza.zzb(this);
    }

    public AppState zzkT() {
        return new zza(this);
    }
}
