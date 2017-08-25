package com.heyzap.common.concurrency;

public final class SettableFuture<V> extends AbstractFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture();
    }

    private SettableFuture() {
    }

    public boolean set(V value) {
        return super.set(value);
    }

    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }
}
