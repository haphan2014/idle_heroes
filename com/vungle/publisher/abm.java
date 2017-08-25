package com.vungle.publisher;

import com.vungle.publisher.abk.C1646a;
import com.vungle.publisher.abk.C1646a.C1644a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class abm implements MembersInjector<C1646a> {
    static final /* synthetic */ boolean f940a = (!abm.class.desiredAssertionStatus());
    private final Provider<C1644a> f941b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1646a c1646a = (C1646a) obj;
        if (c1646a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1646a.f934a = (C1644a) this.f941b.get();
    }

    private abm(Provider<C1644a> provider) {
        if (f940a || provider != null) {
            this.f941b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1646a> m945a(Provider<C1644a> provider) {
        return new abm(provider);
    }
}
