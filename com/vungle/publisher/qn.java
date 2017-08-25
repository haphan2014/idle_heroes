package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class qn implements MembersInjector<ql> {
    static final /* synthetic */ boolean f3016a = (!qn.class.desiredAssertionStatus());
    private final Provider<we> f3017b;
    private final Provider<pr> f3018c;
    private final Provider<C1778a> f3019d;

    public final /* synthetic */ void injectMembers(Object obj) {
        ql qlVar = (ql) obj;
        if (qlVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        qlVar.f3011a = (we) this.f3017b.get();
        qlVar.f3012b = (pr) this.f3018c.get();
        qlVar.f3013c = (C1778a) this.f3019d.get();
    }

    private qn(Provider<we> provider, Provider<pr> provider2, Provider<C1778a> provider3) {
        if (f3016a || provider != null) {
            this.f3017b = provider;
            if (f3016a || provider2 != null) {
                this.f3018c = provider2;
                if (f3016a || provider3 != null) {
                    this.f3019d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ql> m2365a(Provider<we> provider, Provider<pr> provider2, Provider<C1778a> provider3) {
        return new qn(provider, provider2, provider3);
    }
}
