package com.vungle.publisher;

import com.vungle.publisher.ni.C1832a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class nk implements MembersInjector<C1832a> {
    static final /* synthetic */ boolean f2650a = (!nk.class.desiredAssertionStatus());
    private final Provider<ov> f2651b;
    private final Provider<nu> f2652c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1832a c1832a = (C1832a) obj;
        if (c1832a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1832a.f2635a = this.f2651b;
        c1832a.f2636b = this.f2652c;
    }

    private nk(Provider<ov> provider, Provider<nu> provider2) {
        if (f2650a || provider != null) {
            this.f2651b = provider;
            if (f2650a || provider2 != null) {
                this.f2652c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1832a> m2211a(Provider<ov> provider, Provider<nu> provider2) {
        return new nk(provider, provider2);
    }
}
