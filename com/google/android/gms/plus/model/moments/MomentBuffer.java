package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.internal.model.moments.zzc;

public final class MomentBuffer extends AbstractDataBuffer<Moment> {
    public MomentBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Moment get(int position) {
        return new zzc(this.zzWu, position);
    }
}
