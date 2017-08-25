package com.vungle.publisher;

import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.yt.C1921a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class yw implements MembersInjector<C1921a> {
    static final /* synthetic */ boolean f3715a = (!yw.class.desiredAssertionStatus());
    private final Provider<pj> f3716b;
    private final Provider<sn> f3717c;
    private final Provider<pq> f3718d;
    private final Provider<String> f3719e;
    private final Provider<WrapperFramework> f3720f;
    private final Provider<String> f3721g;
    private final Provider<yt> f3722h;
    private final Provider<acv> f3723i;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1921a c1921a = (C1921a) obj;
        if (c1921a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1921a, this.f3716b);
        c1921a.f780b = (sn) this.f3717c.get();
        c1921a.f781c = (pq) this.f3718d.get();
        c1921a.f782d = (String) this.f3719e.get();
        c1921a.f783e = (WrapperFramework) this.f3720f.get();
        c1921a.f784f = (String) this.f3721g.get();
        c1921a.f3708g = (yt) this.f3722h.get();
        c1921a.f3709h = (acv) this.f3723i.get();
    }

    private yw(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<yt> provider7, Provider<acv> provider8) {
        if (f3715a || provider != null) {
            this.f3716b = provider;
            if (f3715a || provider2 != null) {
                this.f3717c = provider2;
                if (f3715a || provider3 != null) {
                    this.f3718d = provider3;
                    if (f3715a || provider4 != null) {
                        this.f3719e = provider4;
                        if (f3715a || provider5 != null) {
                            this.f3720f = provider5;
                            if (f3715a || provider6 != null) {
                                this.f3721g = provider6;
                                if (f3715a || provider7 != null) {
                                    this.f3722h = provider7;
                                    if (f3715a || provider8 != null) {
                                        this.f3723i = provider8;
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

    public static MembersInjector<C1921a> m2674a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<yt> provider7, Provider<acv> provider8) {
        return new yw(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
