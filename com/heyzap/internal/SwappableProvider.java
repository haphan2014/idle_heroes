package com.heyzap.internal;

public class SwappableProvider<T> implements Provider<T> {
    private T ref;

    private SwappableProvider(T in) {
        this.ref = in;
    }

    public T get() {
        return this.ref;
    }

    public void set(T in) {
        this.ref = in;
    }

    public static <L> SwappableProvider<L> of(L in) {
        return new SwappableProvider(in);
    }
}
