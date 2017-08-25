package com.vungle.publisher;

import com.vungle.publisher.ce.C1713b;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class qb extends qa {
    public EventListener f2992a;
    boolean f2993b;
    @Inject
    ce f2994c;
    @Inject
    C1821m f2995d;
    private int f2996e;
    private AtomicBoolean f2997f = new AtomicBoolean();

    /* compiled from: vungle */
    class C18652 implements Runnable {
        final /* synthetic */ qb f2986a;

        C18652(qb qbVar) {
            this.f2986a = qbVar;
        }

        public final void run() {
            this.f2986a.f2992a.onAdStart();
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1868a {
        @Inject
        public Provider<qb> f2991a;

        @Inject
        C1868a() {
        }
    }

    @Inject
    qb() {
    }

    public final void onEvent(ag agVar) {
        final boolean a = this.f2995d.m2157a();
        if (this.f2997f.compareAndSet(!a, a)) {
            m2354a(new Runnable(this) {
                final /* synthetic */ qb f2985b;

                public final void run() {
                    this.f2985b.f2992a.onAdPlayableChanged(a);
                }
            });
        }
    }

    public final void onEvent(bb<cu> bbVar) {
        so.m2470a(3, "VungleEvent", "onAdStart() callback", null);
        this.f2996e = 0;
        this.f2993b = false;
        m2354a(new C18652(this));
    }

    public final void onEvent(bd bdVar) {
        this.f2993b = true;
    }

    public final void onEvent(bq errorEndPlayEvent) {
        if (errorEndPlayEvent instanceof by) {
            so.m2470a(3, "VungleEvent", "onAdEnd() - activity destroyed", null);
        } else {
            so.m2470a(3, "VungleEvent", "onAdEnd() - error during playback", null);
        }
        m2356a(false);
    }

    private void m2356a(final boolean z) {
        so.m2470a(3, "VungleEvent", "onAdEnd(" + z + ") callback", null);
        m2354a(new Runnable(this) {
            final /* synthetic */ qb f2988b;

            public final void run() {
                this.f2988b.f2992a.onAdEnd(this.f2988b.f2993b, z);
            }
        });
    }

    public final void onEvent(bt btVar) {
        so.m2470a(3, "VungleEvent", "onAdUnavailable(error) callback", null);
        m2355a("Error launching ad");
    }

    public final void onEvent(br brVar) {
        so.m2470a(3, "VungleEvent", "onAdUnavailable(already playing) callback", null);
        m2355a("Ad already playing");
    }

    public final void onEvent(bu buVar) {
        so.m2470a(3, "VungleEvent", "onAdUnavailable(not initialized) callback", null);
        m2355a("Vungle Publisher SDK was not successfully initialized - please check the logs");
    }

    public final void onEvent(bv throttledCancelPlayEvent) {
        so.m2470a(3, "VungleEvent", "onAdUnavailable(throttled) callback", null);
        m2355a("Only " + throttledCancelPlayEvent.f1438a + " of minimum " + throttledCancelPlayEvent.f1439b + " seconds elapsed between ads");
    }

    public final void onEvent(bw bwVar) {
        so.m2470a(3, "VungleEvent", "onAdUnavailable(unavailable) callback", null);
        m2355a("No cached or streaming ad available");
    }

    public final void onEvent(ap endPlayVideoEvent) {
        int i = endPlayVideoEvent.f1417a;
        if (i > this.f2996e) {
            so.m2470a(3, "VungleEvent", "new watched millis " + i, null);
            this.f2996e = i;
            return;
        }
        so.m2470a(3, "VungleEvent", "shorter watched millis " + i, null);
    }

    private void m2355a(final String str) {
        m2354a(new Runnable(this) {
            final /* synthetic */ qb f2990b;

            public final void run() {
                this.f2990b.f2992a.onAdUnavailable(str);
            }
        });
    }

    private void m2354a(Runnable runnable) {
        this.f2994c.m1245a(runnable, C1713b.clientEvent);
    }

    public final void onEvent(cb<cu> playAdSuccessEvent) {
        m2356a(playAdSuccessEvent.f1440a);
    }
}
