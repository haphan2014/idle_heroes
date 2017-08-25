package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.jn.C1796a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class jq implements MembersInjector<C1796a> {
    static final /* synthetic */ boolean f2284a = (!jq.class.desiredAssertionStatus());
    private final Provider<cq> f2285b;
    private final Provider<C1778a> f2286c;
    private final Provider<jn> f2287d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1796a c1796a = (C1796a) obj;
        if (c1796a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1796a.f1530d = (cq) this.f2285b.get();
        c1796a.f2273a = (C1778a) this.f2286c.get();
        c1796a.f2274b = this.f2287d;
    }

    private jq(Provider<cq> provider, Provider<C1778a> provider2, Provider<jn> provider3) {
        if (f2284a || provider != null) {
            this.f2285b = provider;
            if (f2284a || provider2 != null) {
                this.f2286c = provider2;
                if (f2284a || provider3 != null) {
                    this.f2287d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1796a> m2028a(Provider<cq> provider, Provider<C1778a> provider2, Provider<jn> provider3) {
        return new jq(provider, provider2, provider3);
    }
}
