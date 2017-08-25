package com.heyzap.common.concurrency;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HandlerExecutorService implements ExecutorService {
    private final Handler handler;

    public HandlerExecutorService(Handler handler) {
        this.handler = handler;
    }

    public <T> Future<T> submit(final Callable<T> task) {
        final SettableFuture<T> future = SettableFuture.create();
        this.handler.post(new Runnable() {
            public void run() {
                try {
                    future.set(task.call());
                } catch (Exception e) {
                    future.setException(e);
                }
            }
        });
        return future;
    }

    public <T> Future<T> submit(Runnable task, final T result) {
        final SettableFuture<T> future = SettableFuture.create();
        final WrappedRunnable wrappedTask = new WrappedRunnable(task, this);
        this.handler.post(new Runnable() {
            public void run() {
                wrappedTask.run();
                future.set(result);
            }
        });
        return future;
    }

    public Future<?> submit(Runnable task) {
        return submit(task, Boolean.valueOf(true));
    }

    public void execute(Runnable command) {
        submit(command);
    }

    public void shutdown() {
    }

    public List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        throw new RuntimeException("not implemented");
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long timeout, TimeUnit unit) throws InterruptedException {
        throw new RuntimeException("not implemented");
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        throw new RuntimeException("not implemented");
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new RuntimeException("not implemented");
    }
}
