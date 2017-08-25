package com.vungle.publisher;

import com.vungle.publisher.bl.C1708a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class bn implements MembersInjector<C1708a> {
    static final /* synthetic */ boolean f1436a = (!bn.class.desiredAssertionStatus());
    private final Provider<mc> f1437b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1708a c1708a = (C1708a) obj;
        if (c1708a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1708a.f1430a = (mc) this.f1437b.get();
    }

    private bn(Provider<mc> provider) {
        if (f1436a || provider != null) {
            this.f1437b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1708a> m1235a(Provider<mc> provider) {
        return new bn(provider);
    }
}
