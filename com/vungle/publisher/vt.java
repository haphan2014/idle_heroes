package com.vungle.publisher;

import com.vungle.publisher.vr.C1626a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vt implements MembersInjector<C1626a> {
    static final /* synthetic */ boolean f3475a = (!vt.class.desiredAssertionStatus());
    private final Provider<vr> f3476b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1626a c1626a = (C1626a) obj;
        if (c1626a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1626a.f817a = this.f3476b;
    }

    public static void m2555a(C1626a c1626a, Provider<vr> provider) {
        c1626a.f817a = provider;
    }
}
