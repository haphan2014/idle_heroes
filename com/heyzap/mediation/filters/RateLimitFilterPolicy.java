package com.heyzap.mediation.filters;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.internal.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class RateLimitFilterPolicy implements FilterPolicy {
    private final ExecutorService executorService;
    private final long period;
    private final int permits;
    private final Store<String> persistence;
    private final List<Long> useHistory = new ArrayList();

    public RateLimitFilterPolicy(ExecutorService executorService, int permits, int period, TimeUnit timeUnit, Store<String> persistence) {
        this.permits = permits;
        this.period = timeUnit.toMillis((long) period);
        this.persistence = persistence;
        this.executorService = executorService;
        boot();
    }

    public boolean accept() {
        return accept(System.currentTimeMillis());
    }

    public boolean accept(long now) {
        boolean accepted = false;
        synchronized (this.useHistory) {
            prune(now);
            if (this.useHistory.size() < this.permits) {
                accepted = true;
            }
        }
        return accepted;
    }

    public void addDisplay(final AdDisplay adDisplay) {
        adDisplay.displayEventStream.getFirstEventFuture().addListener(new Runnable() {
            public void run() {
                if (((DisplayResult) FutureUtils.getImmediatelyOrDefault(adDisplay.displayEventStream.getFirstEventFuture(), new DisplayResult("failed"))).success) {
                    RateLimitFilterPolicy.this.addDisplay(System.currentTimeMillis());
                }
            }
        }, this.executorService);
    }

    public void addDisplay(long now) {
        this.useHistory.add(Long.valueOf(now));
        persist();
    }

    private void prune(long now) {
        long threshold = now - this.period;
        synchronized (this.useHistory) {
            Iterator<Long> it = this.useHistory.iterator();
            while (it.hasNext()) {
                if (((Long) it.next()).longValue() < threshold) {
                    it.remove();
                }
            }
        }
    }

    private void boot() {
        for (String part : ((String) this.persistence.get()).split(",")) {
            if (part.length() >= 1) {
                try {
                    this.useHistory.add(Long.valueOf(part));
                } catch (NumberFormatException e) {
                    Logger.log("Non-number found in rate-limiter persistence: ", this.persistence, part);
                }
            }
        }
    }

    private void persist() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.useHistory.size(); i++) {
            builder.append(this.useHistory.get(i));
            if (i + 1 < this.useHistory.size()) {
                builder.append(",");
            }
        }
        this.persistence.set(builder.toString());
    }
}
