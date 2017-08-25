package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public abstract class zzj<T extends Parcelable> extends zza<T> {
    public zzj(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void zza(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    protected /* synthetic */ Object zzj(Bundle bundle) {
        return zzp(bundle);
    }

    protected T zzp(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
