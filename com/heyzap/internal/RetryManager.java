package com.heyzap.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryManager {
    private boolean cancelled = false;
    private final ScheduledExecutorService executorService;
    private Object retryLock = new Object();
    private final Schedule retrySchedule;
    private ScheduledFuture scheduleFuture;
    private final Runnable task;

    public interface Schedule {
        long getIntervalMillis();

        void incRetries();

        boolean isCanceled();
    }

    public static class DelayedSchedule implements Schedule {
        public final Schedule delegate;
        public final long initialDelay;
        private AtomicInteger retryCount = new AtomicInteger(0);

        public DelayedSchedule(int initialDelay, TimeUnit timeUnit, Schedule delegate) {
            this.delegate = delegate;
            this.initialDelay = timeUnit.toMillis((long) initialDelay);
        }

        public void incRetries() {
            this.retryCount.incrementAndGet();
            this.delegate.incRetries();
        }

        public long getIntervalMillis() {
            if (this.retryCount.get() > 0) {
                return this.delegate.getIntervalMillis();
            }
            return this.initialDelay;
        }

        public boolean isCanceled() {
            return false;
        }
    }

    public static class ExponentialSchedule implements Schedule {
        private final double exponentBase;
        private final long firstInterval;
        private AtomicInteger retryCount = new AtomicInteger(0);

        public ExponentialSchedule(double exponentBase, long firstInterval, TimeUnit timeUnit) {
            this.firstInterval = timeUnit.toMillis(firstInterval);
            this.exponentBase = exponentBase;
        }

        public void incRetries() {
            this.retryCount.incrementAndGet();
        }

        public long getIntervalMillis() {
            if (this.retryCount.get() == 0) {
                return 0;
            }
            return (long) (((double) this.firstInterval) * Math.pow(this.exponentBase, (double) this.retryCount.get()));
        }

        public boolean isCanceled() {
            return false;
        }
    }

    public static abstract class RetryableTask implements Runnable {
        private RetryManager retryManager;

        public boolean retry() {
            if (this.retryManager.isCanceled()) {
                return false;
            }
            this.retryManager.retry();
            return true;
        }

        public void setRetryManager(RetryManager retryManager) {
            this.retryManager = retryManager;
        }
    }

    public static class StaticSchedule implements Schedule {
        private long delay;
        private int times = 0;
        private int timesLimit;

        public StaticSchedule(int delay, TimeUnit timeUnit, int times) {
            this.delay = timeUnit.toMillis((long) delay);
            this.timesLimit = times;
        }

        public void incRetries() {
            this.times++;
        }

        public long getIntervalMillis() {
            if (this.times == 0) {
                return 0;
            }
            return this.delay;
        }

        public boolean isCanceled() {
            return this.times > this.timesLimit;
        }
    }

    public RetryManager(Runnable task, Schedule exponentialSchedule, ScheduledExecutorService executorService) {
        if (task instanceof RetryableTask) {
            ((RetryableTask) task).setRetryManager(this);
        }
        this.task = task;
        this.executorService = executorService;
        this.retrySchedule = exponentialSchedule;
    }

    public void start() {
        if (this.retrySchedule.isCanceled()) {
            cancel();
        } else {
            this.executorService.schedule(this.task, this.retrySchedule.getIntervalMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public boolean isCanceled() {
        return this.cancelled;
    }

    public void retry() {
        if (!this.cancelled) {
            synchronized (this.retryLock) {
                if (this.retrySchedule.isCanceled()) {
                    cancel();
                    return;
                }
                this.scheduleFuture = this.executorService.schedule(this.task, this.retrySchedule.getIntervalMillis(), TimeUnit.MILLISECONDS);
                this.retrySchedule.incRetries();
            }
        }
    }

    public void cancel() {
        this.cancelled = true;
        ScheduledFuture localFuture = this.scheduleFuture;
        if (localFuture != null) {
            localFuture.cancel(false);
        }
    }
}
