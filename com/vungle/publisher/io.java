package com.vungle.publisher;

import com.vungle.publisher.il.C1791a;
import com.vungle.publisher.ir.C1793a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class io implements MembersInjector<C1791a> {
    static final /* synthetic */ boolean f2185a = (!io.class.desiredAssertionStatus());
    private final Provider<cq> f2186b;
    private final Provider<il> f2187c;
    private final Provider<C1793a> f2188d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1791a c1791a = (C1791a) obj;
        if (c1791a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1791a.f1530d = (cq) this.f2186b.get();
        c1791a.f2171a = this.f2187c;
        c1791a.f2172b = (C1793a) this.f2188d.get();
    }

    private io(Provider<cq> provider, Provider<il> provider2, Provider<C1793a> provider3) {
        if (f2185a || provider != null) {
            this.f2186b = provider;
            if (f2185a || provider2 != null) {
                this.f2187c = provider2;
                if (f2185a || provider3 != null) {
                    this.f2188d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1791a> m1977a(Provider<cq> provider, Provider<il> provider2, Provider<C1793a> provider3) {
        return new io(provider, provider2, provider3);
    }
}
