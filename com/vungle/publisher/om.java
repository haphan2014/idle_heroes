package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.ok.C1846a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class om implements MembersInjector<C1846a> {
    static final /* synthetic */ boolean f2765a = (!om.class.desiredAssertionStatus());
    private final Provider<Context> f2766b;
    private final Provider<nf> f2767c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1846a c1846a = (C1846a) obj;
        if (c1846a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1846a.f2756a = (Context) this.f2766b.get();
        c1846a.f2757b = (nf) this.f2767c.get();
    }

    private om(Provider<Context> provider, Provider<nf> provider2) {
        if (f2765a || provider != null) {
            this.f2766b = provider;
            if (f2765a || provider2 != null) {
                this.f2767c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1846a> m2269a(Provider<Context> provider, Provider<nf> provider2) {
        return new om(provider, provider2);
    }
}
