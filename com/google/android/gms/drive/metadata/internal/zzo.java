package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzo extends zza<String> {
    public zzo(String str, int i) {
        super(str, i);
    }

    protected void zza(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzi(dataHolder, i, i2);
    }

    protected String zzi(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzd(getName(), i, i2);
    }

    protected /* synthetic */ Object zzj(Bundle bundle) {
        return zzq(bundle);
    }

    protected String zzq(Bundle bundle) {
        return bundle.getString(getName());
    }
}
