package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgd
public class zzhs<T> implements zzhv<T> {
    private T zzGK = null;
    private boolean zzGL = false;
    private final zzhw zzGM = new zzhw();
    private final Object zzqt = new Object();
    private boolean zzxo = false;

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!mayInterruptIfRunning) {
            return false;
        }
        synchronized (this.zzqt) {
            if (this.zzGL) {
                return false;
            }
            this.zzxo = true;
            this.zzGL = true;
            this.zzqt.notifyAll();
            this.zzGM.zzgy();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.zzqt) {
            if (!this.zzGL) {
                try {
                    this.zzqt.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzxo) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzGK;
        }
        return t;
    }

    public T get(long timeout, TimeUnit unit) throws TimeoutException {
        T t;
        synchronized (this.zzqt) {
            if (!this.zzGL) {
                try {
                    long toMillis = unit.toMillis(timeout);
                    if (toMillis != 0) {
                        this.zzqt.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzGL) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.zzxo) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.zzGK;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzxo;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzGL;
        }
        return z;
    }

    public void zzb(Runnable runnable) {
        this.zzGM.zzb(runnable);
    }

    public void zzf(T t) {
        synchronized (this.zzqt) {
            if (this.zzGL) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzGL = true;
            this.zzGK = t;
            this.zzqt.notifyAll();
            this.zzGM.zzgy();
        }
    }
}
