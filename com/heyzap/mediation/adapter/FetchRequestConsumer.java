package com.heyzap.mediation.adapter;

import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.mediation.FetchRequestStore;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FetchRequestConsumer {
    private final ConcurrentHashMap<AdUnit, AtomicInteger> consumptionCounts = new ConcurrentHashMap();
    private final Object consumptionLock = new Object();
    private final FetchRequestStore store;

    private class ConsumeCallback implements Runnable {
        private final Collection<AdUnit> adUnits;
        private final Runnable callback;
        private final AtomicBoolean ranOnce = new AtomicBoolean(false);

        public ConsumeCallback(Runnable callback, Collection<AdUnit> adUnits) {
            this.callback = callback;
            this.adUnits = adUnits;
        }

        public void run() {
            for (AdUnit adUnit : this.adUnits) {
                if (FetchRequestConsumer.this.consume(adUnit)) {
                    FetchRequestConsumer.this.store.removeUpdateCallback(this);
                    if (this.ranOnce.compareAndSet(false, true)) {
                        this.callback.run();
                        return;
                    } else {
                        FetchRequestConsumer.this.unConsume(adUnit);
                        return;
                    }
                }
            }
        }
    }

    public FetchRequestConsumer(FetchRequestStore store) {
        this.store = store;
    }

    public boolean consume(AdUnit adUnit) {
        boolean z = false;
        this.consumptionCounts.putIfAbsent(adUnit, new AtomicInteger(0));
        AtomicInteger unitConsumption = (AtomicInteger) this.consumptionCounts.get(adUnit);
        AtomicInteger unitFetches = (AtomicInteger) this.store.getCounts().get(adUnit);
        if (unitFetches != null) {
            synchronized (this.consumptionLock) {
                if (unitFetches.get() > unitConsumption.get() || unitFetches.get() >= 1000) {
                    unitConsumption.incrementAndGet();
                    z = true;
                }
            }
        }
        return z;
    }

    private void unConsume(AdUnit adUnit) {
        this.consumptionCounts.putIfAbsent(adUnit, new AtomicInteger(0));
        ((AtomicInteger) this.consumptionCounts.get(adUnit)).decrementAndGet();
    }

    public void consumeAny(Collection<AdUnit> adUnits, Runnable runnable, ExecutorService executorService) {
        ConsumeCallback callback = new ConsumeCallback(runnable, adUnits);
        this.store.addUpdateCallback(callback, executorService);
        executorService.submit(callback);
    }

    public void consumeNext(Collection<AdUnit> adUnits, Runnable runnable, ExecutorService executorService) {
        this.store.addUpdateCallback(new ConsumeCallback(runnable, adUnits), executorService);
    }
}
