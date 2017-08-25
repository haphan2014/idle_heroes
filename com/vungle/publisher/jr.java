package com.vungle.publisher;

import com.vungle.publisher.jn.C1796a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class jr implements MembersInjector<jn> {
    static final /* synthetic */ boolean f2288a = (!jr.class.desiredAssertionStatus());
    private final Provider<cq> f2289b;
    private final Provider<C1796a> f2290c;

    public final /* synthetic */ void injectMembers(Object obj) {
        jn jnVar = (jn) obj;
        if (jnVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        jnVar.f1551v = (cq) this.f2289b.get();
        jnVar.f2276a = (C1796a) this.f2290c.get();
    }

    private jr(Provider<cq> provider, Provider<C1796a> provider2) {
        if (f2288a || provider != null) {
            this.f2289b = provider;
            if (f2288a || provider2 != null) {
                this.f2290c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<jn> m2029a(Provider<cq> provider, Provider<C1796a> provider2) {
        return new jr(provider, provider2);
    }
}
