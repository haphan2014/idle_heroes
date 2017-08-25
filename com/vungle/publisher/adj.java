package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.adh.C1671a;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class adj implements MembersInjector<C1671a> {
    static final /* synthetic */ boolean f1132a = (!adj.class.desiredAssertionStatus());
    private final Provider<C1892a> f1133b;
    private final Provider<agg> f1134c;
    private final Provider<C1778a> f1135d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1671a c1671a = (C1671a) obj;
        if (c1671a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1671a.f1041a = (C1892a) this.f1133b.get();
        c1671a.f1127b = (agg) this.f1134c.get();
        c1671a.f1128c = (C1778a) this.f1135d.get();
    }

    private adj(Provider<C1892a> provider, Provider<agg> provider2, Provider<C1778a> provider3) {
        if (f1132a || provider != null) {
            this.f1133b = provider;
            if (f1132a || provider2 != null) {
                this.f1134c = provider2;
                if (f1132a || provider3 != null) {
                    this.f1135d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1671a> m1069a(Provider<C1892a> provider, Provider<agg> provider2, Provider<C1778a> provider3) {
        return new adj(provider, provider2, provider3);
    }
}
