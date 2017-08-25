package com.vungle.publisher;

import com.vungle.publisher.ir.C1793a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class iu implements MembersInjector<C1793a> {
    static final /* synthetic */ boolean f2203a = (!iu.class.desiredAssertionStatus());
    private final Provider<cq> f2204b;
    private final Provider<ir> f2205c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1793a c1793a = (C1793a) obj;
        if (c1793a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1793a.f1530d = (cq) this.f2204b.get();
        c1793a.f2197a = this.f2205c;
    }

    private iu(Provider<cq> provider, Provider<ir> provider2) {
        if (f2203a || provider != null) {
            this.f2204b = provider;
            if (f2203a || provider2 != null) {
                this.f2205c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1793a> m1988a(Provider<cq> provider, Provider<ir> provider2) {
        return new iu(provider, provider2);
    }
}
