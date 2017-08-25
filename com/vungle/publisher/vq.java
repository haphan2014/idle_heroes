package com.vungle.publisher;

import com.vungle.publisher.vl.C1897a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vq implements MembersInjector<C1897a> {
    static final /* synthetic */ boolean f3466a = (!vq.class.desiredAssertionStatus());
    private final Provider<vl> f3467b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1897a c1897a = (C1897a) obj;
        if (c1897a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1897a.f3454a = this.f3467b;
    }

    private vq(Provider<vl> provider) {
        if (f3466a || provider != null) {
            this.f3467b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1897a> m2552a(Provider<vl> provider) {
        return new vq(provider);
    }
}
