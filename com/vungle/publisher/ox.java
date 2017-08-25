package com.vungle.publisher;

import com.vungle.publisher.aft.C1704a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.oc.C1844a;
import com.vungle.publisher.oq.C1853a;
import com.vungle.publisher.ov.C1858a.C1857a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ox implements MembersInjector<ov> {
    static final /* synthetic */ boolean f2853a = (!ox.class.desiredAssertionStatus());
    private final Provider<qh> f2854b;
    private final Provider<C1778a> f2855c;
    private final Provider<agc> f2856d;
    private final Provider<pj> f2857e;
    private final Provider<C1857a> f2858f;
    private final Provider<C1704a> f2859g;
    private final Provider<C1853a> f2860h;
    private final Provider<C1844a> f2861i;

    public final /* synthetic */ void injectMembers(Object obj) {
        ov ovVar = (ov) obj;
        if (ovVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ovVar.f2643g = (qh) this.f2854b.get();
        ovVar.f2644h = (C1778a) this.f2855c.get();
        ovVar.f2645i = (agc) this.f2856d.get();
        ovVar.f2646j = (pj) this.f2857e.get();
        ovVar.f2845k = (C1857a) this.f2858f.get();
        ovVar.f2846l = (C1704a) this.f2859g.get();
        ovVar.f2847m = (C1853a) this.f2860h.get();
        ovVar.f2848n = (C1844a) this.f2861i.get();
    }

    private ox(Provider<qh> provider, Provider<C1778a> provider2, Provider<agc> provider3, Provider<pj> provider4, Provider<C1857a> provider5, Provider<C1704a> provider6, Provider<C1853a> provider7, Provider<C1844a> provider8) {
        if (f2853a || provider != null) {
            this.f2854b = provider;
            if (f2853a || provider2 != null) {
                this.f2855c = provider2;
                if (f2853a || provider3 != null) {
                    this.f2856d = provider3;
                    if (f2853a || provider4 != null) {
                        this.f2857e = provider4;
                        if (f2853a || provider5 != null) {
                            this.f2858f = provider5;
                            if (f2853a || provider6 != null) {
                                this.f2859g = provider6;
                                if (f2853a || provider7 != null) {
                                    this.f2860h = provider7;
                                    if (f2853a || provider8 != null) {
                                        this.f2861i = provider8;
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
        throw new AssertionError();
    }

    public static MembersInjector<ov> m2313a(Provider<qh> provider, Provider<C1778a> provider2, Provider<agc> provider3, Provider<pj> provider4, Provider<C1857a> provider5, Provider<C1704a> provider6, Provider<C1853a> provider7, Provider<C1844a> provider8) {
        return new ox(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
