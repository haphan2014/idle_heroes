package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza<T> implements MetadataField<T> {
    private final Set<String> zzagA;
    private final int zzagB;
    private final String zzagy;
    private final Set<String> zzagz;

    protected zza(String str, int i) {
        this.zzagy = (String) zzu.zzb((Object) str, (Object) "fieldName");
        this.zzagz = Collections.singleton(str);
        this.zzagA = Collections.emptySet();
        this.zzagB = i;
    }

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.zzagy = (String) zzu.zzb((Object) str, (Object) "fieldName");
        this.zzagz = Collections.unmodifiableSet(new HashSet(collection));
        this.zzagA = Collections.unmodifiableSet(new HashSet(collection2));
        this.zzagB = i;
    }

    public final String getName() {
        return this.zzagy;
    }

    public String toString() {
        return this.zzagy;
    }

    public final T zza(DataHolder dataHolder, int i, int i2) {
        return zzb(dataHolder, i, i2) ? zzc(dataHolder, i, i2) : null;
    }

    protected abstract void zza(Bundle bundle, T t);

    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        zzu.zzb((Object) dataHolder, (Object) "dataHolder");
        zzu.zzb((Object) metadataBundle, (Object) "bundle");
        if (zzb(dataHolder, i, i2)) {
            metadataBundle.zzb(this, zzc(dataHolder, i, i2));
        }
    }

    public final void zza(T t, Bundle bundle) {
        zzu.zzb((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            zza(bundle, (Object) t);
        }
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String str : this.zzagz) {
            if (dataHolder.zzbV(str)) {
                if (dataHolder.zzi(str, i, i2)) {
                }
            }
            return false;
        }
        return true;
    }

    protected abstract T zzc(DataHolder dataHolder, int i, int i2);

    public final T zzi(Bundle bundle) {
        zzu.zzb((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? zzj(bundle) : null;
    }

    protected abstract T zzj(Bundle bundle);
}
