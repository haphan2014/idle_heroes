package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1904x implements MembersInjector<C1892a> {
    static final /* synthetic */ boolean f3552a = (!C1904x.class.desiredAssertionStatus());
    private final Provider<C1778a> f3553b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1892a c1892a = (C1892a) obj;
        if (c1892a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1892a.f3409a = (C1778a) this.f3553b.get();
    }

    private C1904x(Provider<C1778a> provider) {
        if (f3552a || provider != null) {
            this.f3553b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1892a> m2596a(Provider<C1778a> provider) {
        return new C1904x(provider);
    }
}
