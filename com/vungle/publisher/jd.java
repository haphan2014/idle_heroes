package com.vungle.publisher;

import com.vungle.publisher.ig.C1790a;
import com.vungle.publisher.ja.C1795a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class jd implements MembersInjector<C1795a> {
    static final /* synthetic */ boolean f2241a = (!jd.class.desiredAssertionStatus());
    private final Provider<ja> f2242b;
    private final Provider<C1790a> f2243c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1795a c1795a = (C1795a) obj;
        if (c1795a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1795a.f2234a = this.f2242b;
        c1795a.f2235b = (C1790a) this.f2243c.get();
    }

    private jd(Provider<ja> provider, Provider<C1790a> provider2) {
        if (f2241a || provider != null) {
            this.f2242b = provider;
            if (f2241a || provider2 != null) {
                this.f2243c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1795a> m2000a(Provider<ja> provider, Provider<C1790a> provider2) {
        return new jd(provider, provider2);
    }
}
