package com.heyzap.common.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public abstract class PausableRunnable implements Runnable {
    private final Executor executor;
    private final PauseSignal pauseSignal;
    private final Runnable unpausedRunnable = new C12861();

    class C12861 implements Runnable {
        C12861() {
        }

        public void run() {
            PausableRunnable.this.runWhenUnpaused();
        }
    }

    public static class PauseSignal {
        AtomicReference<SettableFuture> resumeFutureRef = new AtomicReference();

        public boolean resume() {
            SettableFuture resumeFuture = (SettableFuture) this.resumeFutureRef.getAndSet(null);
            if (resumeFuture != null) {
                return resumeFuture.set(null);
            }
            return false;
        }

        public boolean pause() {
            return this.resumeFutureRef.compareAndSet(null, SettableFuture.create());
        }
    }

    public abstract void runWhenUnpaused();

    public PausableRunnable(PauseSignal detector, Executor executor) {
        this.pauseSignal = detector;
        this.executor = executor;
    }

    public final void run() {
        SettableFuture resumeFuture = (SettableFuture) this.pauseSignal.resumeFutureRef.get();
        if (resumeFuture == null) {
            this.executor.execute(this.unpausedRunnable);
        } else {
            resumeFuture.addListener(this.unpausedRunnable, this.executor);
        }
    }
}
