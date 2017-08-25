package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzw extends zzc implements DataEvent {
    private final int zzaoG;

    public zzw(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaoG = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzBc();
    }

    public DataItem getDataItem() {
        return new zzac(this.zzWu, this.zzYs, this.zzaoG);
    }

    public int getType() {
        return getInteger("event_type");
    }

    public String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        return "DataEventRef{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    public DataEvent zzBc() {
        return new zzv(this);
    }
}
