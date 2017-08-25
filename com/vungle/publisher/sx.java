package com.vungle.publisher;

import com.vungle.publisher.jn.C1796a;
import com.vungle.publisher.su.C1876a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class sx implements MembersInjector<C1876a> {
    static final /* synthetic */ boolean f3220a = (!sx.class.desiredAssertionStatus());
    private final Provider<su> f3221b;
    private final Provider<C1796a> f3222c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1876a c1876a = (C1876a) obj;
        if (c1876a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1876a.f3203a = this.f3221b;
        c1876a.f3204b = (C1796a) this.f3222c.get();
    }

    private sx(Provider<su> provider, Provider<C1796a> provider2) {
        if (f3220a || provider != null) {
            this.f3221b = provider;
            if (f3220a || provider2 != null) {
                this.f3222c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1876a> m2485a(Provider<su> provider, Provider<C1796a> provider2) {
        return new sx(provider, provider2);
    }
}
