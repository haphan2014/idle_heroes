package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzgd
public class zzht<T> implements zzhv<T> {
    private final T zzGK;
    private final zzhw zzGM = new zzhw();

    public zzht(T t) {
        this.zzGK = t;
        this.zzGM.zzgy();
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public T get() {
        return this.zzGK;
    }

    public T get(long timeout, TimeUnit unit) {
        return this.zzGK;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public void zzb(Runnable runnable) {
        this.zzGM.zzb(runnable);
    }
}
