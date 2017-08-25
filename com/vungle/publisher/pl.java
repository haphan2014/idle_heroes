package com.vungle.publisher;

import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class pl extends qa {
    @Inject
    ce f2900a;
    @Inject
    C1861a f2901b;
    @Inject
    public SharedPreferences f2902c;
    public final AtomicBoolean f2903d = new AtomicBoolean();
    public long f2904e;

    @Singleton
    /* compiled from: vungle */
    static class C1861a implements Runnable {
        @Inject
        qh f2899a;

        @Inject
        C1861a() {
        }

        public final void run() {
            this.f2899a.m2361a(new bf());
        }
    }

    @Inject
    pl() {
    }

    public final long m2335b() {
        long j = this.f2902c.getLong("VgLastViewedTime", 0);
        so.m2470a(2, "VungleAd", "returning last ad end millis: " + j, null);
        return j;
    }

    public final int m2336c() {
        return this.f2902c.getInt("VgAdDelayDuration", 0);
    }

    public final void m2333a(boolean z) {
        if (this.f2903d.compareAndSet(true, false)) {
            so.m2470a(3, "VungleAd", "ending playing ad. isNormalAdEnd? " + z, null);
            mo4377f();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            so.m2470a(2, "VungleAd", "setting last ad end millis: " + elapsedRealtime, null);
            this.f2902c.edit().putLong("VgLastViewedTime", elapsedRealtime).apply();
            this.f2904e = 0;
            int c = m2336c();
            if (c > 0) {
                this.v.m2361a(new be());
                this.f2900a.m1244a(this.f2901b, (long) (c * 1000));
            }
            if (!z) {
                this.v.m2361a(new by(this.f2904e));
            }
        }
    }

    public final void onEvent(bp bpVar) {
        so.m2470a(3, "VungleAd", "InterstitialAdState received end ad event", null);
        m2333a(true);
    }

    public final boolean m2334a() {
        boolean z = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long b = m2335b();
        int elapsedRealtime2 = (int) ((SystemClock.elapsedRealtime() - m2335b()) / 1000);
        if (elapsedRealtime2 < 0) {
            so.m2470a(3, "VungleAd", "negative adDelayElapsedSeconds " + elapsedRealtime2 + ", currentTimestampMillis " + elapsedRealtime + ", lastAdEndMillis " + b, null);
        } else {
            int c = m2336c();
            if (elapsedRealtime2 < c) {
                z = false;
            }
            if (z) {
                so.m2470a(2, "VungleAd", elapsedRealtime2 + " / " + c + " ad delay seconds elapsed", null);
            } else {
                so.m2470a(3, "VungleAd", elapsedRealtime2 + " / " + c + " ad delay seconds elapsed", null);
            }
        }
        return z;
    }
}
