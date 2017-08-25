package com.heyzap.mediation.filters;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.lifecycle.AdDisplay;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class IncentivizedRateLimitFilterPolicy extends RateLimitFilterPolicy {
    final ExecutorService executorService;

    public IncentivizedRateLimitFilterPolicy(ExecutorService executorService, int permits, int period, TimeUnit timeUnit, Store<String> persistence) {
        super(executorService, permits, period, timeUnit, persistence);
        this.executorService = executorService;
    }

    public void addDisplay(final AdDisplay adDisplay) {
        adDisplay.incentiveListener.addListener(new Runnable() {
            public void run() {
                if (((Boolean) FutureUtils.getImmediatelyOrDefault(adDisplay.incentiveListener, Boolean.valueOf(false))).booleanValue()) {
                    IncentivizedRateLimitFilterPolicy.this.addDisplay(System.currentTimeMillis());
                }
            }
        }, this.executorService);
    }
}
