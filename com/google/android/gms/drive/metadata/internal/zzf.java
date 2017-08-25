package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzf extends zza<Integer> {
    public zzf(String str, int i) {
        super(str, i);
    }

    protected void zza(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzg(dataHolder, i, i2);
    }

    protected Integer zzg(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.zzc(getName(), i, i2));
    }

    protected /* synthetic */ Object zzj(Bundle bundle) {
        return zzm(bundle);
    }

    protected Integer zzm(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
