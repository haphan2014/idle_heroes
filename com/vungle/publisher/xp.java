package com.vungle.publisher;

import com.google.android.gms.fitness.FitnessStatusCodes;
import com.vungle.publisher.ce.C1713b;
import com.vungle.publisher.gx.C1778a;
import dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class xp extends ve {
    @Inject
    qh f3598a;
    @Inject
    xz f3599b;
    @Inject
    za f3600c;
    @Inject
    zm f3601d;
    @Inject
    zs f3602e;
    @Inject
    zy f3603f;
    @Inject
    Lazy<aah> f3604g;
    @Inject
    aan f3605h;
    @Inject
    C1778a f3606i;
    @Inject
    protected ce f3607j;

    /* compiled from: vungle */
    class C19072 implements Runnable {
        final /* synthetic */ xp f3586a;

        C19072(xp xpVar) {
            this.f3586a = xpVar;
        }

        public final void run() {
            try {
                this.f3586a.f3600c.m2678a().m2553a();
            } catch (Throwable e) {
                this.f3586a.f3606i.m1865a("VungleProtocol", "error sending request config", e);
            }
        }
    }

    /* compiled from: vungle */
    class C19127 implements Runnable {
        final /* synthetic */ xp f3597a;

        C19127(xp xpVar) {
            this.f3597a = xpVar;
        }

        public final void run() {
            try {
                this.f3597a.f3605h.m852a(System.currentTimeMillis() / 1000).m2553a();
            } catch (Throwable e) {
                this.f3597a.f3606i.m1865a("VungleProtocol", "error sending unfilled ad", e);
            }
        }
    }

    @Inject
    xp() {
    }

    public final void m2615a(final db<?, ?, ?, ?> dbVar) {
        this.f3607j.m1245a(new Runnable(this) {
            final /* synthetic */ xp f3585b;

            public final void run() {
                try {
                    this.f3585b.f3599b.m2637a(dbVar).m2553a();
                } catch (Throwable e) {
                    this.f3585b.f3606i.m1865a("VungleProtocol", "error sending report ad", e);
                }
            }
        }, C1713b.reportAd);
    }

    public final void m2612a() {
        this.f3607j.m1245a(new C19072(this), C1713b.requestConfig);
    }

    public final void m2617a(final String str, final ab abVar) {
        this.f3607j.m1245a(new Runnable(this) {
            final /* synthetic */ xp f3589c;

            public final void run() {
                try {
                    this.f3589c.f3601d.m2709a(str, abVar).m2553a();
                } catch (Throwable e) {
                    this.f3589c.f3606i.m1867b("VungleProtocol", "error creating request streaming ad message", e);
                    this.f3589c.m2618b();
                } catch (Throwable e2) {
                    this.f3589c.f3606i.m1865a("VungleProtocol", "error requesting streaming ad", e2);
                    this.f3589c.m2618b();
                }
            }
        }, C1713b.requestStreamingAd);
    }

    final void m2618b() {
        this.f3598a.m2361a(new ar());
    }

    public final void m2614a(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        this.f3607j.m1245a(new Runnable(this) {
            final /* synthetic */ xp f3592c;

            public final void run() {
                try {
                    this.f3592c.f3602e.m2718a(j3, j4).m2553a();
                } catch (Throwable e) {
                    this.f3592c.f3606i.m1865a("VungleProtocol", "error sending session end", e);
                }
            }
        }, C1713b.sessionEnd);
    }

    public final void m2613a(final long j) {
        this.f3607j.m1245a(new Runnable(this) {
            final /* synthetic */ xp f3594b;

            public final void run() {
                try {
                    this.f3594b.f3603f.m2727a(j).m2553a();
                } catch (Throwable e) {
                    this.f3594b.f3606i.m1865a("VungleProtocol", "error sending session start", e);
                }
            }
        }, C1713b.sessionStart);
    }

    public final void m2616a(final wx wxVar) {
        this.f3607j.m1246a(new Runnable(this) {
            final /* synthetic */ xp f3596b;

            public final void run() {
                try {
                    ((aah) this.f3596b.f3604g.get()).m843a().m2553a();
                } catch (Throwable e) {
                    this.f3596b.f3606i.m1865a("VungleProtocol", "error sending track install", e);
                    this.f3596b.m2616a(wxVar);
                }
            }
        }, C1713b.reportInstall, (long) agi.m1227a(wxVar.f3546b, FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS, 300000));
    }

    public final void m2619c() {
        this.f3607j.m1245a(new C19127(this), C1713b.unfilledAd);
    }
}
