package com.vungle.publisher;

import com.vungle.publisher.ge.C1776a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gi implements MembersInjector<ge> {
    static final /* synthetic */ boolean f1978a = (!gi.class.desiredAssertionStatus());
    private final Provider<C1776a> f1979b;

    public final /* synthetic */ void injectMembers(Object obj) {
        ge geVar = (ge) obj;
        if (geVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        geVar.f1970a = (C1776a) this.f1979b.get();
    }

    private gi(Provider<C1776a> provider) {
        if (f1978a || provider != null) {
            this.f1979b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<ge> m1832a(Provider<C1776a> provider) {
        return new gi(provider);
    }
}
