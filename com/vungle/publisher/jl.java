package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.ie.C1787a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class jl implements MembersInjector<C1787a> {
    static final /* synthetic */ boolean f2265a = (!jl.class.desiredAssertionStatus());
    private final Provider<cq> f2266b;
    private final Provider<C1892a> f2267c;
    private final Provider<ie> f2268d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1787a c1787a = (C1787a) obj;
        if (c1787a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1787a.f1530d = (cq) this.f2266b.get();
        c1787a.f1676e = (C1892a) this.f2267c.get();
        c1787a.f2151a = this.f2268d;
    }

    private jl(Provider<cq> provider, Provider<C1892a> provider2, Provider<ie> provider3) {
        if (f2265a || provider != null) {
            this.f2266b = provider;
            if (f2265a || provider2 != null) {
                this.f2267c = provider2;
                if (f2265a || provider3 != null) {
                    this.f2268d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1787a> m2008a(Provider<cq> provider, Provider<C1892a> provider2, Provider<ie> provider3) {
        return new jl(provider, provider2, provider3);
    }
}
