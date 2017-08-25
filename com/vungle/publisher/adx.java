package com.vungle.publisher;

import com.vungle.publisher.adv.C1677a;
import com.vungle.publisher.ady.C1678a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class adx implements MembersInjector<C1677a> {
    static final /* synthetic */ boolean f1187a = (!adx.class.desiredAssertionStatus());
    private final Provider<C1678a> f1188b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1677a c1677a = (C1677a) obj;
        if (c1677a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1677a.f1182a = (C1678a) this.f1188b.get();
    }

    private adx(Provider<C1678a> provider) {
        if (f1187a || provider != null) {
            this.f1188b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1677a> m1109a(Provider<C1678a> provider) {
        return new adx(provider);
    }
}
