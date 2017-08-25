package com.vungle.publisher;

import com.vungle.publisher.kt.C1805a;
import com.vungle.publisher.kz.C1807a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class kw implements MembersInjector<C1805a> {
    static final /* synthetic */ boolean f2405a = (!kw.class.desiredAssertionStatus());
    private final Provider<cq> f2406b;
    private final Provider<kt> f2407c;
    private final Provider<C1807a> f2408d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1805a c1805a = (C1805a) obj;
        if (c1805a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1805a.f1530d = (cq) this.f2406b.get();
        c1805a.f2398a = this.f2407c;
        c1805a.f2399b = (C1807a) this.f2408d.get();
    }

    private kw(Provider<cq> provider, Provider<kt> provider2, Provider<C1807a> provider3) {
        if (f2405a || provider != null) {
            this.f2406b = provider;
            if (f2405a || provider2 != null) {
                this.f2407c = provider2;
                if (f2405a || provider3 != null) {
                    this.f2408d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1805a> m2094a(Provider<cq> provider, Provider<kt> provider2, Provider<C1807a> provider3) {
        return new kw(provider, provider2, provider3);
    }
}
