package com.vungle.publisher;

import android.content.Context;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cp implements MembersInjector<cn> {
    static final /* synthetic */ boolean f1512a = (!cp.class.desiredAssertionStatus());
    private final Provider<Context> f1513b;
    private final Provider<cq> f1514c;
    private final Provider<pq> f1515d;

    public final /* synthetic */ void injectMembers(Object obj) {
        cn cnVar = (cn) obj;
        if (cnVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        cnVar.f1507a = (Context) this.f1513b.get();
        cnVar.f1508b = (cq) this.f1514c.get();
        cnVar.f1509c = (pq) this.f1515d.get();
    }

    private cp(Provider<Context> provider, Provider<cq> provider2, Provider<pq> provider3) {
        if (f1512a || provider != null) {
            this.f1513b = provider;
            if (f1512a || provider2 != null) {
                this.f1514c = provider2;
                if (f1512a || provider3 != null) {
                    this.f1515d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<cn> m1263a(Provider<Context> provider, Provider<cq> provider2, Provider<pq> provider3) {
        return new cp(provider, provider2, provider3);
    }
}
