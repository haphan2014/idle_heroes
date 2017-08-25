package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzasG = new Object();
    private Handler zzasH;
    private boolean zzasI;
    private HashMap<String, AtomicInteger> zzasJ;
    private int zzasK;

    class C08101 implements Runnable {
        final /* synthetic */ EventIncrementCache zzasL;

        C08101(EventIncrementCache eventIncrementCache) {
            this.zzasL = eventIncrementCache;
        }

        public void run() {
            this.zzasL.zzth();
        }
    }

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzasH = new Handler(looper);
        this.zzasJ = new HashMap();
        this.zzasK = flushIntervalMillis;
    }

    private void zzth() {
        synchronized (this.zzasG) {
            this.zzasI = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzasG) {
            for (Entry entry : this.zzasJ.entrySet()) {
                zzs((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzasJ.clear();
        }
    }

    protected abstract void zzs(String str, int i);

    public void zzw(String str, int i) {
        synchronized (this.zzasG) {
            if (!this.zzasI) {
                this.zzasI = true;
                this.zzasH.postDelayed(new C08101(this), (long) this.zzasK);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzasJ.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzasJ.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
