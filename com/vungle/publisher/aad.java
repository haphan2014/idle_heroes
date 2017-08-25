package com.vungle.publisher;

import com.vungle.publisher.aab.C1625a;
import com.vungle.publisher.env.WrapperFramework;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aad implements MembersInjector<C1625a> {
    static final /* synthetic */ boolean f793a = (!aad.class.desiredAssertionStatus());
    private final Provider<pj> f794b;
    private final Provider<sn> f795c;
    private final Provider<pq> f796d;
    private final Provider<String> f797e;
    private final Provider<WrapperFramework> f798f;
    private final Provider<String> f799g;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1625a c1625a = (C1625a) obj;
        if (c1625a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1625a, this.f794b);
        c1625a.f780b = (sn) this.f795c.get();
        c1625a.f781c = (pq) this.f796d.get();
        c1625a.f782d = (String) this.f797e.get();
        c1625a.f783e = (WrapperFramework) this.f798f.get();
        c1625a.f784f = (String) this.f799g.get();
        c1625a.f786g = (pj) this.f794b.get();
    }

    private aad(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6) {
        if (f793a || provider != null) {
            this.f794b = provider;
            if (f793a || provider2 != null) {
                this.f795c = provider2;
                if (f793a || provider3 != null) {
                    this.f796d = provider3;
                    if (f793a || provider4 != null) {
                        this.f797e = provider4;
                        if (f793a || provider5 != null) {
                            this.f798f = provider5;
                            if (f793a || provider6 != null) {
                                this.f799g = provider6;
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

    public static MembersInjector<C1625a> m831a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6) {
        return new aad(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
