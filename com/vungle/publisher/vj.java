package com.vungle.publisher;

import com.vungle.publisher.vg.C1896a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vj implements MembersInjector<C1896a> {
    static final /* synthetic */ boolean f3450a = (!vj.class.desiredAssertionStatus());
    private final Provider<vg> f3451b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1896a c1896a = (C1896a) obj;
        if (c1896a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1896a.f3441a = this.f3451b;
    }

    private vj(Provider<vg> provider) {
        if (f3450a || provider != null) {
            this.f3451b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1896a> m2546a(Provider<vg> provider) {
        return new vj(provider);
    }
}
