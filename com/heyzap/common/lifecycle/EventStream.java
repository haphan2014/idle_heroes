package com.heyzap.common.lifecycle;

import com.heyzap.common.concurrency.SettableFuture;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

public class EventStream<V> {
    private final Queue<EventListenerExecutorPair<V>> eventListenerExecutorPairs = new LinkedList();
    private int eventsCount = 0;
    private SettableFuture<V> firstEventFuture = SettableFuture.create();
    private V lastEvent = null;
    private SettableFuture<V> nextEventFuture = SettableFuture.create();

    public interface EventListener<V> {
        void onEvent(V v);
    }

    private class EventListenerExecutorPair<V> {
        private EventListener<V> eventListener;
        private Executor executor;

        public EventListenerExecutorPair(EventListener<V> listener, Executor executor) {
            this.eventListener = listener;
            this.executor = executor;
        }
    }

    public static <V> EventStream<V> create() {
        return new EventStream();
    }

    public synchronized void sendEvent(final V event) {
        if (this.eventsCount == 0) {
            this.firstEventFuture.set(event);
        }
        this.nextEventFuture.set(event);
        this.nextEventFuture = SettableFuture.create();
        this.lastEvent = event;
        this.eventsCount++;
        for (final EventListenerExecutorPair<V> pair : this.eventListenerExecutorPairs) {
            pair.executor.execute(new Runnable() {
                public void run() {
                    pair.eventListener.onEvent(event);
                }
            });
        }
    }

    public synchronized void addListener(final EventListener<V> listener, Executor executor) {
        this.eventListenerExecutorPairs.add(new EventListenerExecutorPair(listener, executor));
        if (this.eventsCount > 0) {
            executor.execute(new Runnable() {
                public void run() {
                    listener.onEvent(EventStream.this.lastEvent);
                }
            });
        }
    }

    public SettableFuture<V> getFirstEventFuture() {
        return this.firstEventFuture;
    }

    public SettableFuture<V> getNextEventFuture() {
        return this.nextEventFuture;
    }

    public static <V> void bind(EventStream<V> source, final EventStream<V> dest, Executor executor) {
        source.addListener(new EventListener<V>() {
            public void onEvent(V event) {
                dest.sendEvent(event);
            }
        }, executor);
    }

    public int getEventsCount() {
        return this.eventsCount;
    }
}
