package com.vungle.publisher;

import com.vungle.publisher.abp.C1648a;
import com.vungle.publisher.aec.C1679a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aee implements MembersInjector<C1679a> {
    static final /* synthetic */ boolean f1215a = (!aee.class.desiredAssertionStatus());
    private final Provider<C1648a> f1216b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1679a c1679a = (C1679a) obj;
        if (c1679a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1679a.f1202a = (C1648a) this.f1216b.get();
    }

    private aee(Provider<C1648a> provider) {
        if (f1215a || provider != null) {
            this.f1216b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1679a> m1134a(Provider<C1648a> provider) {
        return new aee(provider);
    }
}
