package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzw;

public class DataEventBuffer extends zzf<DataEvent> implements Result {
    private final Status zzOt;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzOt = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzOt;
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzu(i, i2);
    }

    protected String zzni() {
        return "path";
    }

    protected DataEvent zzu(int i, int i2) {
        return new zzw(this.zzWu, i, i2);
    }
}
