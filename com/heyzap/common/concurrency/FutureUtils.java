package com.heyzap.common.concurrency;

import com.heyzap.internal.Logger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureUtils {

    public static abstract class FutureRunnable<V> implements Runnable {
        public final ListenableFuture<V> future;

        public abstract void run(V v, Exception exception);

        protected FutureRunnable(ListenableFuture<V> future) {
            this.future = future;
        }

        public void run() {
            try {
                try {
                    run(this.future.get(), null);
                } catch (Exception e) {
                    Logger.log("found error, passing on");
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException e2) {
                run(null, e2);
            } catch (ExecutionException e3) {
                run(null, e3);
            }
        }
    }

    public static <V> ListenableFuture<V> anyOf(final List<ListenableFuture<V>> futures, ExecutorService executorService) {
        final SettableFuture<V> resultFuture = SettableFuture.create();
        final AtomicInteger errorsSeen = new AtomicInteger(0);
        for (ListenableFuture<V> future : futures) {
            future.addListener(new FutureRunnable<V>(future) {
                public void run(V result, Exception exception) {
                    if (exception == null) {
                        resultFuture.set(result);
                    } else if (futures.size() <= errorsSeen.addAndGet(1)) {
                        resultFuture.setException(new RuntimeException("All futures failed"));
                    }
                }
            }, executorService);
        }
        return resultFuture;
    }

    public static <T> T getImmediatelyOrDefault(SettableFuture<? extends T> future, T defaultValue) {
        if (future.isDone()) {
            try {
                defaultValue = future.get();
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    public static SettableFuture<Boolean> allOf(final List<? extends ListenableFuture> futures, ExecutorService executorService) {
        final SettableFuture<Boolean> resultFuture = SettableFuture.create();
        final AtomicInteger seen = new AtomicInteger(0);
        for (ListenableFuture future : futures) {
            future.addListener(new Runnable() {
                public void run() {
                    if (futures.size() <= seen.addAndGet(1)) {
                        resultFuture.set(Boolean.valueOf(true));
                    }
                }
            }, executorService);
        }
        if (futures.size() == 0) {
            resultFuture.set(Boolean.valueOf(true));
        }
        return resultFuture;
    }

    public static <V> SettableFuture<V> wrapTimeout(ListenableFuture<V> future, ScheduledExecutorService executorService, long delay, TimeUnit timeUnit) {
        return addTimeout(wrap(future, executorService), executorService, delay, timeUnit);
    }

    public static <V> SettableFuture<V> addTimeout(final SettableFuture<V> future, ScheduledExecutorService executorService, long delay, TimeUnit timeUnit) {
        executorService.schedule(new Runnable() {
            public void run() {
                future.setException(new TimeoutException());
            }
        }, delay, timeUnit);
        return future;
    }

    public static <V> SettableFuture<V> wrap(ListenableFuture<V> future, ExecutorService executorService) {
        final SettableFuture<V> resultFuture = SettableFuture.create();
        future.addListener(new FutureRunnable<V>(future) {
            public void run(V result, Exception exception) {
                if (exception == null) {
                    resultFuture.set(result);
                } else {
                    resultFuture.setException(exception);
                }
            }
        }, executorService);
        return resultFuture;
    }

    public static <V> void bind(final SettableFuture<? extends V> sourceFuture, final SettableFuture<V> destFuture, ExecutorService executorService) {
        sourceFuture.addListener(new Runnable() {
            public void run() {
                try {
                    destFuture.set(sourceFuture.get());
                } catch (Exception e) {
                    destFuture.setException(e);
                }
            }
        }, executorService);
    }
}
