package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ae implements MembersInjector<ac> {
    static final /* synthetic */ boolean f1197a = (!ae.class.desiredAssertionStatus());
    private final Provider<AdConfig> f1198b;

    public final /* synthetic */ void injectMembers(Object obj) {
        ac acVar = (ac) obj;
        if (acVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        acVar.f991a = (AdConfig) this.f1198b.get();
    }

    private ae(Provider<AdConfig> provider) {
        if (f1197a || provider != null) {
            this.f1198b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<ac> m1114a(Provider<AdConfig> provider) {
        return new ae(provider);
    }
}
