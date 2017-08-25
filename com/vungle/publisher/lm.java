package com.vungle.publisher;

import com.vungle.publisher.li.C1809a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lm implements MembersInjector<li> {
    static final /* synthetic */ boolean f2472a = (!lm.class.desiredAssertionStatus());
    private final Provider<C1809a> f2473b;

    public final /* synthetic */ void injectMembers(Object obj) {
        li liVar = (li) obj;
        if (liVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        liVar.f2464a = (C1809a) this.f2473b.get();
    }

    private lm(Provider<C1809a> provider) {
        if (f2472a || provider != null) {
            this.f2473b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<li> m2129a(Provider<C1809a> provider) {
        return new lm(provider);
    }
}
