package com.heyzap.mediation;

import android.location.Location;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class LocationProvider {
    private ConcurrentLinkedQueue<ListenerExecutorPair> listeners = new ConcurrentLinkedQueue();
    private Location location = null;

    private static class ListenerExecutorPair {
        private final Executor executor;
        private final LocationListener locationListener;

        private ListenerExecutorPair(LocationListener locationListener, Executor executor) {
            this.locationListener = locationListener;
            this.executor = executor;
        }

        public void sendLocation(final Location location) {
            this.executor.execute(new Runnable() {
                public void run() {
                    ListenerExecutorPair.this.locationListener.onLocationUpdate(location);
                }
            });
        }
    }

    public interface LocationListener {
        void onLocationUpdate(Location location);
    }

    public synchronized void setLocation(Location location) {
        this.location = location;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((ListenerExecutorPair) it.next()).sendLocation(location);
        }
    }

    public synchronized void addLocationListener(LocationListener listener, Executor executor) {
        ListenerExecutorPair listenerExecutorPair = new ListenerExecutorPair(listener, executor);
        this.listeners.add(listenerExecutorPair);
        if (this.location != null) {
            listenerExecutorPair.sendLocation(this.location);
        }
    }

    public Location getLocation() {
        return this.location;
    }
}
