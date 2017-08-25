package com.vungle.publisher;

import com.vungle.publisher.ko.C1804a;
import com.vungle.publisher.li.C1809a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ll implements MembersInjector<C1809a> {
    static final /* synthetic */ boolean f2469a = (!ll.class.desiredAssertionStatus());
    private final Provider<li> f2470b;
    private final Provider<C1804a> f2471c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1809a c1809a = (C1809a) obj;
        if (c1809a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1809a.f2462a = this.f2470b;
        c1809a.f2463b = (C1804a) this.f2471c.get();
    }

    private ll(Provider<li> provider, Provider<C1804a> provider2) {
        if (f2469a || provider != null) {
            this.f2470b = provider;
            if (f2469a || provider2 != null) {
                this.f2471c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1809a> m2128a(Provider<li> provider, Provider<C1804a> provider2) {
        return new ll(provider, provider2);
    }
}
