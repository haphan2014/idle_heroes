package com.heyzap.mediation.hacks;

import com.heyzap.internal.Logger;
import java.util.HashSet;
import java.util.Set;

public class ChartboostHack {
    private static ChartboostHack instance = null;
    private Fetcher fetcher;
    public Set<String> requestedFetches = new HashSet();

    public interface Fetcher {
        void fetch(String str);

        boolean isAvailable(String str);

        void show(String str);
    }

    public synchronized void setFetcher(Fetcher fetcher) {
        this.fetcher = fetcher;
        for (String location : this.requestedFetches) {
            fetcher.fetch(location);
        }
    }

    public synchronized void fetch(String location) {
        Fetcher localFetcher = this.fetcher;
        Logger.format("ChartboostHack - fetch - location: %s, fetcher: %s", location, String.valueOf(localFetcher));
        if (localFetcher != null) {
            localFetcher.fetch(location);
        } else {
            this.requestedFetches.add(location);
        }
    }

    public void show(String location) {
        Fetcher localFetcher = this.fetcher;
        Logger.format("ChartboostHack - show - location: %s, fetcher: %s", location, String.valueOf(localFetcher));
        if (localFetcher != null) {
            localFetcher.show(location);
        }
    }

    public boolean isAvailable(String location) {
        Fetcher localFetcher = this.fetcher;
        Logger.format("ChartboostHack - fetch - isAvailable: %s, fetcher: %s", location, String.valueOf(localFetcher));
        if (localFetcher != null) {
            return localFetcher.isAvailable(location);
        }
        return false;
    }

    public Fetcher getFetcher() {
        return this.fetcher;
    }

    public static synchronized ChartboostHack instance() {
        ChartboostHack chartboostHack;
        synchronized (ChartboostHack.class) {
            if (instance == null) {
                instance = new ChartboostHack();
            }
            chartboostHack = instance;
        }
        return chartboostHack;
    }
}
