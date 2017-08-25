package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.tb.C1879a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class td implements MembersInjector<C1879a> {
    static final /* synthetic */ boolean f3251a = (!td.class.desiredAssertionStatus());
    private final Provider<Context> f3252b;
    private final Provider<nf> f3253c;
    private final Provider<agj> f3254d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1879a c1879a = (C1879a) obj;
        if (c1879a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1879a.f3241a = (Context) this.f3252b.get();
        c1879a.f3242b = (nf) this.f3253c.get();
        c1879a.f3243c = (agj) this.f3254d.get();
    }

    private td(Provider<Context> provider, Provider<nf> provider2, Provider<agj> provider3) {
        if (f3251a || provider != null) {
            this.f3252b = provider;
            if (f3251a || provider2 != null) {
                this.f3253c = provider2;
                if (f3251a || provider3 != null) {
                    this.f3254d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1879a> m2492a(Provider<Context> provider, Provider<nf> provider2, Provider<agj> provider3) {
        return new td(provider, provider2, provider3);
    }
}
