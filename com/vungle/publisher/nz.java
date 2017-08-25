package com.vungle.publisher;

import com.vungle.publisher.nu.C1842a;
import com.vungle.publisher.nu.C1842a.C1841a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class nz implements MembersInjector<C1841a> {
    static final /* synthetic */ boolean f2722a = (!nz.class.desiredAssertionStatus());
    private final Provider<C1842a> f2723b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1841a c1841a = (C1841a) obj;
        if (c1841a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1841a.f2701a = (C1842a) this.f2723b.get();
    }

    private nz(Provider<C1842a> provider) {
        if (f2722a || provider != null) {
            this.f2723b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1841a> m2249a(Provider<C1842a> provider) {
        return new nz(provider);
    }
}
