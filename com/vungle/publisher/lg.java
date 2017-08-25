package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.dz.C1739a;
import com.vungle.publisher.kd.C1801a;
import com.vungle.publisher.kt.C1805a;
import com.vungle.publisher.ky.C1806a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lg implements MembersInjector<C1806a> {
    static final /* synthetic */ boolean f2449a = (!lg.class.desiredAssertionStatus());
    private final Provider<cq> f2450b;
    private final Provider<C1733a> f2451c;
    private final Provider<C1723a> f2452d;
    private final Provider<C1801a> f2453e;
    private final Provider<C1805a> f2454f;
    private final Provider<ky> f2455g;
    private final Provider<C1739a> f2456h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1806a c1806a = (C1806a) obj;
        if (c1806a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1806a.f1530d = (cq) this.f2450b.get();
        c1806a.f1588a = (C1733a) this.f2451c.get();
        c1806a.f1589b = (C1723a) this.f2452d.get();
        c1806a.f2412c = (C1801a) this.f2453e.get();
        c1806a.f2413e = (C1805a) this.f2454f.get();
        c1806a.f2414f = this.f2455g;
        c1806a.f2415g = (C1739a) this.f2456h.get();
    }

    private lg(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1801a> provider4, Provider<C1805a> provider5, Provider<ky> provider6, Provider<C1739a> provider7) {
        if (f2449a || provider != null) {
            this.f2450b = provider;
            if (f2449a || provider2 != null) {
                this.f2451c = provider2;
                if (f2449a || provider3 != null) {
                    this.f2452d = provider3;
                    if (f2449a || provider4 != null) {
                        this.f2453e = provider4;
                        if (f2449a || provider5 != null) {
                            this.f2454f = provider5;
                            if (f2449a || provider6 != null) {
                                this.f2455g = provider6;
                                if (f2449a || provider7 != null) {
                                    this.f2456h = provider7;
                                    return;
                                }
                                throw new AssertionError();
                            }
                            throw new AssertionError();
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1806a> m2121a(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1801a> provider4, Provider<C1805a> provider5, Provider<ky> provider6, Provider<C1739a> provider7) {
        return new lg(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
