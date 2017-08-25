package com.vungle.publisher;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.DriveFile;
import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.aes.C16851;
import com.vungle.publisher.ce.C1713b;
import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.cu.C1722c;
import com.vungle.publisher.ei.C1747b;
import com.vungle.publisher.ei.C1747b.C17441;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.ka.C1800b;
import dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

@Singleton
/* compiled from: vungle */
public final class C1821m extends qa {
    @Inject
    pu f2529a;
    @Inject
    Context f2530b;
    @Inject
    pj f2531c;
    @Inject
    qh f2532d;
    @Inject
    Class f2533e;
    @Inject
    Class f2534f;
    @Inject
    public ce f2535g;
    @Inject
    un f2536h;
    @Inject
    Lazy<C1819b> f2537i;
    @Inject
    public Lazy<C1818a> f2538j;
    @Inject
    Provider<C1820c> f2539k;
    @Inject
    xp f2540l;
    @Inject
    pr f2541m;
    @Inject
    C1788a f2542n;
    @Inject
    C1800b f2543o;
    @Inject
    ac f2544p;
    @Inject
    pl f2545q;
    @Inject
    C1778a f2546r;
    @Inject
    C1721b f2547s;
    @Inject
    C1747b f2548t;
    @Inject
    aes f2549u;

    /* compiled from: vungle */
    class C18141 implements Observer<dy<?>> {
        final /* synthetic */ C1821m f2515a;

        C18141(C1821m c1821m) {
            this.f2515a = c1821m;
        }

        public final void onCompleted() {
            so.m2470a(3, "VunglePrepare", "ad observable onComplete", null);
            this.f2515a.f2529a.m2347a();
            this.f2515a.m2158b(false);
        }

        public final void onError(Throwable th) {
            so.m2470a(3, "VunglePrepare", "ad observable onError", null);
            this.f2515a.f2529a.m2347a();
            this.f2515a.m2158b(false);
        }

        public final /* synthetic */ void onNext(Object obj) {
            so.m2470a(3, "VunglePrepare", "ad observable onNext", null);
            this.f2515a.f2532d.m2361a(new as());
        }
    }

    /* compiled from: vungle */
    public class C18152 implements Runnable {
        final /* synthetic */ ab f2516a;
        final /* synthetic */ C1821m f2517b;

        public C18152(C1821m c1821m, ab abVar) {
            this.f2517b = c1821m;
            this.f2516a = abVar;
        }

        public final void run() {
            Throwable e;
            cu cuVar = null;
            so.m2470a(3, "VungleAd", "AdManager.playAd()", null);
            try {
                cu h_;
                String str;
                Object obj;
                C1821m c1821m = this.f2517b;
                ab abVar = this.f2516a;
                dy a = c1821m.m2155a(false);
                if (a != null) {
                    h_ = a.h_();
                } else {
                    h_ = null;
                }
                cu a2 = c1821m.m2156a(h_ == null ? null : (String) h_.mo4410w(), abVar);
                if (a2 != null) {
                    h_ = a2;
                }
                String str2 = "VungleAd";
                StringBuilder stringBuilder = new StringBuilder("next ad ");
                if (h_ == null) {
                    str = null;
                } else {
                    str = h_.mo4389z();
                }
                so.m2470a(4, str2, stringBuilder.append(str).toString(), null);
                if (h_ == null) {
                    try {
                        so.m2470a(3, "VungleAd", "no ad to play", null);
                        this.f2517b.f2532d.m2361a(new bw());
                        obj = null;
                    } catch (Exception e2) {
                        e = e2;
                        cuVar = h_;
                        try {
                            this.f2517b.f2546r.m1865a("VungleAd", "error launching ad", e);
                            this.f2517b.f2532d.m2361a(new ca(cuVar, false));
                        } finally {
                            this.f2517b.f2540l.m2619c();
                        }
                    }
                } else {
                    ((C1819b) this.f2517b.f2537i.get()).m1181d();
                    Intent intent = new Intent(this.f2517b.f2530b, h_ instanceof jv ? this.f2517b.f2533e : this.f2517b.f2534f);
                    intent.addFlags(DriveFile.MODE_READ_WRITE);
                    Parcelable parcelable = this.f2516a;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("adConfig", parcelable);
                    intent.putExtra("adConfig", bundle);
                    intent.putExtra("adId", (String) h_.mo4410w());
                    intent.putExtra("adType", h_.m1333f());
                    this.f2517b.f2530b.startActivity(intent);
                    obj = 1;
                }
                if (obj == null) {
                    this.f2517b.f2540l.m2619c();
                }
            } catch (Exception e3) {
                e = e3;
                this.f2517b.f2546r.m1865a("VungleAd", "error launching ad", e);
                this.f2517b.f2532d.m2361a(new ca(cuVar, false));
            }
        }
    }

    /* compiled from: vungle */
    class C18163 implements Runnable {
        final /* synthetic */ C1821m f2518a;

        C18163(C1821m c1821m) {
            this.f2518a = c1821m;
        }

        public final void run() {
            new C17441(this.f2518a.f2548t).m1570a();
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1818a extends qa {
        @Inject
        C1821m f2520a;

        @Inject
        C1818a() {
        }

        public final void onEvent(ah ahVar) {
            this.f2520a.m2158b(false);
        }
    }

    @Singleton
    /* compiled from: vungle */
    static class C1819b extends qa {
        final String f2521a = "VunglePrepare";
        @Inject
        C1821m f2522b;
        @Inject
        C1778a f2523c;

        @Inject
        C1819b() {
        }

        public final void onEvent(bb<cu> startPlayAdEvent) {
            try {
                startPlayAdEvent.mo4380a().m1329b(C1722c.viewed);
            } catch (Throwable e) {
                this.f2523c.m1865a("VunglePrepare", "error processing start play ad event", e);
            }
        }

        public final void onEvent(aq aqVar) {
            so.m2470a(3, "VunglePrepare", "sent ad report - un-registering play ad listener", null);
            mo4377f();
        }

        public final void onEvent(bs bsVar) {
            so.m2470a(3, "VunglePrepare", "play ad failure - un-registering play ad listener", null);
            mo4377f();
        }
    }

    /* compiled from: vungle */
    static class C1820c extends qa {
        final String f2524a = "VunglePrepare";
        volatile boolean f2525b;
        volatile C1789if f2526c;
        final long f2527d = System.currentTimeMillis();
        @Inject
        C1788a f2528e;

        @Inject
        C1820c() {
        }

        final void m2153a() {
            this.f2525b = true;
            synchronized (this) {
                notifyAll();
            }
        }

        public final void onEvent(ar prepareStreamingAdFailureEvent) {
            mo4377f();
            so.m2470a(3, "VunglePrepare", "request streaming ad failure after " + (prepareStreamingAdFailureEvent.f1301d - this.f2527d) + " ms", null);
            m2153a();
        }

        public final void onEvent(ba prepareStreamingAdSuccessEvent) {
            mo4377f();
            long j = prepareStreamingAdSuccessEvent.f1301d - this.f2527d;
            adn com_vungle_publisher_adn = (adn) prepareStreamingAdSuccessEvent.f1420a;
            if (Boolean.TRUE.equals(com_vungle_publisher_adn.f1151k)) {
                so.m2470a(3, "VunglePrepare", "received streaming ad " + com_vungle_publisher_adn.f1047f + " after " + j + " ms", null);
                String str = com_vungle_publisher_adn.f1047f;
                C1789if c1789if = (C1789if) this.f2528e.m1275a((Object) str);
                if (c1789if == null) {
                    C1789if a = this.f2528e.m1955a(com_vungle_publisher_adn);
                    this.f2526c = a;
                    so.m2470a(3, "VunglePrepare", "inserting new " + a.mo4389z(), null);
                    try {
                        a.mo4463q();
                    } catch (SQLException e) {
                        so.m2470a(3, "VunglePrepare", "did not insert streaming ad - possible duplicate", null);
                    }
                } else {
                    try {
                        this.f2528e.m1717a((jv) c1789if, (adq) com_vungle_publisher_adn);
                    } catch (Throwable e2) {
                        so.m2470a(5, "VunglePrepare", "error updating ad " + str, e2);
                    }
                    C1722c g = c1789if.m1334g();
                    switch (g) {
                        case aware:
                            so.m2470a(5, "VunglePrepare", "unexpected ad status " + g + " for " + c1789if.mo4389z(), null);
                            break;
                        case ready:
                        case viewed:
                            break;
                        default:
                            so.m2470a(5, "VunglePrepare", "existing " + c1789if.mo4389z() + " with status " + g + " - ignoring", null);
                            break;
                    }
                    so.m2470a(3, "VunglePrepare", "existing " + c1789if.mo4389z() + " with status " + g, null);
                    if (g != C1722c.ready) {
                        c1789if.m1329b(C1722c.ready);
                    }
                    this.f2526c = c1789if;
                }
            } else {
                so.m2470a(3, "VunglePrepare", "no streaming ad to play after " + j + " ms", null);
            }
            m2153a();
        }
    }

    @Inject
    C1821m() {
    }

    public final boolean m2157a() {
        if (!this.f2545q.f2903d.get() && this.f2545q.m2334a()) {
            boolean z;
            if (this.f2548t.m1577b() != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private void m2154a(Observable<dy<?>> observable) {
        if (this.f2529a.f2946o.compareAndSet(false, true)) {
            observable.subscribe(new C18141(this));
        }
    }

    final dy<?> m2155a(boolean z) {
        if (this.f2531c.mo4432l()) {
            dy<?> a;
            if (z) {
                a = this.f2548t.m1576a(C1722c.ready, C1722c.preparing);
            } else {
                a = this.f2548t.m1577b();
            }
            if (a == null) {
                so.m2470a(3, "VunglePrepare", "no local ad available", null);
                aes com_vungle_publisher_aes = this.f2549u;
                m2154a(Observable.defer(new C16851(com_vungle_publisher_aes)).subscribeOn(Schedulers.io()).flatMap(com_vungle_publisher_aes.f1247c).flatMap(com_vungle_publisher_aes.f1249e).flatMap(com_vungle_publisher_aes.f1250f).doOnNext(com_vungle_publisher_aes.f1251g).flatMap(com_vungle_publisher_aes.f1252h).filter(com_vungle_publisher_aes.f1253i).flatMap(com_vungle_publisher_aes.f1254j).flatMap(com_vungle_publisher_aes.f1248d).retryWhen(com_vungle_publisher_aes.f1256l.m1165a(100, "ad prep chain failure")));
                return a;
            }
            C1722c g = a.m1547g();
            if (g == C1722c.preparing) {
                if (z) {
                    so.m2470a(3, "VunglePrepare", "local ad partially prepared, restarting preparation for " + a.mo4459d(), null);
                    m2154a(Observable.just(a).flatMap(this.f2549u.f1248d));
                } else {
                    so.m2470a(4, "VunglePrepare", "local ad partially prepared, but not restarting preparation for " + a.mo4459d(), null);
                }
                return null;
            } else if (g != C1722c.ready) {
                return a;
            } else {
                so.m2470a(2, "VunglePrepare", "local ad already available for " + a.mo4459d(), null);
                return a;
            }
        }
        so.m2470a(5, "VunglePrepare", "unable to fetch local ad -  no external storage available", null);
        return null;
    }

    final C1789if m2156a(String str, ab abVar) {
        Throwable th;
        C1789if c1789if;
        Throwable th2;
        C1789if c1789if2;
        C1789if c1789if3 = null;
        boolean z = false;
        try {
            if (this.f2541m.f2917b) {
                String str2;
                uk a = this.f2536h.mo4546a();
                z = this.f2541m.f2918c.contains(a);
                String str3 = "VunglePrepare";
                StringBuilder stringBuilder = new StringBuilder("ad streaming ");
                if (z) {
                    str2 = "enabled";
                } else {
                    str2 = "disabled";
                }
                so.m2470a(3, str3, stringBuilder.append(str2).append(" for ").append(a).append(" connectivity").toString(), null);
            } else {
                so.m2470a(3, "VunglePrepare", "ad streaming disabled", null);
            }
            if (!z) {
                return null;
            }
            so.m2470a(3, "VunglePrepare", "requesting streaming ad", null);
            C1820c c1820c = (C1820c) this.f2539k.get();
            c1820c.m1181d();
            this.f2540l.m2617a(str, abVar);
            long j = c1820c.f2527d;
            int i = this.f2541m.f2919d;
            so.m2470a(3, "VungleConfig", "streaming response timeout config " + i + " ms", null);
            long j2 = ((long) i) + j;
            synchronized (c1820c) {
                while (!c1820c.f2525b) {
                    try {
                        long currentTimeMillis = j2 - System.currentTimeMillis();
                        if (currentTimeMillis > 0) {
                            try {
                                c1820c.wait(currentTimeMillis);
                            } catch (InterruptedException e) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        c1789if = null;
                        th2 = th;
                    }
                }
                j2 = System.currentTimeMillis() - j;
                if (c1820c.f2525b) {
                    c1789if = c1820c.f2526c;
                    if (c1789if != null) {
                        try {
                            so.m2470a(3, "VunglePrepare", "request streaming ad success after " + j2 + " ms " + c1789if.mo4389z(), null);
                            c1789if3 = c1789if;
                        } catch (Throwable th4) {
                            th2 = th4;
                            try {
                                throw th2;
                            } catch (Throwable e2) {
                                th2 = e2;
                                c1789if2 = c1789if;
                            }
                        }
                    } else {
                        c1789if3 = c1789if;
                    }
                } else {
                    so.m2470a(3, "VunglePrepare", "request streaming ad timeout after " + j2 + " ms", null);
                    c1820c.m2153a();
                }
                try {
                    return c1789if3;
                } catch (Throwable th32) {
                    th = th32;
                    c1789if = c1789if3;
                    th2 = th;
                    throw th2;
                }
            }
        } catch (Throwable e22) {
            th = e22;
            c1789if2 = null;
            th2 = th;
            this.f2546r.m1865a("VunglePrepare", "error getting streaming ad", th2);
            return c1789if2;
        }
    }

    public final void m2158b(boolean z) {
        m2155a(z);
        this.f2535g.m1243a(C1713b.deleteExpiredAds);
        Long c = this.f2548t.m1578c();
        if (c != null) {
            this.f2535g.m1246a(new C18163(this), C1713b.deleteExpiredAds, c.longValue() - System.currentTimeMillis());
        }
    }

    public final void onEvent(qk qkVar) {
        m2158b(false);
    }
}
