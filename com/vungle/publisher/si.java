package com.vungle.publisher;

import android.content.Context;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class si implements MembersInjector<sg> {
    static final /* synthetic */ boolean f3186a = (!si.class.desiredAssertionStatus());
    private final Provider<Context> f3187b;

    public final /* synthetic */ void injectMembers(Object obj) {
        sg sgVar = (sg) obj;
        if (sgVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        sgVar.f3179c = (Context) this.f3187b.get();
    }

    private si(Provider<Context> provider) {
        if (f3186a || provider != null) {
            this.f3187b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<sg> m2455a(Provider<Context> provider) {
        return new si(provider);
    }
}
