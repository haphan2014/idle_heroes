package com.vungle.publisher;

import com.vungle.publisher.fp.C1769a;
import com.vungle.publisher.fv.C1773a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fs implements MembersInjector<C1769a> {
    static final /* synthetic */ boolean f1920a = (!fs.class.desiredAssertionStatus());
    private final Provider<cq> f1921b;
    private final Provider<fp> f1922c;
    private final Provider<C1773a> f1923d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1769a c1769a = (C1769a) obj;
        if (c1769a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1769a.f1530d = (cq) this.f1921b.get();
        c1769a.f1913a = this.f1922c;
        c1769a.f1914b = (C1773a) this.f1923d.get();
    }

    private fs(Provider<cq> provider, Provider<fp> provider2, Provider<C1773a> provider3) {
        if (f1920a || provider != null) {
            this.f1921b = provider;
            if (f1920a || provider2 != null) {
                this.f1922c = provider2;
                if (f1920a || provider3 != null) {
                    this.f1923d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1769a> m1792a(Provider<cq> provider, Provider<fp> provider2, Provider<C1773a> provider3) {
        return new fs(provider, provider2, provider3);
    }
}
