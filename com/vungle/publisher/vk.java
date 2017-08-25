package com.vungle.publisher;

import com.vungle.publisher.vf.C1623a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vk<T extends vf> implements MembersInjector<C1623a<T>> {
    static final /* synthetic */ boolean f3452a = (!vk.class.desiredAssertionStatus());
    private final Provider<pj> f3453b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1623a c1623a = (C1623a) obj;
        if (c1623a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1623a.f779a = (pj) this.f3453b.get();
    }

    public static <T extends vf> void m2547a(C1623a<T> c1623a, Provider<pj> provider) {
        c1623a.f779a = (pj) provider.get();
    }
}
