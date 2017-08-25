package com.vungle.publisher;

import android.content.Context;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class nh implements MembersInjector<nf> {
    static final /* synthetic */ boolean f2632a = (!nh.class.desiredAssertionStatus());
    private final Provider<Context> f2633b;

    public final /* synthetic */ void injectMembers(Object obj) {
        nf nfVar = (nf) obj;
        if (nfVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        nfVar.f2629a = (Context) this.f2633b.get();
    }

    private nh(Provider<Context> provider) {
        if (f2632a || provider != null) {
            this.f2633b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<nf> m2197a(Provider<Context> provider) {
        return new nh(provider);
    }
}
