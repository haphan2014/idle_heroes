package com.vungle.publisher;

import com.vungle.publisher.fk.C1767a;
import com.vungle.publisher.ge.C1776a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gh implements MembersInjector<C1776a> {
    static final /* synthetic */ boolean f1975a = (!gh.class.desiredAssertionStatus());
    private final Provider<ge> f1976b;
    private final Provider<C1767a> f1977c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1776a c1776a = (C1776a) obj;
        if (c1776a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1776a.f1966a = this.f1976b;
        c1776a.f1967b = (C1767a) this.f1977c.get();
    }

    private gh(Provider<ge> provider, Provider<C1767a> provider2) {
        if (f1975a || provider != null) {
            this.f1976b = provider;
            if (f1975a || provider2 != null) {
                this.f1977c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1776a> m1831a(Provider<ge> provider, Provider<C1767a> provider2) {
        return new gh(provider, provider2);
    }
}
