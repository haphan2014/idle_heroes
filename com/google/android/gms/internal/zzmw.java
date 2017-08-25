package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class zzmw<T extends Result> implements PendingResult<T> {
    private final T zzakV;

    zzmw(T t) {
        this.zzakV = t;
    }

    public void addBatchCallback(BatchCallback callback) {
        callback.zzs(this.zzakV.getStatus());
    }

    public T await() {
        return this.zzakV;
    }

    public T await(long time, TimeUnit units) {
        return this.zzakV;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResultCallback(ResultCallback<T> callback) {
        callback.onResult(this.zzakV);
    }

    public void setResultCallback(ResultCallback<T> callback, long time, TimeUnit units) {
        callback.onResult(this.zzakV);
    }
}
