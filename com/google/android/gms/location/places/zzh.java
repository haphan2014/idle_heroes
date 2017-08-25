package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzq;

public class zzh extends AbstractDataBuffer<zzg> {
    public zzh(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int x0) {
        return zzgP(x0);
    }

    public zzg zzgP(int i) {
        return new zzq(this.zzWu, i);
    }
}
