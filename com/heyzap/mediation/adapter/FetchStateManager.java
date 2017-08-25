package com.heyzap.mediation.adapter;

import com.heyzap.internal.Constants.AdUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class FetchStateManager<T> {
    private T defaultValue;
    Map<AdUnit, FetchStateWrapper<T>> fetchMap = new ConcurrentHashMap();
    List<ExecutorCallback<T>> updateListeners = new ArrayList();

    public interface FetchStartedListener<T> {
        void onFetchStarted(AdUnit adUnit, T t);
    }

    private static class ExecutorCallback<T> implements FetchStartedListener<T> {
        private final FetchStartedListener delegate;
        private final ExecutorService executorService;

        private ExecutorCallback(FetchStartedListener delegate, ExecutorService executorService) {
            this.delegate = delegate;
            this.executorService = executorService;
        }

        public void onFetchStarted(final AdUnit adUnit, final T value) {
            this.executorService.submit(new Runnable() {
                public void run() {
                    ExecutorCallback.this.delegate.onFetchStarted(adUnit, value);
                }
            });
        }
    }

    private static class FetchStateWrapper<T> {
        public final AtomicBoolean started;
        public final T value;

        private FetchStateWrapper(T value) {
            this.started = new AtomicBoolean(false);
            this.value = value;
        }
    }

    public void set(AdUnit adUnit, T value) {
        this.fetchMap.put(adUnit, new FetchStateWrapper(value));
    }

    public T get(AdUnit adUnit) {
        FetchStateWrapper<T> wrapper = (FetchStateWrapper) this.fetchMap.get(adUnit);
        return wrapper == null ? this.defaultValue : wrapper.value;
    }

    public void start(AdUnit adUnit) {
        FetchStateWrapper<T> value = (FetchStateWrapper) this.fetchMap.get(adUnit);
        if (value != null && value.started.compareAndSet(false, true)) {
            for (FetchStartedListener<T> updateListener : this.updateListeners) {
                updateListener.onFetchStarted(adUnit, get(adUnit));
            }
        }
    }

    public void addFetchStartedListener(FetchStartedListener<T> listener, ExecutorService executorService) {
        this.updateListeners.add(new ExecutorCallback(listener, executorService));
    }

    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }
}
