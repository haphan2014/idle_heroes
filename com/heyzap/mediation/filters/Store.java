package com.heyzap.mediation.filters;

public interface Store<V> {
    V get();

    void set(V v);
}
