package com.heyzap.internal;

import java.util.HashMap;
import java.util.Map;

public class FetchRateLimiter {
    Map<Key, Long> lastFetchMap = new HashMap();
    final int sleepPeriodMillis;

    private static class Key {
        public final int orientation;
        public final String tag;

        private Key(String tag, int orientation) {
            this.tag = tag;
            this.orientation = orientation;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Key key = (Key) o;
            if (this.orientation != key.orientation) {
                return false;
            }
            if (this.tag.equals(key.tag)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.tag.hashCode() * 31) + this.orientation;
        }
    }

    public FetchRateLimiter(int sleepPeriodMillis) {
        this.sleepPeriodMillis = sleepPeriodMillis;
    }

    public boolean tryAcquire(String tag, int orientation) {
        long now = System.currentTimeMillis();
        Key key = new Key(tag, orientation);
        Long lastUnresolvedFetchTime = (Long) this.lastFetchMap.get(key);
        if (lastUnresolvedFetchTime != null && lastUnresolvedFetchTime.longValue() + ((long) this.sleepPeriodMillis) > now) {
            return false;
        }
        this.lastFetchMap.put(key, Long.valueOf(now));
        return true;
    }

    public void resolve(String tag, int orientation) {
        this.lastFetchMap.remove(new Key(tag, orientation));
    }
}
