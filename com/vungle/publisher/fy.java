package com.vungle.publisher;

import com.vungle.publisher.fv.C1773a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fy implements MembersInjector<C1773a> {
    static final /* synthetic */ boolean f1940a = (!fy.class.desiredAssertionStatus());
    private final Provider<cq> f1941b;
    private final Provider<fv> f1942c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1773a c1773a = (C1773a) obj;
        if (c1773a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1773a.f1530d = (cq) this.f1941b.get();
        c1773a.f1934a = this.f1942c;
    }

    private fy(Provider<cq> provider, Provider<fv> provider2) {
        if (f1940a || provider != null) {
            this.f1941b = provider;
            if (f1940a || provider2 != null) {
                this.f1942c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1773a> m1810a(Provider<cq> provider, Provider<fv> provider2) {
        return new fy(provider, provider2);
    }
}
