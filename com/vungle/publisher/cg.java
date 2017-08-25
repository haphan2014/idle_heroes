package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cg implements MembersInjector<ce> {
    static final /* synthetic */ boolean f1487a = (!cg.class.desiredAssertionStatus());
    private final Provider<C1778a> f1488b;
    private final Provider<agg> f1489c;

    public final /* synthetic */ void injectMembers(Object obj) {
        ce ceVar = (ce) obj;
        if (ceVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ceVar.f1480c = DoubleCheck.lazy(this.f1488b);
        ceVar.f1481d = (agg) this.f1489c.get();
    }

    private cg(Provider<C1778a> provider, Provider<agg> provider2) {
        if (f1487a || provider != null) {
            this.f1488b = provider;
            if (f1487a || provider2 != null) {
                this.f1489c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ce> m1248a(Provider<C1778a> provider, Provider<agg> provider2) {
        return new cg(provider, provider2);
    }
}
