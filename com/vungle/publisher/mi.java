package com.vungle.publisher;

import android.content.Context;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class mi implements MembersInjector<mg> {
    static final /* synthetic */ boolean f2572a = (!mi.class.desiredAssertionStatus());
    private final Provider<Context> f2573b;
    private final Provider<qh> f2574c;

    public final /* synthetic */ void injectMembers(Object obj) {
        mg mgVar = (mg) obj;
        if (mgVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mgVar.f2568a = (Context) this.f2573b.get();
        mgVar.f2569b = (qh) this.f2574c.get();
    }

    private mi(Provider<Context> provider, Provider<qh> provider2) {
        if (f2572a || provider != null) {
            this.f2573b = provider;
            if (f2572a || provider2 != null) {
                this.f2574c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<mg> m2166a(Provider<Context> provider, Provider<qh> provider2) {
        return new mi(provider, provider2);
    }
}
