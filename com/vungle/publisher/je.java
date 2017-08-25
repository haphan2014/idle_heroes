package com.vungle.publisher;

import com.vungle.publisher.ja.C1795a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class je implements MembersInjector<ja> {
    static final /* synthetic */ boolean f2244a = (!je.class.desiredAssertionStatus());
    private final Provider<C1795a> f2245b;

    public final /* synthetic */ void injectMembers(Object obj) {
        ja jaVar = (ja) obj;
        if (jaVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        jaVar.f2236a = (C1795a) this.f2245b.get();
    }

    private je(Provider<C1795a> provider) {
        if (f2244a || provider != null) {
            this.f2245b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<ja> m2001a(Provider<C1795a> provider) {
        return new je(provider);
    }
}
