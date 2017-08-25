package com.vungle.publisher;

import com.vungle.publisher.ed.C1741a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class eg implements MembersInjector<C1741a> {
    static final /* synthetic */ boolean f1728a = (!eg.class.desiredAssertionStatus());
    private final Provider<ed> f1729b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1741a c1741a = (C1741a) obj;
        if (c1741a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1741a.f1722a = this.f1729b;
    }

    private eg(Provider<ed> provider) {
        if (f1728a || provider != null) {
            this.f1729b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1741a> m1564a(Provider<ed> provider) {
        return new eg(provider);
    }
}
