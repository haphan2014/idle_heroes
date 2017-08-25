package com.heyzap.common.concurrency;

import com.heyzap.internal.Logger;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorPool {
    private static volatile ExecutorPool ref;
    ScheduledThreadPoolExecutor pool = new WrappedScheduledThreadPoolExecutor(10);

    class ExecutorThreadFactory implements ThreadFactory {
        ExecutorThreadFactory() {
        }

        public Thread newThread(Runnable r) {
            return new Thread(r, "HeyzapThreadPool");
        }
    }

    private static class WrappedScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
        public WrappedScheduledThreadPoolExecutor(int corePoolSize) {
            super(corePoolSize);
        }

        public Future<?> submit(Runnable r) {
            try {
                return super.submit(new WrappedRunnable(r, this));
            } catch (RejectedExecutionException e) {
                Logger.error("Runnable rejected because executor is shut down");
                return SettableFuture.create();
            }
        }

        public void execute(Runnable r) {
            try {
                super.execute(new WrappedRunnable(r, this));
            } catch (RejectedExecutionException e) {
                Logger.error("Runnable rejected because executor is shut down");
            }
        }
    }

    private ExecutorPool() {
        this.pool.setKeepAliveTime(10, TimeUnit.SECONDS);
        this.pool.allowCoreThreadTimeOut(true);
        this.pool.setThreadFactory(new ExecutorThreadFactory());
    }

    public static synchronized ScheduledThreadPoolExecutor getInstance() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (ExecutorPool.class) {
            if (ref == null) {
                ref = new ExecutorPool();
            }
            scheduledThreadPoolExecutor = ref.pool;
        }
        return scheduledThreadPoolExecutor;
    }

    public Object clone() {
        return null;
    }
}
