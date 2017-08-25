package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.acs.C1663a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class acu implements MembersInjector<C1663a> {
    static final /* synthetic */ boolean f1058a = (!acu.class.desiredAssertionStatus());
    private final Provider<C1892a> f1059b;
    private final Provider<agg> f1060c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1663a c1663a = (C1663a) obj;
        if (c1663a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1663a.f1041a = (C1892a) this.f1059b.get();
        c1663a.f1052b = (agg) this.f1060c.get();
        c1663a.f1053c = (C1892a) this.f1059b.get();
    }

    private acu(Provider<C1892a> provider, Provider<agg> provider2) {
        if (f1058a || provider != null) {
            this.f1059b = provider;
            if (f1058a || provider2 != null) {
                this.f1060c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1663a> m1017a(Provider<C1892a> provider, Provider<agg> provider2) {
        return new acu(provider, provider2);
    }
}
