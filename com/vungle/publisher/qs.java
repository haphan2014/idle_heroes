package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class qs implements MembersInjector<qq> {
    static final /* synthetic */ boolean f3024a = (!qs.class.desiredAssertionStatus());
    private final Provider<String> f3025b;
    private final Provider<String> f3026c;

    public final /* synthetic */ void injectMembers(Object obj) {
        qq qqVar = (qq) obj;
        if (qqVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        qqVar.f3020a = this.f3025b;
        qqVar.f3021b = this.f3026c;
    }

    private qs(Provider<String> provider, Provider<String> provider2) {
        if (f3024a || provider != null) {
            this.f3025b = provider;
            if (f3024a || provider2 != null) {
                this.f3026c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<qq> m2368a(Provider<String> provider, Provider<String> provider2) {
        return new qs(provider, provider2);
    }
}
