package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzac;

public class DataItemBuffer extends zzf<DataItem> implements Result {
    private final Status zzOt;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzOt = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzOt;
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzv(i, i2);
    }

    protected String zzni() {
        return "path";
    }

    protected DataItem zzv(int i, int i2) {
        return new zzac(this.zzWu, i, i2);
    }
}
