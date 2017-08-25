package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.nu.C1842a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class oa implements MembersInjector<C1842a> {
    static final /* synthetic */ boolean f2727a = (!oa.class.desiredAssertionStatus());
    private final Provider<qh> f2728b;
    private final Provider<C1778a> f2729c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1842a c1842a = (C1842a) obj;
        if (c1842a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1842a.f1341v = (qh) this.f2728b.get();
        c1842a.f2702b = (C1778a) this.f2729c.get();
    }

    private oa(Provider<qh> provider, Provider<C1778a> provider2) {
        if (f2727a || provider != null) {
            this.f2728b = provider;
            if (f2727a || provider2 != null) {
                this.f2729c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1842a> m2251a(Provider<qh> provider, Provider<C1778a> provider2) {
        return new oa(provider, provider2);
    }
}
