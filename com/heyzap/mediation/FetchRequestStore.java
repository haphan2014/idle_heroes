package com.heyzap.mediation;

import com.heyzap.internal.Constants.AdUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class FetchRequestStore {
    public static final int UNLIMITED_THRESHOLD = 1000;
    private final ConcurrentHashMap<AdUnit, AtomicInteger> requestCounts = new ConcurrentHashMap();
    private final List<UpdateCallback> updateCallbacks = new CopyOnWriteArrayList();

    private static class FetchRequest {
        public final AdUnit adUnit;
        public final long createdAt = System.currentTimeMillis();
        public final boolean unlimited;

        public FetchRequest(AdUnit adUnit, boolean unlimited) {
            this.adUnit = adUnit;
            this.unlimited = unlimited;
        }
    }

    private static class UpdateCallback {
        private final ExecutorService executorService;
        private final Runnable runnable;

        private UpdateCallback(Runnable runnable, ExecutorService executorService) {
            this.runnable = runnable;
            this.executorService = executorService;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            if (this.runnable.equals(((UpdateCallback) o).runnable)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.runnable.hashCode();
        }
    }

    public void add(AdUnit adUnit) {
        add(new FetchRequest(adUnit, false));
    }

    public void makeUnlimited(AdUnit adUnit) {
        add(new FetchRequest(adUnit, true));
    }

    public void add(FetchRequest fetchRequest) {
        this.requestCounts.putIfAbsent(fetchRequest.adUnit, new AtomicInteger(0));
        if (fetchRequest.unlimited) {
            ((AtomicInteger) this.requestCounts.get(fetchRequest.adUnit)).set(1000);
        } else {
            ((AtomicInteger) this.requestCounts.get(fetchRequest.adUnit)).addAndGet(1);
        }
        runUpdateCallbacks();
    }

    public int getCount(AdUnit adUnit) {
        AtomicInteger aint = (AtomicInteger) this.requestCounts.get(adUnit);
        if (aint == null) {
            return 0;
        }
        return aint.get();
    }

    public Map<AdUnit, AtomicInteger> getCounts() {
        return this.requestCounts;
    }

    public void addUpdateCallback(Runnable runnable, ExecutorService executorService) {
        this.updateCallbacks.add(new UpdateCallback(runnable, executorService));
    }

    public void removeUpdateCallback(Runnable runnable) {
        this.updateCallbacks.remove(new UpdateCallback(runnable, null));
    }

    private void runUpdateCallbacks() {
        for (UpdateCallback callback : this.updateCallbacks) {
            callback.executorService.submit(callback.runnable);
        }
    }
}
