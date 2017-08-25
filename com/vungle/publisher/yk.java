package com.vungle.publisher;

import com.vungle.publisher.acg.C1659a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.yi.C1918a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class yk implements MembersInjector<C1918a> {
    static final /* synthetic */ boolean f3678a = (!yk.class.desiredAssertionStatus());
    private final Provider<pj> f3679b;
    private final Provider<sn> f3680c;
    private final Provider<pq> f3681d;
    private final Provider<String> f3682e;
    private final Provider<WrapperFramework> f3683f;
    private final Provider<String> f3684g;
    private final Provider<C1659a> f3685h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1918a c1918a = (C1918a) obj;
        if (c1918a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1918a, this.f3679b);
        c1918a.f780b = (sn) this.f3680c.get();
        c1918a.f781c = (pq) this.f3681d.get();
        c1918a.f782d = (String) this.f3682e.get();
        c1918a.f783e = (WrapperFramework) this.f3683f.get();
        c1918a.f784f = (String) this.f3684g.get();
        c1918a.f3675g = (C1659a) this.f3685h.get();
    }

    private yk(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1659a> provider7) {
        if (f3678a || provider != null) {
            this.f3679b = provider;
            if (f3678a || provider2 != null) {
                this.f3680c = provider2;
                if (f3678a || provider3 != null) {
                    this.f3681d = provider3;
                    if (f3678a || provider4 != null) {
                        this.f3682e = provider4;
                        if (f3678a || provider5 != null) {
                            this.f3683f = provider5;
                            if (f3678a || provider6 != null) {
                                this.f3684g = provider6;
                                if (f3678a || provider7 != null) {
                                    this.f3685h = provider7;
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

    public static MembersInjector<C1918a> m2654a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1659a> provider7) {
        return new yk(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
